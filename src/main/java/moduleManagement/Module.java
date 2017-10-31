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

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getLearningGoals() {
        return learningGoals;
    }

    public void setLearningGoals(String learningGoals) {
        this.learningGoals = learningGoals;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getApprovalCriteria() {
        return approvalCriteria;
    }

    public void setApprovalCriteria(String approvalCriteria) {
        this.approvalCriteria = approvalCriteria;
    }
}
