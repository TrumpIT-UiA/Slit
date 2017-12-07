package feedbackManagement;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
public class Feedback {

    @Id
    @Column
    private String primaryChunk;
    @GeneratedValue
    @Column
    private int feedbackIndex;
    @Column
    private String comment;
    @Column
    private String hiddenComment;
    @Column
    private int score;
    @Column
    private String timeWritten;

    public Feedback(String primaryChunk, String comment, String hiddenComment, int score, String timeWritten) {
        this.primaryChunk = primaryChunk;
        this.comment = comment;
        this.score = score;
        this.timeWritten = timeWritten;

    }
    public Feedback(){
        //Denne konstruktoren skal være tom.
    }

    public String getPrimaryChunk() { return primaryChunk; }

    public int getFeedbackIndex() { return feedbackIndex; }

    public String getFeedbackContent() { return comment; }

    public void setFeedbackContent(String feedbackContent) { this.comment = comment; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public String getTimeWritten() { return timeWritten; }

    public String getHiddenComment() { return hiddenComment; }

    public void setHiddenComment(String hiddenComment) { this.hiddenComment = hiddenComment; }
}