package feedbackManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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
    @Override
    public List<Feedback> allEntries() {
        CriteriaBuilder cb = emFeedback.getCriteriaBuilder();
        CriteriaQuery<Feedback> cq = cb.createQuery(Feedback.class);
        Root<Feedback> rootEntry = cq.from(Feedback.class);
        CriteriaQuery<Feedback> all = cq.select(rootEntry);
        TypedQuery<Feedback> allQuery = emFeedback.createQuery(all);
        return allQuery.getResultList();
    }

}
