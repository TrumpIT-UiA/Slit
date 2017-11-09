package userManagement;

import users.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * En klasse for å håndtere lagringen av brukerobjekter i databasen
 */
@Stateless
public class UserManagerBean implements UserManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public UserManagerBean(){
    }

    /**
     * Lar deg finne en spesifik bruker i databasen.
     * @param id Primary key i databasen.
     */
    @Override
    public User getUser(String id) {
        return em.find(User.class, id);
    }

    /**
     * Lar deg lagre en bruker i databasen.
     * @param u Brukerobjektet du ønsker å lagre.
     * @return Returnerer true eller false dersom operasjonen er gyldig/ugyldig.
     */
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

    /**
     * Lar deg oppdatere en bruker i databasen.
     * @param u Brukerobjektet du ønsker å oppdatere.
     * @return Returnerer true/false avhengig av om operasjonen er gyldig/ugyldig.
     */
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
