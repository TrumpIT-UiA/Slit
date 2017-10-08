import javax.ejb.Local;
import java.util.List;

@Local
public interface UserManagerLocal {
    User getUser(String id);
    void saveUser(User u);
}