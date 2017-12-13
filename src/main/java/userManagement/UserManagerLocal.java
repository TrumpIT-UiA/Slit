package userManagement;

import users.User;
import javax.ejb.Local;

/**
 * @author Marius
 * Interface for bruk av UserManagerBean, passer på at alle metodene finnes
 */
@Local
public interface UserManagerLocal {
    User getUser(String id);
    boolean saveUser(User u);
    boolean updateUser(User u);
}