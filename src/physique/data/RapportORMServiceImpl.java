/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import metier.Montre;
import metier.Rapport;

/**
 *
 * @author benoit
 */
class RapportORMServiceImpl implements RapportORMService {

    public RapportORMServiceImpl() {
    }

    @Override
    public Rapport addRapport(Rapport rapport) {
        ConnexionService.getPersistance();
        ConnexionService.em.persist(rapport);
        ConnexionService.disconect();
        return rapport;
    }

    @Override
    public void removeRapport(Rapport rapport) {
        ConnexionService.getPersistance();
        ConnexionService.em.remove(ConnexionService.em.merge(rapport));
        ConnexionService.disconect();
    }

    @Override
    public void updateRapport(Rapport rapport) {
        ConnexionService.getPersistance();
        ConnexionService.em.merge(rapport);
        ConnexionService.disconect();
    }

    @Override
    public List<Rapport> getAll() throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("rapportGetAll");
        List<Rapport> rapports = query.getResultList();
        return rapports;
    }

    @Override
    public Rapport getById(long id) {
        ConnexionService.getPersistance();
        Rapport rapport = ConnexionService.em.find(Rapport.class, id);
        ConnexionService.disconect();
        return rapport;
    }

    @Override
    public List<Rapport> getByDateUpdate(Date dateUpdate) {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("rapportGetByDateUpdate");
        query.setParameter("dateUpdate", dateUpdate);
        List<Rapport> rapports = query.getResultList();
        ConnexionService.disconect();
        return rapports;
    }

//    @Override
//    public Rapport getByMontre(Montre montre) {
//        ConnexionService.getPersistance();
//        Query query = ConnexionService.em.createNamedQuery("rapportGetByMontre");
//        query.setParameter("montre", montre);
//        Rapport acquisitions = (Rapport) query.getSingleResult();
//        ConnexionService.disconect();
//        return acquisitions;
//    }
}
