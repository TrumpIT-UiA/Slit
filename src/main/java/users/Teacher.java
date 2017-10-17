package users;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Teacher extends User implements Serializable {

    public Teacher(String email, String password, String fName, String lName){
        super(email, password, fName, lName);
    }

    public Teacher(){

    }
}
