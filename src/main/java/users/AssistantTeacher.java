package users;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author Marius
 * Definerer brukerobjekter for Hjelpelærere
 */
@Entity
public class AssistantTeacher extends User implements Serializable {

    /**
     * @author Marius
     * @param email E-posten til den nye Hjelpelæreren
     * @param password Passordet til den nye Hjelpelæreren
     * @param fName Fornavnet til den nye Hjelpelæreren
     * @param lName Etternavnet til den nye Hjelpelæreren
     */
    public AssistantTeacher (String email, String password, String fName, String lName, String Role){
        super(email, password, fName, lName, Role);
    }

    public AssistantTeacher(){
    }
}
