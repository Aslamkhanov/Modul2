package homework.homework1.ex1.zoo;

import homework.homework1.ex1.animal.Animal;

public class Zoo<T extends Animal, A extends Animal, B extends Animal> {
    private T firstAnimal;
    private A secondAnimal;
    private B thirdAnimal;

    public Zoo(T firstAnimal, A secondAnimal, B thirdAnimal) {
        this.firstAnimal = firstAnimal;
        this.secondAnimal = secondAnimal;
        this.thirdAnimal = thirdAnimal;
    }

    public T getFirstAnimal() {
        return firstAnimal;
    }

    public A getSecondAnimal() {
        return secondAnimal;
    }

    public B getThirdAnimal() {
        return thirdAnimal;
    }
}
