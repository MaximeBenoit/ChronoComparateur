/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InitBdd;

import metier.MetierFactory;
import metier.Operateur;
import metier.OperateurService;

/**
 *
 * @author Maxime
 */
public class Chronocomp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

//      InitialisationBdd initialisationBdd = new InitialisationBdd();
        OperateurService d = MetierFactory.getOperateurServ();
        if (d.getByLogin("maximebenoit") != null) {
          System.out.println("test");
        } else {
          
        }
        
    }
}
