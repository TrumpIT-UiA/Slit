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
    public Feedback getFeedback(String primaryChunk) { return emFeedback.find(Feedback.class, primaryChunk); }

    @Override
    public boolean saveFeedback(Feedback f) {
        Feedback existing = getFeedback(f.getPrimaryChunk());
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
        Feedback existing = getFeedback(f.getPrimaryChunk());
        if (existing != null) {
            emFeedback.merge(f);
            emFeedback.flush();
        } else {
            return false;
        }
        return true;
    }

}
