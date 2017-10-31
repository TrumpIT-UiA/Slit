package moduleManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Klasse som skal brukes av ModuleManagerBean for å behandle modulobjekter.
 */
@Entity
public class Module implements Serializable {
    @Id
    @Column
    private int moduleID;
    @Column
    private String moduleName;
    @Column
    private String learningGoals;
    @Column
    private String resources;
    @Column
    private String tasks;
    @Column
    private String approvalCriteria;

    public Module(){

    }

}
