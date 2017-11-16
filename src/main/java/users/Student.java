package users;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author Marius
 * Definerer brukerobjekter for Studenter
 */
@Entity
public class Student extends User implements Serializable{

    /**
     * @author Marius
     * @param email E-posten til den nye Studenten
     * @param password Passordet til den nye Studenten
     * @param fName Fornavnet til den nye Studenten
     * @param lName Etternavnet til den nye Studenten
     */
    public Student(String email, String password, String fName, String lName, String Role){
        super(email, password, fName, lName, Role);
    }

    public Student(){

    }
}
