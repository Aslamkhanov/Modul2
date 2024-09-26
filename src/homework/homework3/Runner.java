package homework.homework3;

import homework.homework3.ex1.Apple;
import homework.homework3.ex1.Apricot;
import homework.homework3.ex1.Garden;
import homework.homework3.ex2.Divination;
import homework.homework3.ex2.Human;
import homework.homework3.ex3.Burning;
import homework.homework3.ex3.Tree;
import homework.homework3.ex3.Uranium;
import homework.homework3.ex4.Animal;
import homework.homework3.ex4.Boat;
import homework.homework3.ex4.Ruler;
import homework.homework3.ex5.Review;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.TreeSet;

public class Runner {
    private static final int AGE_HEIGHT_MORE = 210;
    public static void main(String[] args) {
        ex1();
        System.out.println("--------------------");
        ex2();
        System.out.println("--------------------");
        ex3();
        System.out.println("--------------------");
        ex4();
        System.out.println("--------------------");
        ex5();

    }

    public static void ex1() {
        Garden<Apple> appleFarm = () -> new Apple();
        Garden<Apricot> apricotFarm = () -> new Apricot();

        Apple apple = appleFarm.growFruit();
        Apricot apricot = apricotFarm.growFruit();
    }

    public static void ex2() {
        //не в константе т.к. условно для показа работы метода.
        Human humanAnbu = new Human(34, 175);
        Divination<String> chamomile = (String name) -> name.length() % 2 == 0;
        Divination<Human> grandmaFortuneTeller = (Human human) ->
                (human.getAge() + human.getHeight()) > AGE_HEIGHT_MORE;

        System.out.println("Количество букв в строке: " + chamomile.guess("Anbu"));
        System.out.println("Возраст + рост: " + (grandmaFortuneTeller.guess(humanAnbu) ? "больше 210" : "меньше 210"));
    }

    public static void ex3() {
        Burning<Uranium> nuclearReactor = uranium -> System.out.println("зеленый свет вокруг!");
        Burning<Tree> bonfire = tree -> System.out.println("желто-красный свет вокруг!");
    }

    public static void ex4() {
        //не в константе т.к. условно для показа работы метода.
        Boat boat1 = new Boat(7);
        Animal animal1 = new Animal(2, 5);

        Ruler<Boat> boatMeter = boat -> boat.getLength();
        Ruler<Animal> animalMeter = animal -> animal.getBodyLength() + animal.getTailLength();

        System.out.println("Длина лодки: " + boatMeter.rule(boat1));
        System.out.println("Длина тела и хвоста животного: " + animalMeter.rule(animal1));
    }

    public static void ex5() {
        Comparator<Review> comparator = (rev1, rev2) -> {
            if (rev1.getNumberOfLikes() < rev2.getNumberOfLikes()) {
                return 1;
            } else if (rev1.getNumberOfLikes() > rev2.getNumberOfLikes()) {
                return -1;
            } else {
                if (rev1.getLocalDateTime().isBefore(rev2.getLocalDateTime())) {
                    return 1;
                } else if (rev1.getLocalDateTime().isAfter(rev2.getLocalDateTime())) {
                    return -1;
                } else {
                    if (rev1.getIdReview() < rev2.getIdReview()) {
                        return 1;
                    } else if (rev1.getIdReview() > rev2.getIdReview()) {
                        return -1;
                    }
                    return 0;
                }
            }
        };

        TreeSet<Review> reviews = new TreeSet<>(comparator);
        //не в константе т.к. условно для показа работы метода.
        reviews.add(new Review(3, "плохой товар", 67,
                LocalDateTime.of(2024, 5, 3, 13, 37)));
        reviews.add(new Review(1, "отличный товар", 200,
                LocalDateTime.of(2024, 5, 3, 16, 37)));
        reviews.add(new Review(4, "плохой товар", 55,
                LocalDateTime.of(2024, 5, 3, 13, 37)));
        reviews.add(new Review(2, "так себе товар", 100,
                LocalDateTime.of(2024, 5, 3, 13, 37)));

        System.out.println(reviews);
    }
}
