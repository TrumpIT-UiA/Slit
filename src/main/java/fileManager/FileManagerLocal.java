package fileManager;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FileManagerLocal {
    FileEntity getFile(int id);
    List getFromQuery(String query, Class<FileEntity> fileEntityClass);
    boolean saveFile(FileEntity fileEntity);
    boolean updateFile(FileEntity fileEntity);
}
