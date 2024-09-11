package homework.homework2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Runner {
    static final int BATCH_SIZE = 10;
    static int count = 1;

    public static void main(String[] args) {
        ex1();
        System.out.println("--------------------------");
        HashMap<String, BigDecimal> result = ex2();
        for (HashMap.Entry<String, BigDecimal> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }

    public static void ex1() {
        String fileLuggage = "luggage.csv";

        LinkedList<String> luggageLine = new LinkedList<>();
        try (Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream(fileLuggage))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                luggageLine.add(parts[0]);

                if (++counter % BATCH_SIZE == 0) {
                    System.out.println("Начинается загрузка на ленту ");
                    System.out.println("Лента загружена, начинается выдача багажа.");
                    luggageBatch(luggageLine);
                    System.out.println("Лента пустая, закончена выдача багажа");
                    luggageLine.clear();
                }
            }
        }
    }

    private static void luggageBatch(LinkedList<String> batch) {
        for (String numberLuggage : batch) {
            System.out.println(count++ + " - " + numberLuggage + " выдан");
        }
    }

    public static HashMap<String, BigDecimal> ex2() {

        HashMap<String, BigDecimal> categories = new HashMap<>();
        categories.put("легкий", BigDecimal.ZERO);
        categories.put("средний", BigDecimal.ZERO);
        categories.put("тяжелый", BigDecimal.ZERO);

        String filename = "luggage.csv";
        try (Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream(filename))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                BigDecimal weight = new BigDecimal(Integer.parseInt(parts[1].trim()));

                if (weight.compareTo(BigDecimal.valueOf(5)) <= 0) {
                    categories.put("легкий", categories.get("легкий").add(weight));
                } else if (weight.compareTo(BigDecimal.valueOf(5)) > 0 &&
                        weight.compareTo(BigDecimal.valueOf(10)) <= 0) {
                    categories.put("средний", categories.get("средний").add(weight));
                } else if (weight.compareTo(BigDecimal.valueOf(10)) > 0) {
                    categories.put("тяжелый", categories.get("тяжелый").add(weight));
                }
            }
        }
        return categories;
    }
}
