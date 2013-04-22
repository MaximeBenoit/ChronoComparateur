/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.Date;
import java.util.List;
import metier.Montre;
import metier.Rapport;

/**
 *
 * @author benoit
 */
public interface RapportORMService {
    public Rapport addRapport(Rapport rapport) throws Exception;

    public void removeRapport(Rapport rapport) throws Exception;

    public void updateRapport(Rapport rapport) throws Exception;

    public List<Rapport> getAll() throws Exception;

    public Rapport getById(long id) throws Exception;

    public List<Rapport> getByDateUpdate(Date dateUpdate) throws Exception;
    
    public List<Rapport> getByDefaut(Rapport defaut)throws Exception;
  //  public Rapport getByMontre(Montre montre) throws Exception;
}
