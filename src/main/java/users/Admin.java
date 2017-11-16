package users;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author Marius
 * Definerer brukerobjekter for Administratorer
 */
@Entity
public class Admin extends User implements Serializable{

    /**
     * @author Marius
     * @param email E-posten til den nye Administratoren
     * @param password Passordet til den nye Administratoren
     * @param fName Fornavnet til den nye Administratoren
     * @param lName Etternavnet til den nye Administratoren
     */
    public Admin(String email, String password, String fName, String lName, String Role){
        super(email, password, fName, lName, Role);
    }

    protected Admin(){

    }
}
