package hw01.gradle;

import java.util.Set;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;


public class HelloOtus {
    public static void main(String[] args) {
        Set<Character> first = ImmutableSet.of('a', 'b', 'c');
        Set<Character> second = ImmutableSet.of('b', 'c', 'd');

        Set<Character> union = Sets.union(first, second);
        System.out.println(union);
    }
}