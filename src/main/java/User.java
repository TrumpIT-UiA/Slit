import javax.persistence.*;

@Entity
public class User {
    @Id
    @Column
    private String userName;
    private String fName;
    private String lName;
    @Column
    private String password;
    private String eMail;


    public User(String uName, String password) {
        this.userName = uName;
        this.password = password;
    }

    protected User(){
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
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}