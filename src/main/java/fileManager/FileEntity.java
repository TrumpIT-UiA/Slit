package fileManager;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
public class FileEntity implements Serializable{
    @Id
    @Column
    private String id;
    @Column
    private String filename;
    @Column
    private byte[] fileContent;

    public FileEntity(String id, String filename, byte[] fileContent) {
        this.id = id;
        this.filename = filename;
        this.fileContent = fileContent;
    }
    protected FileEntity(){
        //Denne "constructoren" skal være tom...
    }

    // Getter og setter for fil-id
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    // Getter og setter for filnavn
    public String getFilename() { return filename; }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    // Getter for innhold i fil
    public byte[] getFileContent() { return fileContent; }
    public void setFileContent(byte[] fileContent) { this.fileContent = fileContent; }
}