package feedbackManagement;

import javax.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue
    @Column
    private int feedbackID;
    @Column
    private String feedback;
    @Column
    private int score;

    public Feedback(String feedback, int score) {
        this.feedback = feedback;
        this.score = score;

    }
    public Feedback(){
        //Denne konstruktoren skal være tom.
    }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public String getFeedback() { return feedback; }

    public void setFeedback(String feedback) { this.feedback = feedback; }

    public int getFeedbackID() { return feedbackID; }
}