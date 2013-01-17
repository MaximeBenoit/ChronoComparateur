/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.IO;

/**
 *
 * @author saturne
 */
public class PhysiqueIOFactory {
    
    private static CarteSonService carteSonServ = new CarteSonServiceImpl();
    
    
    public static CarteSonService getCarteSonService(){
        return carteSonServ;
    }
    
    
}
