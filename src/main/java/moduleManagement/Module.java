package moduleManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**@Author Vebjørn
 * Module entity som håndteres av ModuleManagerBean
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

    /**
     *
     * @param moduleID Modulens ID som brukes som primærnøkkel i databasen.
     * @param learningGoals Modulens læringsmål.
     * @param resources Linker til ressurser som kan hjelpe studenten i modulen.
     * @param tasks Oppgaver som skal gjennomføres i modulen
     * @param approvalCriteria Kriterier for at modulinnleveringen godkjennes.
     * @param deadline Dato modulen skal være levert innen.
     */
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

    /**
     * Henter ut modul ID.
     * @return Modulens ID
     */
    public int getModuleID() {
        return moduleID;
    }

    /**
     * Gir modulen en ny ID
     * @param moduleID Modulens nye ID
     */
    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    /**
     *Henter ut læringsmålene
     * @return Modulens læringsmål
     */
    public String getLearningGoals() {
        return learningGoals;
    }

    /**
     * Tilegner modulen nye læringsmål
     * @param learningGoals De nye læringsmålene på modulen.
     */
    public void setLearningGoals(String learningGoals) {
        this.learningGoals = learningGoals;
    }

    /**
     * Henter ut læringsressursene som er tilknyttet modulen
     * @return læringsressursene til modulen
     */
    public String getResources() {
        return resources;
    }

    /**
     * Tilegner modulen nye læringsressurser
     * @param resources de nye læringsressursene modulen skal ha
     */
    public void setResources(String resources) {
        this.resources = resources;
    }

    /**
     * Henter oppgavene som skal gjennomføres av studenten i modulen
     * @return oppgavene som skal gjennomføres
     */
    public String getTasks() {
        return tasks;
    }

    /**
     * Tilegner modulen nye oppgaver
     * @param tasks de nye oppgavene til modulen
     */
    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    /**
     * Henter ut kriteriene til modulen
     * @return Modulens kriterier
     */
    public String getApprovalCriteria() {
        return approvalCriteria;
    }

    /**
     * Tilegner modulen nye kriterier
     * @param approvalCriteria Modulens nye kriterier
     */
    public void setApprovalCriteria(String approvalCriteria) {
        this.approvalCriteria = approvalCriteria;
    }

    /**
     * Henter ut innleveringsfristen for modulen.
     * @return Modulens innleveringsfrist
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * angir ny innleveringsfrist på modulen
     * @param deadline Den nye innleveringsfristen
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}
