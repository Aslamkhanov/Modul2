package homework.homework4;

import homework.homework4.ex1.Car;
import homework.homework4.ex3.Skyscraper;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        ex1();
        System.out.println("______________________");
        ex2();
        System.out.println("______________________");
        ex3();


    }

    public static void ex1() {
        int firstNumber = 1;
        int lastNumber = 50;
        String topNumbers = "04";

        Set<Car> carNumberA = Stream.iterate(firstNumber, number -> number + 1)
                .limit(lastNumber - firstNumber + 1)
                .map(number -> new Car("а0%02dан799".formatted(number)))
                .collect(Collectors.toSet());

        Set<Car> carNumberK = Stream.iterate(firstNumber, number -> number + 1)
                .limit(lastNumber - firstNumber + 1)
                .map(number -> new Car("к0%02dсе178".formatted(number)))
                .collect(Collectors.toSet());

        Stream.concat(carNumberA.stream(), carNumberK.stream())
                .filter(car -> car.getCarNumber().startsWith(topNumbers, 1))
                .map(Car::getCarNumber)
                .sorted()
                .forEach(System.out::println);
    }

    public static void ex2() {
        Set<String> words = Set.of("тон", "тополь", "боль", "рой", "стройка");
        int sum = words.stream()
                .mapToInt(word -> word.length() - word.replaceAll("о", "").length())
                .sum();
        System.out.println(sum);
    }

    public static void ex3() {
        Skyscraper worldTradeCenter = new Skyscraper("WorldTradeCenter", 541);
        Skyscraper shanghaiTower = new Skyscraper("ShanghaiTower", 632);
        Skyscraper burjKhalifa = new Skyscraper("BurjKhalifa", 828);
        Skyscraper pinganInternationalFinancialCenter =
                new Skyscraper("PinganInternationalFinancialCenter", 599);
        Skyscraper abrajAlBayt = new Skyscraper("AbrajAl-Bayt", 601);
        Skyscraper lotteWorldCenter = new Skyscraper("LotteWorldCenter", 555);

        List<Skyscraper> skyscraperList = List.of(worldTradeCenter, shanghaiTower, burjKhalifa,
                pinganInternationalFinancialCenter, abrajAlBayt, lotteWorldCenter, burjKhalifa);

        List<Skyscraper> newListSkyscraper = skyscraperList.stream().distinct().toList();

        newListSkyscraper.stream().limit(3).forEach(System.out::println);
        System.out.println("_____________________");

        newListSkyscraper.stream().sorted(Comparator.comparingInt(Skyscraper::getHeightInMeters))
                .limit(1)
                .forEach(System.out::println);

        int maxHeightInMeters = 1000;
        newListSkyscraper.stream()
                .filter(skyscraper -> skyscraper.getHeightInMeters() > maxHeightInMeters)
                .peek(System.out::println)
                .findFirst()
                .ifPresentOrElse(skyscraper -> {
                }, () -> System.out.println("небоскреба выше километра - нет"));
    }
}
