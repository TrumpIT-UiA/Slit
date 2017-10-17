package users;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class AssistantTeacher extends User implements Serializable {

    public AssistantTeacher (String email, String password, String fName, String lName){
        super(email, password, fName, lName);
    }

    public AssistantTeacher(){
    }
}
