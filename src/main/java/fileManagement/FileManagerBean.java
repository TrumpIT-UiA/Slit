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
    public File getFile(int id) { return emFile.find(File.class, id); }

    @Override
    public boolean saveFile(File file) {
        File existing = getFile(file.getId());
        if (existing == null) {
            emFile.persist(file);
            emFile.flush();
        } else {
            return false;
        }
        return true;
    }

    public boolean updateFile(File file) {
        File existing = getFile(file.getId());
        if (existing != null) {
            emFile.persist(file);
        } else {
            return false;
        }
        return true;
    }
}
