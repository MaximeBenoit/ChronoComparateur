/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InitBdd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import metier.*;

/**
 *
 * @author benoit
 */
public class InitialisationBdd {

    Double[] tabpoints;
    /**
     * @param args the command line arguments
     */
    private ClientService clientSrv = MetierFactory.getClientServ();
    private OperateurService operateurSrv = MetierFactory.getOperateurServ();
    private MontreService montreSrv = MetierFactory.getMontreServ();
    private RapportService rapportSrv = MetierFactory.getRapportServ();
    private AcquisitionService acquisitionSrv = MetierFactory.getAcquisitionServ();

    public InitialisationBdd() throws Exception {
        Operateur operateur = null;
        Client client = null;

//        for (int i = 2; i < 30; i++) {
//            String nom = "Nom" + i;
//            String prenom = "Prenom" + i;
//            client = new Client();
//            client.setNom(nom);
//            client.setPrenom(prenom);
//            clientSrv.addClient(client);
//       }
//
//        for (int i = 0; i < 32; i++) {
//            operateur = new Operateur();
//            String login = "login" + i;
//            String nom = "nom" + i;
//           String prenom = "prenom" + i;
//            operateur.setAdmin(true);
//            operateur.setLogin(login);
//            operateur.setMdp("0107");
//            operateur.setNom("ben");
//            operateur.setPrenom("max");
//            operateurSrv.addOperateur(operateur);
//        }
//        Signal signal = new Signal();
//        signal.setDateAcquisition(new Date());
//        signal.setPositionMontre(PositionMontre.fondH);
//        signal.setOperateur(operateur);
//        signalSrv.addSignal(signal);
//

        for(int j=0;j<3;j++){
        Acquisition acquisition = new Acquisition();
        acquisition.setOperateur(operateur);
        acquisition.setPositionMontre("CH");
        acquisition.setTabpoints(tabpoints);
        acquisition.setDateAcquisition(new Date());
        acquisition.setVariationDeMarche(298.0+j);
        acquisition.setRepere(299.0+j);
        acquisition.setAmplitude(300+j);
        acquisitionSrv.addAcquisition(acquisition);
}
//        List<Acquisition> acquisitions = new ArrayList<Acquisition>();
//        acquisitions.add(acquisition);
//        //for (int j = 0; j < 50; j++) {
//            Rapport rapport = new Rapport();
//            rapport.setDateUpdate(new Date());
//            rapport.setAcquisition(acquisitions);
//            rapport.setEmpty(true);
//            rapport.setDefaut("defaut");
//            rapportSrv.addRapport(rapport);
//            Montre montre = new Montre();
//            montre.setFabricant("Rolex");
//            montre.setProprietaire(client);
//            montre.setRapport(rapport);
//            montreSrv.addMontre(montre);

        //}

    }
}
    

