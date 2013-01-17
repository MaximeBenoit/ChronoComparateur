/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.List;

/**
 *
 * @author saturne
 */
public interface SignalService {
    public void addSignal(Signal signal) throws Exception;
    public void removeSignal(Signal signal) throws Exception;
    public void updateSignal(Signal signal) throws Exception;
    public List<Signal> getAll() throws Exception;
    public Signal getById(long id) throws Exception;
    public List<Signal> getByDateAcquisition(Date dateAcquisition) throws Exception;
}
