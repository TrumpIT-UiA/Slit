package feedbackManagement;

import java.util.List;

public interface FeedbackManagerLocal {
    Feedback getFeedback(String primaryChunk);
    boolean saveFeedback(Feedback f);
    boolean updateFeedback(Feedback f);
    public List allEntries();
}
