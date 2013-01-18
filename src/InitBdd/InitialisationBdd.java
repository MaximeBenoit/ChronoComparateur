/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InitBdd;

import physique.data.*;
import metier.*;

/**
 *
 * @author benoit
 */
public class InitialisationBdd {

    /**
     * @param args the command line arguments
     */
    
    private ClientService clientSrv = MetierFactory.getClientServ();
    private OperateurService operateurSrv = MetierFactory.getOperateurServ();
    private MontreService montreSrv = MetierFactory.getMontreServ();
    private RapportService rapportSrv = MetierFactory.getRapportServ();
    private SignalService signalSrv = MetierFactory.getSignalServ();
    public static void main(String[] args) {
        Client client = new Client();
    }
}
