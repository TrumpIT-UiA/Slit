package moduleManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Klasse som skal brukes av ModuleManagerBean for å behandle modulobjekter.
 */
@Entity
public class Module implements Serializable {
    @Id
    @Column
    private int moduleID;
    @Column
    private String learningGoals;
    @Column
    private String resources;
    @Column
    private String tasks;
    @Column
    private String approvalCriteria;
    @Column
    private String deadline;

    public Module(int moduleID, String learningGoals, String resources, String tasks, String approvalCriteria, String deadline) {
        this.moduleID = moduleID;
        this.learningGoals = learningGoals;
        this.resources = resources;
        this.tasks = tasks;
        this.approvalCriteria = approvalCriteria;
        this.deadline = deadline;

    }
    public Module(){

    }


    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}
