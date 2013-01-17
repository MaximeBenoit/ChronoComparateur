/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author saturne
 */
public class MesureServiceImpl implements MesureService {

    physique.data.MesureService mesureSrv = physique.data.PhysiqueDataFactory.getMesureSrv();

    @Override
    public Mesure getMesure(Signal signal) throws Exception {
        if (signal != null) {
            return mesureSrv.getMesure(signal);
        } else {
            throw new Exception("getMesure impossible : Paramètre null !");
        }
    }
}
