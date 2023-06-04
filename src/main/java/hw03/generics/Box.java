package hw03.generics;

import hw03.generics.fruits.Fruit;

import java.util.List;
import java.util.ArrayList;


public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box(List<T> fruits) {
        this.fruits = new ArrayList<>(fruits.stream().toList());
    }

    public List<T> getFruits() {
        return fruits;
    }

    public <O extends T> void addFruit(O newFruit) {
        fruits.add(newFruit);
    }
    public void addFruits(List<? extends T> newFruits) {
        fruits.addAll(newFruits);
    }

    public double weight() {
        if (fruits.size() == 0) {
            return 0;
        }
        return fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public <O extends Fruit> boolean compare(Box<O> otherBox) {
        if (otherBox == null) {
            return false;
        }
        double epsilon = 0.000001d;
        return Math.abs(weight() - otherBox.weight()) < epsilon;
    }

    public void to(Box<? super T> otherBox) {
        otherBox.addFruits(fruits);
        fruits = new ArrayList<>();
    }
}