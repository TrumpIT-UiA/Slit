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
    private int id;
    @Column
    private int modulNr;
    @Column
    private String filename;
    @Column
    private byte[] fileContent;

    public File(String filename, byte[] fileContent) {
        this.filename = filename;
        this.fileContent = fileContent;
    }
    public File(){
        //Denne "constructoren" skal være tom...
    }

    // Getter og setter for fil-id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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
}