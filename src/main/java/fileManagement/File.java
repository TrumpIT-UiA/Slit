package fileManagement;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author Emil-Ruud
 */

@Entity
public class File implements Serializable {

    @Id
    @Column
    private String mergedNrEmail;
    @Column
    private String modulNr;
    @Column
    @NotNull
    private String userEmailFile;
    @Column
    private String filename;
    @Column
    private byte[] fileContent;

    public File(String mergedNrEmail, String userEmailFile, String modulNr, String filename, byte[] fileContent) {
        this.mergedNrEmail = mergedNrEmail;
        this.userEmailFile = userEmailFile;
        this.modulNr = modulNr;
        this.filename = filename;
        this.fileContent = fileContent;
    }
    public File(){
        //Denne "constructoren" skal være tom...
    }

    public String getMergedNrEmail() { return mergedNrEmail; }
    public void setFileID(String mergedNrEmail) { this.mergedNrEmail = mergedNrEmail; }

    // Getter og setter for nr på modul
    public String getModulNr() { return modulNr; }
    public void setModulNr(String modulNr) { this.modulNr = modulNr; }

    // Getter og setter for filnavn
    public String getFilename() { return filename; }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    // Getter for innhold i fil
    public byte[] getFileContent() { return fileContent; }
    public void setFileContent(byte[] fileContent) { this.fileContent = fileContent; }

    public String getUserEmailFile() { return userEmailFile; }
    public void setUserEmailFile(String userEmailFile) { this.userEmailFile = userEmailFile; }
}