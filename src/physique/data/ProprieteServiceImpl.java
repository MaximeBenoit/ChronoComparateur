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
class ProprieteServiceImpl implements ProprieteService {

    public ProprieteServiceImpl() {
    }

    @Override
    public Propriete getPropriete(Mesure mesure) {
        ConnexionService.getPersistance();
        Propriete propriete = ConnexionService.em.find(Propriete.class, mesure);
        ConnexionService.disconect();
        return propriete;
    }
}
