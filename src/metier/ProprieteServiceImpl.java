/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author saturne
 */
public class ProprieteServiceImpl implements ProprieteService {

    physique.data.ProprieteService proprieteSrv = physique.data.PhysiqueDataFactory.getProprieteSrv();

    @Override
    public Propriete getPropriete(Mesure mesure) throws Exception {
        if(mesure != null) {
            return proprieteSrv.getPropriete(mesure);
        } else {
            throw new Exception("getPropriete impossible : Paramètre null !");
        }
    }
}
