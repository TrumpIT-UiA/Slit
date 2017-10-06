import javax.ejb.Local;

@Local
public interface UserManagerLocal {
    User getUser(String id);
    void saveUser(User u);
}