/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.Date;
import java.util.List;
import metier.Acquisition;
import metier.Montre;

/**
 *
 * @author benoit
 */
public interface AcquisitionORMService {
    public Acquisition addAcquisition(Acquisition acquisition) throws Exception;
    public void removeAcquisition(Acquisition acquisition) throws Exception;
    public void updateAcquisition(Acquisition acquisition) throws Exception;
    public List<Acquisition> getAll() throws Exception;
    public Acquisition getById(long id) throws Exception;
    public List<Acquisition> getByDateAcquisition(Date dateAcquisition) throws Exception;
    public List<Acquisition> getByPositionMontre(String positionMontre) throws Exception;
    public Acquisition getByMontre(Montre montre)throws Exception;
}
