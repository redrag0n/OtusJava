package hw03.generics;

import hw03.generics.fruits.Apple;
import hw03.generics.fruits.Fruit;
import hw03.generics.fruits.Orange;

import java.util.List;

public class GenericsMain {
    public static void main(String[] args) {
        Box<Apple> apples1 = new Box<>(List.of(new Apple(1.), new Apple(0.4), new Apple(0.5)));
        Box<Apple> apples2 = new Box<>(List.of(new Apple(1.), new Apple(0.4), new Apple(0.5)));
        Box<Orange> oranges = new Box<>(List.of(new Orange(1.), new Orange(0.4), new Orange(0.5)));
        Box<Fruit> fruits = new Box<>(List.of(new Orange(0.2), new Apple(0.1)));

        assert apples1.compare(apples2);
        assert !apples1.compare(oranges);

        apples1.to(fruits);
        assert apples1.getFruits().size() == 0;
        assert fruits.getFruits().size() == 5;
    }
}
