/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import metier.Mesure;
import metier.Acquisition;

/**
 *
 * @author benoit
 */
class MesureServiceImpl implements MesureService {

    public MesureServiceImpl() {
    }

    @Override
    public Mesure getMesure(Acquisition signal) {
        ConnexionService.getPersistance();
        Mesure mesure = ConnexionService.em.find(Mesure.class, signal);
        ConnexionService.disconect();
        return mesure;
    }
}
