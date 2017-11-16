package users;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Marius
 * Klasse for å definere brukerobjekter
 */
@Entity
public abstract class User implements Serializable{
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
    private String Role;

    /**
     *
     * @param email E-posten til en bruker
     * @param password Passordet til en bruker
     * @param fName Fornavnet til en bruker
     * @param lName Etternavnet til en bruker
     */
    public User(String email, String password, String fName, String lName, String Role) {
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.Role = Role;
    }

    protected User(){
    }

    /**
     * Henter ut brukerens e-post
     * @return Brukerens e-post
     */
    public String getEmail() {
        return email;
    }

    /**
     * Henter ut brukerens navn
     * @return Brukerens navn
     */
    public String getfName() {
        return fName;
    }

    /**
     * Lar deg sette nytt fornavn på en bruker
     * @param fName Navnet du ønsker å sette
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Henter ut brukerens etternavn
     * @return Etternavnet til brukeren
     */
    public String getlName() {
        return lName;
    }

    /**
     * Lar deg endre etternavnet til brukeren
     * @param lName Etternavnet du ønsker å sette
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Henter ut brukerens passord
     * @return Brukerens passord
     */
    public String getPassword() {
        return password;
    }

    /**
     * Lar deg endre passordet til en bruker
     * @param password Passordet du ønsker å sette
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Lar deg endre e-posten til en bruker
     * @param email Brukerens e-post
     */
    public void setEmail(String email) {
        this.email = email;
    }
}