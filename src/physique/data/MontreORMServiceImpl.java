/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.Client;
import metier.Montre;

/**
 *
 * @author benoit
 */
class MontreORMServiceImpl implements MontreORMService {

    public MontreORMServiceImpl() {
    }

    @Override
    public void addMontre(Montre montre) {
         ConnexionService.getPersistance();
        ConnexionService.em.persist(montre);
        ConnexionService.disconect();
    }

    @Override
    public void removeMontre(Montre montre) {
         ConnexionService.getPersistance();
        ConnexionService.em.remove(ConnexionService.em.merge(montre));
        ConnexionService.disconect();
    }

    @Override
    public void updateMontre(Montre montre) {
        ConnexionService.getPersistance();
        ConnexionService.em.merge(montre);
        ConnexionService.disconect();
    }

    @Override
    public List<Montre> getAll() throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("montretGetAll");
        List<Montre> montres = query.getResultList();
       ConnexionService.disconect();
        return montres;
    }

    @Override
    public Montre getById(long id) {
         ConnexionService.getPersistance();
        Montre montre = ConnexionService.em.find(Montre.class, id);
        ConnexionService.disconect();
        return montre;
    }

    @Override
    public List<Montre> getByFabricant(String fabricant) {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("getMontreByFabricant");
        query.setParameter("fabricant", fabricant);//
        List<Montre> montre = query.getResultList();
        ConnexionService.disconect();
        return montre;
    }
    
}
