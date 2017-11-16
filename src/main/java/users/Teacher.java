package users;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author Marius
 * Definerer brukerobjekter for lærere
 */
@Entity
public class Teacher extends User implements Serializable {

    /**
     * @author Marius
     * @param email E-posten til den nye læreren
     * @param password Passordet til den nye læreren
     * @param fName Fornavnet til den nye læreren
     * @param lName Etternavnet til den nye læreren
     */
    public Teacher(String email, String password, String fName, String lName, String Role){
        super(email, password, fName, lName, Role);
    }

    public Teacher(){

    }
}
