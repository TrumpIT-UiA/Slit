package moduleManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author Vebjørn
 * Denne klassen er en EntityManager som behandler Module.
 */

@Stateless
public class ModuleManagerBean implements ModuleManagerLocal {

    /**
     * Oppretter et entity manager objekt
     */
    @PersistenceContext
    private EntityManager em;

    public ModuleManagerBean() {

    }

    /**
     * Henter ut et modulobjekt
     * @param id Modulens ID
     * @return Et modulobjekt
     */
    @Override
    public Module getModule(int id) {
        return em.find(Module.class, id);
    }


    /**
     * @param Modulen som skal lagres i databasen.
     * @return boolean som returnerer false om modulen allerede finnes, og true hvis lagringen var vellykket.
     */
    @Override
    public boolean saveModule(Module module) {
        Module existing = getModule(module.getModuleID());
        if (existing == null) {
            em.persist(module);
        } else {
            return false;
        }
        return true;
    }

    /**
     * Oppdaterer et modulobjekt hvis det eksisterer.
     * @param module Modulobjektet som skal erstatte det eksisterende modulobjektet.
     * @return Returnerer boolean false hvis modulobjektet ikke eksisterer allerede og true hvis oppdateringen ble gjennomført.
     */
    public boolean updateModule(Module module) {
        Module existing = getModule(module.getModuleID());
        if (existing != null) {
            em.merge(module);
            em.flush();

        } else {
            return false;
        }
        return true;
    }
}

