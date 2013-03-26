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
        Client client = new Client();
        client.setNom("Chesneau ");
        client.setPrenom("Damien");
        clientSrv.addClient(client);

        for (int i = 0; i < 32; i++) {
            operateur = new Operateur();
            String login = "login" + i;
            String nom = "nom" + i;
            String prenom = "prenom" + i;
            operateur.setAdmin(true);
            operateur.setLogin(login);
            operateur.setMdp("0107");
            operateur.setNom(nom);
            operateur.setPrenom(prenom);
            operateurSrv.addOperateur(operateur);
        }
//        Signal signal = new Signal();
//        signal.setDateAcquisition(new Date());
//        signal.setPositionMontre(PositionMontre.fondH);
//        signal.setOperateur(operateur);
//        signalSrv.addSignal(signal);
//
       

        Acquisition acquisition = new Acquisition();
        acquisition.setOperateur(operateur);
        acquisition.setPositionMontre("init");
        acquisition.setTabpoints(tabpoints);
        acquisition.setDateAcquisition(new Date());
        acquisitionSrv.addAcquisition(acquisition);

        List<Acquisition> acquisitions = new ArrayList<Acquisition>();
        acquisitions.add(acquisition);
        Rapport rapport = new Rapport();
        rapport.setDateUpdate(new Date());
        rapport.setAcquisition(acquisitions);
        rapport.setEmpty(true);
        rapportSrv.addRapport(rapport);

         Montre montre = new Montre();
        montre.setFabricant("Rolex");
        montre.setProprietaire(client);
        montre.setRapport(rapport);
        montreSrv.addMontre(montre);
    }
}
