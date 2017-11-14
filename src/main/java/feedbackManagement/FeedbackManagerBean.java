package feedbackManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Emil-Ruud
 */

@Stateless
public class FeedbackManagerBean implements FeedbackManagerLocal {

    @PersistenceContext
    private EntityManager emFeedback;

    public FeedbackManagerBean() {
        //Stateless skal ha tom constructor
    }

    @Override
    public Feedback getFeedback(int feedbackID) { return emFeedback.find(Feedback.class, feedbackID); }

    @Override
    public boolean saveFeedback(Feedback f) {
        Feedback existing = getFeedback(f.getFeedbackID());
        if (existing == null) {
            emFeedback.persist(f);
            emFeedback.flush();
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateFeedback(Feedback f) {
        Feedback existing = getFeedback(f.getFeedbackID());
        if (existing != null) {
            emFeedback.remove(existing);
            emFeedback.persist(f);
            emFeedback.flush();
        } else {
            return false;
        }
        return true;
    }

}
