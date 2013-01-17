/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import metier.Mesure;
import metier.Signal;

/**
 *
 * @author benoit
 */
public interface MesureService {
    public Mesure getMesure(Signal signal)throws Exception;
}
