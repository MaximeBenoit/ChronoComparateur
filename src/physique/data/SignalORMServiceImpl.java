/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.Date;
import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeSignal(Signal signal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateSignal(Signal signal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Signal> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Signal getById(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Signal> getByDateAcquisition(Date dateAcquisition) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Signal> getByPositionMontre(PositionMontre positionMontre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }   
}
