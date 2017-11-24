package fileManagement;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

/**
 * @Author Emil-Ruud
 */

@Entity
public class File implements Serializable {

    @Id
    @Column
    private String mergedNrEmail;

    @GeneratedValue
    @Column
    private int fileIndex;
    @Column
    private String modulNr;
    @Column
    @NotNull
    private String userEmailFile;
    @Column
    private String filename;
    @Column
    private long deliveredTimeMillis;
    @Column
    private byte[] fileContent;

    public File(String mergedNrEmail,String userEmailFile, String modulNr, String filename, long deliveredTimeMillis, byte[] fileContent, boolean feedback) {
        this.mergedNrEmail = mergedNrEmail;
        this.userEmailFile = userEmailFile;
        this.modulNr = modulNr;
        this.filename = filename;
        this.deliveredTimeMillis = deliveredTimeMillis;
        this.fileContent = fileContent;
    }
    public File(){
        //Denne "constructoren" skal være tom...
    }
    public String getUserEmailFile() { return userEmailFile; }
    public void setUserEmailFile(String userEmailFile) { this.userEmailFile = userEmailFile; }

    public String getMergedNrEmail() { return mergedNrEmail; }
    public void setMergedNrEmail(String mergedNrEmail) { this.mergedNrEmail = mergedNrEmail; }

    public int getIndex() { return fileIndex; }
    public void setIndex(int fileIndex) { this.fileIndex = fileIndex; }

    // Getter og setter for nr på modul
    public String getModulNr() { return modulNr; }
    public void setModulNr(String modulNr) { this.modulNr = modulNr; }

    // Getter og setter for filnavn
    public String getFilename() { return filename; }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public long getDeliveredTimeMillis() { return deliveredTimeMillis;
    }

    // Getter for innhold i fil
    public byte[] getFileContent() { return fileContent; }
    public void setFileContent(byte[] fileContent) { this.fileContent = fileContent; }
}