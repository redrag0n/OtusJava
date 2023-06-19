package hw04;

import hw04.annotations.Test;
import hw04.annotations.Before;
import hw04.annotations.After;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestLauncher {
    private static <T> T getClassInstance(Class<T> clazz) {
        T classInstance;
        try {
            classInstance = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return classInstance;
    }

    public static <T> void launch(Class<T> clazz) {
        Method[] methods = clazz.getMethods();
        int exceptionCount = 0;
        int testCount = 0;

        List<Method> beforeMethods = Arrays.stream(methods).sequential()
                .filter(m -> m.isAnnotationPresent(Before.class)).toList();

        List<Method> afterMethods = Arrays.stream(methods).sequential()
                .filter(m -> m.isAnnotationPresent(After.class)).toList();

        List<Method> testMethods = Arrays.stream(methods).sequential()
                .filter(m -> m.isAnnotationPresent(Test.class)).toList();

        for (Method testMethod: testMethods){
            testCount++;
            try {
                T classInstance = getClassInstance(clazz);
                for (Method beforeMethod : beforeMethods) {
                    beforeMethod.invoke(classInstance);
                }
                testMethod.invoke(classInstance);
                for (Method afterMethod : afterMethods) {
                    afterMethod.invoke(classInstance);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                exceptionCount++;
            }
        }
        System.out.format("%d tests were processed, %d succeed, %d failed",
                testCount, testCount - exceptionCount, exceptionCount);
    }

    public static void main(String[] args) {
        launch(Tester.class);
    }
}
