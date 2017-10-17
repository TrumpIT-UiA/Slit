package userManagement;

import users.User;

import javax.ejb.Local;

@Local
public interface UserManagerLocal {
    User getUser(String id);
    boolean saveUser(User u);
    boolean updateUser(User u);
}