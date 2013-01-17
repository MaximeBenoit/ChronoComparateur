/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.Date;
import java.util.List;
import metier.Signal;

/**
 *
 * @author benoit
 */
public interface SignalORMService {

    public void addSignal(Signal signal) throws Exception;

    public void removeSignal(Signal signal) throws Exception;

    public void updateSignal(Signal signal) throws Exception;

    public List<Signal> getAll() throws Exception;

    public Signal getById(long id) throws Exception;

    public List<Signal> getByDateAcquisition(Date dateAcquisition) throws Exception;
}
