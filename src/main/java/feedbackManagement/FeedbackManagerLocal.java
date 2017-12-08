package feedbackManagement;

import javax.ejb.Local;

public interface FeedbackManagerLocal {
    Feedback getFeedback(String primaryChunk);
    boolean saveFeedback(Feedback f);
    boolean updateFeedback(Feedback f);
}
