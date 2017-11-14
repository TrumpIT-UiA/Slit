package feedbackManagement;

import javax.ejb.Local;

public interface FeedbackManagerLocal {
    Feedback getFeedback(int feedbackID);
    boolean saveFeedback(Feedback f);
    boolean updateFeedback(Feedback f);
}
