/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InitBdd;

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

    public InitialisationBdd() throws Exception {
        
        Client client = new Client();
        client.setNom("Benoit");
        client.setPrenom("Maxime");
        clientSrv.addClient(client);

        Operateur operateur = new Operateur();
        operateur.setAdmin(true);
        operateur.setLogin("maximebenoit");
        operateur.setMdp("0107");
        operateur.setNom("Benoit");
        operateur.setPrenom("Maxime");
        operateurSrv.addOperateur(operateur);

//        Montre montre = new Montre();
//        montre.setFabricant("Rolex");
//        montre.setProprietaire(client);
//        montre.setSignal(null);
//        montreSrv.addMontre(montre);
//
//        Rapport rapport = new Rapport();
//        rapport.setDateUpdate(null);
//        rapport.setMontre(montre);
//        rapportSrv.addRapport(rapport);
//
//        Signal signal = new Signal();
//        signal.setDateAcquisition(null);
//        signal.setPositionMontre(PositionMontre.fondH);
//        signal.setOperateur(operateur);
//        signalSrv.addSignal(signal);



    }
}
