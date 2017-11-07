package fileManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author Emil-Ruud
 */

@Stateless
public class FileManagerBean implements FileManagerLocal {

    @PersistenceContext
    private EntityManager emFile;

    public FileManagerBean() {
        // Når persistence/stateless/entitymanager blir brukt MÅ det være en tom constructor
    }

    @Override
    public FileEntity getFile(int id) { return emFile.find(FileEntity.class, id); }

    @Override
    public boolean saveFile(FileEntity fileEntity) {
        FileEntity existing = getFile(fileEntity.getId());
        if (existing == null) {
            emFile.persist(fileEntity);
            emFile.flush();
        } else {
            return false;
        }
        return true;
    }

    public boolean updateFile(FileEntity fileEntity) {
        FileEntity existing = getFile(fileEntity.getId());
        if (existing != null) {
            emFile.persist(fileEntity);
        } else {
            return false;
        }
        return true;
    }
}
