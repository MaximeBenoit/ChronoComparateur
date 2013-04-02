/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.Client;
import metier.Montre;
import metier.Rapport;

/**
 *
 * @author benoit
 */
class MontreORMServiceImpl implements MontreORMService {

    public MontreORMServiceImpl() {
    }

    @Override
    public Montre addMontre(Montre montre) {
        ConnexionService.getPersistance();
        ConnexionService.em.persist(montre);
//        ConnexionService.em.flush();
        ConnexionService.disconect();
        return montre;
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
        Query query = ConnexionService.em.createNamedQuery("montreGetAll");
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

    @Override
    public List<Montre> getByProprietaire(Client proprietaire) throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("getMontreByProprietaire");
        query.setParameter("proprietaire", proprietaire);
        List<Montre> montre = query.getResultList();
        ConnexionService.disconect();
        return montre;
    }
    public List<Montre> getByProprietaire(Client proprietaire,int index,int nb) throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("getMontreByProprietaire");
        query.setParameter("proprietaire", proprietaire);
        query.setFirstResult(index).setMaxResults(nb);
        List<Montre> montre = query.getResultList();
        ConnexionService.disconect();
        return montre;
    }

    @Override
    public Montre getByRapport(Rapport rapport) throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("getMontreByRapport");
        query.setParameter("rapport", rapport);
        Montre montre = (Montre) query.getSingleResult();
        ConnexionService.disconect();
        return montre;
    }
}
