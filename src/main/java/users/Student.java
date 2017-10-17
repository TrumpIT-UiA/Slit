package users;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Student extends User implements Serializable{

    public Student(String email, String password, String fName, String lName){
        super(email, password, fName, lName);
    }

    public Student(){

    }
}
