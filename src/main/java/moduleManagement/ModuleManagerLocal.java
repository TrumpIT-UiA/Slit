package moduleManagement;


import javax.ejb.Local;

/**
 * Interface som lager abstrakte metoder som overrides i ModuleManagerBean
 */

@Local
public interface ModuleManagerLocal {
    Module getModule(int id);
    boolean saveModule(Module module);
}
