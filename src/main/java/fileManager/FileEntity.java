package fileManager;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FileEntity implements Serializable {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String filename;
    @Column
    private byte[] fileContent;

    public FileEntity(String filename, byte[] fileContent) {
        this.filename = filename;
        this.fileContent = fileContent;
    }
    protected FileEntity(){
        //Denne "constructoren" skal være tom...
    }

    // Getter og setter for fil-id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // Getter og setter for filnavn
    public String getFilename() { return filename; }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    // Getter for innhold i fil
    public byte[] getFileContent() { return fileContent; }
    public void setFileContent(byte[] fileContent) { this.fileContent = fileContent; }
}