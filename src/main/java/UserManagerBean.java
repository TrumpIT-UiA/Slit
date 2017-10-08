import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserManagerBean implements UserManagerLocal {

    @PersistenceContext
    EntityManager em;

    public UserManagerBean(){
    }

    @Override
    public User getUser(String id) {
        return em.find(User.class, id);
    }

    @Override
    public void saveUser(User u){
        em.persist(u);
    }
}