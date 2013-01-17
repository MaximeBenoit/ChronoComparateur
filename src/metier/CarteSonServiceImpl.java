/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author saturne
 */
public class CarteSonServiceImpl implements CarteSonService {

    physique.IO.CarteSonService carteSonSrv = physique.IO.PhysiqueIOFactory.getCarteSonService();

    @Override
    public byte[] acquerir(double frequence, int nbPoints) throws Exception {
        if(frequence < 0 || nbPoints < 0) {
            return carteSonSrv.acquerir(frequence, nbPoints);
        } else {
            throw new Exception("acquerir impossible : Paramètre null !");
        }
    }
}
