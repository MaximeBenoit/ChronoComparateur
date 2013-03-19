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
public interface RapportService {
    public Rapport addRapport(Rapport rapport) throws Exception;
    public void removeRapport(Rapport rapport) throws Exception;
    public void updateRapport(Rapport rapport) throws Exception;
    public List<Rapport> getAll() throws Exception;
    public Rapport getById(long id) throws Exception;
    public List<Rapport> getByDateUpdate(Date dateUpdate) throws Exception;
}
