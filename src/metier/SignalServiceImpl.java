/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.List;
import physique.data.SignalORMService;

/**
 *
 * @author saturne
 */
public class SignalServiceImpl implements SignalService {

    SignalORMService signalSrv = physique.data.PhysiqueDataFactory.getSignalORMSrv();

    @Override
    public void addSignal(Signal signal) throws Exception {
        if (signal != null) {
            signalSrv.addSignal(signal);
        } else {
            throw new Exception("addSignal impossible : Paramètre null !");
        }
    }

    @Override
    public void removeSignal(Signal signal) throws Exception {
        if (signal != null) {
            signalSrv.removeSignal(signal);
        } else {
            throw new Exception("removeSignal impossible : Paramètre null !");
        }
    }

    @Override
    public void updateSignal(Signal signal) throws Exception {
        if (signal != null) {
            signalSrv.updateSignal(signal);
        } else {
            throw new Exception("updateSignal impossible : Paramètre null !");
        }
    }

    @Override
    public List<Signal> getAll() throws Exception {
        return signalSrv.getAll();
    }

    @Override
    public Signal getById(long id) throws Exception {
        if(id < 0) {
            throw new Exception("getById impossible : id négatif !");
        } else {
            return signalSrv.getById(id);
        }
    }

    @Override
    public List<Signal> getByDateAcquisition(Date dateAcquisition) throws Exception {
        if (dateAcquisition != null) {
            return signalSrv.getByDateAcquisition(dateAcquisition);
        } else {
            throw new Exception("getByDateAcquisition impossible : Paramètre null !");
        }
    }
}
