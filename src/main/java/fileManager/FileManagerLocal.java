package fileManager;

import javax.ejb.Local;
import javax.persistence.Query;
import java.util.List;

@Local
public interface FileManagerLocal {
    FileEntity getFile(int id);
    List getListFromQuery(String query, Class<FileEntity> fileEntityClass);
    Query createQuery(String query);
    boolean saveFile(FileEntity fileEntity);
    boolean updateFile(FileEntity fileEntity);
}
