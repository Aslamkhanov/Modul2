package homework.homework3.ex1;

@FunctionalInterface
public interface Garden<T extends Fruit> {
    T growFruit();
}
