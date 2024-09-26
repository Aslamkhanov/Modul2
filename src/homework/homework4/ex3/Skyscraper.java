package homework.homework4.ex3;

public class Skyscraper {
    private String nameSkyscraper;
    private int heightInMeters;

    public Skyscraper(String nameSkyscraper, int heightInMeters) {
        this.nameSkyscraper = nameSkyscraper;
        this.heightInMeters = heightInMeters;
    }

    public String getNameSkyscraper() {
        return nameSkyscraper;
    }

    public int getHeightInMeters() {
        return heightInMeters;
    }

    @Override
    public String toString() {
        return "Skyscraper{" +
                "nameSkyscraper='" + nameSkyscraper + '\'' +
                ", heightInMeters=" + heightInMeters +
                '}';
    }
}
