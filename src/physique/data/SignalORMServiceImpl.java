/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import metier.PositionMontre;
import metier.Signal;

/**
 *
 * @author benoit
 */
class SignalORMServiceImpl implements SignalORMService {

    public SignalORMServiceImpl() {
    }

    @Override
    public void addSignal(Signal signal) throws Exception {
        ConnexionService.getPersistance();
        ConnexionService.em.persist(signal);
        ConnexionService.disconect();
    }

    @Override
    public void removeSignal(Signal signal) throws Exception {
        ConnexionService.getPersistance();
        ConnexionService.em.remove(ConnexionService.em.merge(signal));
        ConnexionService.disconect();
    }

    @Override
    public void updateSignal(Signal signal) throws Exception {
        ConnexionService.getPersistance();
        ConnexionService.em.merge(signal);
        ConnexionService.disconect();
    }

    @Override
    public List<Signal> getAll() throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("signalGetAll");
        List<Signal> signals = query.getResultList();
        return signals;
    }

    @Override
    public Signal getById(long id) throws Exception {
        ConnexionService.getPersistance();
        Signal signal = ConnexionService.em.find(Signal.class, id);
        ConnexionService.disconect();
        return signal;

    }

    @Override
    public List<Signal> getByDateAcquisition(Date dateAcquisition) throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("signalGetByDateAcquisition");
        query.setParameter("dateAcquisition", dateAcquisition);
        List<Signal> signals = query.getResultList();
        ConnexionService.disconect();
        return signals;

    }

    @Override
    public List<Signal> getByPositionMontre(PositionMontre positionMontre) throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("signalGetByPositionMontre");
        query.setParameter("positionMontre", positionMontre);
        List<Signal> signals = query.getResultList();
        ConnexionService.disconect();
        return signals;
    }
}
