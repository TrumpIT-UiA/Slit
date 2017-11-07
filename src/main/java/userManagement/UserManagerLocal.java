package userManagement;

import users.User;
import javax.ejb.Local;

/**
 * Interface for bruk av UserManagerBean
 */
@Local
public interface UserManagerLocal {
    User getUser(String id);
    boolean saveUser(User u);
    boolean updateUser(User u);
}