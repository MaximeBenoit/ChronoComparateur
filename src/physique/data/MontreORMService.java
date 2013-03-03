/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.Client;
import metier.Montre;

/**
 *
 * @author benoit
 */
public interface MontreORMService {

    public Montre addMontre(Montre montre) throws Exception;

    public void removeMontre(Montre montre) throws Exception;

    public void updateMontre(Montre montre) throws Exception;

    public List<Montre> getAll() throws Exception;

    public Montre getById(long id) throws Exception;

    public List<Montre> getByFabricant(String fabricant) throws Exception;
    
    public List<Montre> getByProprietaire(Client proprietaire) throws Exception;
}
