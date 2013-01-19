/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InitBdd;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    public InitialisationBdd() throws Exception{
        Client client = new Client();
        client.setNom("Benoit");
        client.setPrenom("Maxime");
        
            clientSrv.addClient(client);
      
//        Operateur operateur = new Operateur();
//        operateur.setAdmin(true);
//        operateur.setLogin("maximebenoit");
//        operateur.setMdp("0107");
//        operateur.setNom("Benoit");
//        operateur.setPrenom("Maxime");
//        try {
//            operateurSrv.addOperateur(operateur);
//        } catch (Exception ex) {
//            Logger.getLogger(InitialisationBdd.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Montre montre = new Montre();
//        montre.setFabricant("Rolex");
//        montre.setProprietaire(client);
//        montre.setSignal(null);
//        try {
//            montreSrv.addMontre(montre);
//        } catch (Exception ex) {
//            Logger.getLogger(InitialisationBdd.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Rapport rapport = new Rapport();
//        rapport.setDateUpdate(null);
//        rapport.setMontre(montre);
//        try {
//            rapportSrv.addRapport(rapport);
//        } catch (Exception ex) {
//            Logger.getLogger(InitialisationBdd.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Signal signal = new Signal();
//        signal.setDateAcquisition(null);
//        signal.setPositionMontre(PositionMontre.fondH);
//        signal.setOperateur(operateur);
//        try {
//            signalSrv.addSignal(signal);
//        } catch (Exception ex) {
//            Logger.getLogger(InitialisationBdd.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
    }
    public static void main(String[] args) throws Exception {
      new InitialisationBdd();
    }
}
