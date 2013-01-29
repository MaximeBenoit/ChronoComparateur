/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InitBdd;

import java.util.Date;
import java.util.List;
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
    private AcquisitionService signalSrv = MetierFactory.getSignalServ();

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

//        Signal signal = new Signal();
//        signal.setDateAcquisition(new Date());
//        signal.setPositionMontre(PositionMontre.fondH);
//        signal.setOperateur(operateur);
//        signalSrv.addSignal(signal);
//
        Montre montre = new Montre();
        montre.setFabricant("Rolex");
        montre.setProprietaire(client);
        montre.setAcquisition(null);
        montreSrv.addMontre(montre);

        Rapport rapport = new Rapport();
        rapport.setDateUpdate(new Date());
        rapport.setMontre(montre);
        rapportSrv.addRapport(rapport);

    }
}
