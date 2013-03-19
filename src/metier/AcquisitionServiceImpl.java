/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.List;
import physique.data.AcquisitionORMService;

/**
 *
 * @author saturne
 */
public class AcquisitionServiceImpl implements AcquisitionService {

    AcquisitionORMService signalSrv = physique.data.PhysiqueDataFactory.getAcquisitionORMSrv();

    @Override
    public Acquisition addAcquisition(Acquisition acquisition) throws Exception {
        if (acquisition != null) {
            return signalSrv.addAcquisition(acquisition);
        } else {
            throw new Exception("addSignal impossible : Paramètre null !");
        }
        
    }

    @Override
    public void removeAcquisition(Acquisition acquisition) throws Exception {
        if (acquisition != null) {
            signalSrv.removeAcquisition(acquisition);
        } else {
            throw new Exception("removeSignal impossible : Paramètre null !");
        }
    }

    @Override
    public void updateAcquisition(Acquisition acquisition) throws Exception {
        if (acquisition != null) {
            signalSrv.updateAcquisition(acquisition);
        } else {
            throw new Exception("updateSignal impossible : Paramètre null !");
        }
    }

    @Override
    public List<Acquisition> getAll() throws Exception {
        return signalSrv.getAll();
    }

    @Override
    public Acquisition getById(long id) throws Exception {
        if(id < 0) {
            throw new Exception("getById impossible : id négatif !");
        } else {
            return signalSrv.getById(id);
        }
    }

    @Override
    public List<Acquisition> getByDateAcquisition(Date dateAcquisition) throws Exception {
        if (dateAcquisition != null) {
            return signalSrv.getByDateAcquisition(dateAcquisition);
        } else {
            throw new Exception("getByDateAcquisition impossible : Paramètre null !");
        }
    }

    @Override
    public List<Acquisition> getByPositionMontre(String positionMontre) throws Exception {
        if (positionMontre != null) {
            return signalSrv.getByPositionMontre(positionMontre);
        } else {
            throw new Exception("getByPositionMontre impossible : Paramètre null !");
        }
    }

    @Override
    public Acquisition getByMontre(Montre montre) throws Exception {
           if (montre != null) {
            return signalSrv.getByMontre(montre);
        } else {
            throw new Exception("getByMontre impossible : Paramètre null !");
        }
    }
}
