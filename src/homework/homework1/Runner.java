package homework.homework1;

import homework.homework1.ex1.animal.Bird;
import homework.homework1.ex1.animal.Dog;
import homework.homework1.ex1.animal.Tiger;
import homework.homework1.ex1.zoo.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ex1();
        System.out.println("-------");
        ex2();
        System.out.println("-------");
        ex3();
    }

    public static void ex1() {
        Tiger tiger = new Tiger();
        Dog dog = new Dog();
        Bird bird = new Bird();
        Zoo<Tiger, Dog, Bird> zoo = new Zoo<>(new Tiger(), new Dog(), new Bird());
        Bird animal3 = zoo.getThirdAnimal();
        animal3.fly();
    }

    public static void ex2() {
        ArrayList<Integer> january = new ArrayList<>(List.of(-1, -1, -2, -5, -6, -7, -8, -9, -10, -5,
                -5, -2, -7, -3, -1, -8, -9, -8, -8, -18, -20, -23, -24, -25, -9, -8, -7, -6, -5, -1));
        ArrayList<Integer> february = new ArrayList<>(List.of(-8, -10, -12, -13, -15, -16, -12, -7, -8,
                -10, -10, -9, -8, -8, -8, -9, -10, -9, -5, -6, -8, -7, -8, -9, -6, -5, -3, -1));
        january.addAll(february);
        double averageTemperature = monthAverageTemperature(january);
        averageTemperature = Math.round(averageTemperature * 10.0) / 10.0;
        System.out.println(averageTemperature);
    }

    public static double monthAverageTemperature(ArrayList<Integer> month) {
        double monthAverageTemperature = 0;
        for (int sumMonth : month) {
            monthAverageTemperature += sumMonth;
        }
        return monthAverageTemperature / month.size();
    }

    public static void ex3() {
        ArrayList<String> monday = new ArrayList<>(List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо"));
        ArrayList<String> tuesday = new ArrayList<>(List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон", "Реберная"));
        ArrayList<String> wednesday = new ArrayList<>(List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим"));
        ArrayList<String> thursday = new ArrayList<>(List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо"));
        ArrayList<String> friday = new ArrayList<>(List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька"));
        ArrayList<String> commonRestaurants = new ArrayList<>(monday);

        commonRestaurants.retainAll(tuesday);
        commonRestaurants.retainAll(wednesday);
        commonRestaurants.retainAll(thursday);
        commonRestaurants.retainAll(friday);
        System.out.println("Рестораны, которые Николай Петрович посещал каждый день: " + commonRestaurants);
    }
}