package homework.homework3.ex5;

import java.time.LocalDateTime;

public class Review {
    private int idReview;
    private String reviewText;
    private int numberOfLikes;
    private LocalDateTime localDateTime;

    public Review(int idReview, String reviewText, int numberOfLikes, LocalDateTime localDateTime) {
        this.idReview = idReview;
        this.reviewText = reviewText;
        this.numberOfLikes = numberOfLikes;
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Review: " +
                "idReview: " + idReview +
                ", reviewText: " + reviewText + '\'' +
                ", numberOfLikes: " + numberOfLikes +
                ", localDateTime: " + localDateTime +
                '}';
    }

    public int getIdReview() {
        return idReview;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
