/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import metier.Acquisition;
import metier.PositionMontre;

/**
 *
 * @author benoit
 */
class AcquisitionORMServiceImpl implements AcquisitionORMService {

    public AcquisitionORMServiceImpl() {
    }

    @Override
    public void addAcquisition(Acquisition acquisition) throws Exception {
        ConnexionService.getPersistance();
        ConnexionService.em.persist(acquisition);
        ConnexionService.disconect();
    }

    @Override
    public void removeAcquisition(Acquisition acquisition) throws Exception {
        ConnexionService.getPersistance();
        ConnexionService.em.remove(ConnexionService.em.merge(acquisition));
        ConnexionService.disconect();
    }

    @Override
    public void updateAcquisition(Acquisition acquisition) throws Exception {
        ConnexionService.getPersistance();
        ConnexionService.em.merge(acquisition);
        ConnexionService.disconect();
    }

    @Override
    public List<Acquisition> getAll() throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("acquisitionGetAll");
        List<Acquisition> signals = query.getResultList();
        return signals;
    }

    @Override
    public Acquisition getById(long id) throws Exception {
        ConnexionService.getPersistance();
        Acquisition signal = ConnexionService.em.find(Acquisition.class, id);
        ConnexionService.disconect();
        return signal;

    }

    @Override
    public List<Acquisition> getByDateAcquisition(Date dateAcquisition) throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("acquisitionGetByDateAcquisition");
        query.setParameter("dateAcquisition", dateAcquisition);
        List<Acquisition> signals = query.getResultList();
        ConnexionService.disconect();
        return signals;

    }

    @Override
    public List<Acquisition> getByPositionMontre(PositionMontre positionMontre) throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("acquisitionGetByPositionMontre");
        query.setParameter("positionMontre", positionMontre);
        List<Acquisition> signals = query.getResultList();
        ConnexionService.disconect();
        return signals;
    }
}
