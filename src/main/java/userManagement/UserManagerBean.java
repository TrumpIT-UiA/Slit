package userManagement;

import users.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UserManagerBean implements UserManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public UserManagerBean(){
    }

    @Override
    public User getUser(String id) {
        return em.find(User.class, id);
    }

    @Override
    public boolean saveUser(User u){
        User existing = getUser(u.getEmail().toLowerCase());
        if  (existing == null){
            em.persist(u);
        } else{
            return false;
        }
        return true;
    }

    public boolean updateUser(User u){
        User existing = getUser(u.getEmail().toLowerCase());
        if  (existing == null){
            em.merge(u);
        } else{
            return false;
        }
        return true;
        }
    }
