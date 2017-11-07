package users;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Admin extends User implements Serializable{

    public Admin(String email, String password, String fName, String lName){
        super(email, password, fName, lName);
    }

    protected Admin(){

    }
}
