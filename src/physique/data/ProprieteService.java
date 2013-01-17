/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import metier.Mesure;
import metier.Propriete;

/**
 *
 * @author benoit
 */
public interface ProprieteService {
    public Propriete getPropriete(Mesure mesure)throws Exception;
   
}
