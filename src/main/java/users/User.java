package users;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class  User implements Serializable{
    @Id
    @Column
    private String email;
    @Column
    private String fName;
    @Column
    private String lName;
    @Column
    private String password;
    @Column
    private String role;


    public User(String email, String password, String fName, String lName, String role) {
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.role = role;
    }

    protected User(){
    }

    public String getEmail() {
        return email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}