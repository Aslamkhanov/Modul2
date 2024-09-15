package homework.homework3.ex2;

@FunctionalInterface
public interface Divination<T> {
    boolean guess(T t);
}
