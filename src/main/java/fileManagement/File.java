package fileManagement;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Emil-Ruud
 */

@Entity
public class File implements Serializable {
    @Id
    @Column
    @GeneratedValue
    private int fileID;
    @Column
    private int modulNr;
    @Column
    private String userEmailFile;
    @Column
    private String filename;
    @Column
    private byte[] fileContent;

    public File(String userEmailFile, int modulNr, String filename, byte[] fileContent) {
        this.userEmailFile = userEmailFile;
        this.modulNr = modulNr;
        this.filename = filename;
        this.fileContent = fileContent;
    }
    public File(){
        //Denne "constructoren" skal være tom...
    }

    // Getter og setter for fil-id
    public int getId() { return fileID; }
    public void setId(int fileID) { this.fileID = fileID; }

    // Getter og setter for nr på modul
    public int getModulNr() { return modulNr; }
    public void setModulNr(int modulNr) { this.modulNr = modulNr; }

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