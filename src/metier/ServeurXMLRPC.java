/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.Hashtable;
import org.apache.xmlrpc.WebServer;

/**
 *
 * @author saturne
 */
public class ServeurXMLRPC {

    private int port = 8000; // le port par défaut pour le serveur web
    private OperateurService operateurSrv = metier.MetierFactory.getOperateurServ();
    private MontreService montreSrv = metier.MetierFactory.getMontreServ();
    private ClientService clientSrv = metier.MetierFactory.getClientServ();
    private AcquisitionService acquisitionSrv = metier.MetierFactory.getAcquisitionServ();
    private RapportService rapportSrv = metier.MetierFactory.getRapportServ();

    public ServeurXMLRPC() {
    }

    public ServeurXMLRPC(int port) {
        this.port = port;
    }

    public Boolean operateurExist(String paramLogin) throws Exception {
        Boolean ret = false;
        System.out.println("Passage operateurExist(), param : " + paramLogin);
        if (this.operateurSrv.getByLogin(paramLogin) != null) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    public Boolean montreExist(String idMontre) throws Exception {
        Boolean ret = false;
        System.out.println("Passage montreExist(), param : " + idMontre);
        if (this.montreSrv.getById(Long.parseLong(idMontre)) != null) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    public Boolean clientExist(String idClient) throws Exception {
        Boolean ret = false;
        System.out.println("Passage clientExist(), param : " + idClient);
        if (this.clientSrv.getById(Long.parseLong(idClient)) != null) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    public Hashtable addMontre(String fabricant, String idProprio) throws Exception {
        Hashtable ht = new Hashtable();
        Client proprio = new Client();
        Montre montre = new Montre();

        proprio = this.clientSrv.getById(Long.parseLong(idProprio));
        if (proprio != null) {
            montre.setFabricant(fabricant);
            montre.setProprietaire(proprio);
            Montre retMontre = this.montreSrv.addMontre(montre);

            if (retMontre != null) {
                ht.put("resultat", true);
                ht.put("idMontre", retMontre.getId());
            } else {
                ht.put("resultat", false);
            }
        } else {
            ht.put("resultat", false);
        }

        return ht;
    }

    public Hashtable addClient(String nom, String prenom) throws Exception {
        Hashtable ht = new Hashtable();
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        Client retClient = this.clientSrv.addClient(client);
        if (retClient != null) {
            ht.put("resultat", true);
            ht.put("idClient", retClient.getId());
        } else {
            ht.put("resultat", false);
        }
        return ht;
    }

    public Hashtable addAquisition(short[] tabPts, String idOperateur, String idMontre, String posMontre) throws Exception {
        Date date = new Date();
        Hashtable ht = new Hashtable();
        Acquisition acquisition = new Acquisition();
        Operateur operateur = new Operateur();
        Montre montre = new Montre();

        operateur = this.operateurSrv.getById(Long.parseLong(idOperateur));
        montre = this.montreSrv.getById(Long.parseLong(idMontre));

        if (operateur != null) {
            if (montre != null) {
                acquisition.setDateAcquisition(date);
                acquisition.setTabpoints(tabPts);
                acquisition.setPositionMontre(posMontre);
                acquisition.setOperateur(operateur);
                acquisition.setMontre(montre);
                Acquisition retAcquisition = this.acquisitionSrv.addAcquisition(acquisition);

                if (retAcquisition != null) {
                    ht.put("resultat", true);
                    ht.put("idAcquisition", retAcquisition.getId());
                } else {
                    ht.put("resultat", false);
                }
            } else {
            }

        } else {
            ht.put("resultat", false);
        }
        return ht;
    }

//    public Hashtable addRapport(String idMontre) throws Exception {
//        Date date = new Date();
//        Hashtable ret = new Hashtable();
//        Montre montre = new Montre();
//        Rapport rapport = new Rapport();
//        
//          montre = this.montreSrv.getById(Long.parseLong(idMontre));
//          if(montre !=null){
//              rapport.setDateUpdate(date);
//              rapport.setMontre(montre);
//              Rapport retRapport = this.rapportSrv.addRapport(rapport);
//          }
//          
//    }

    public Hashtable getEcho(String param) {
        System.out.println("Passage getEcho(), params : " + param);
        Hashtable ret = new Hashtable();
        ret.put("echo", param);
        return ret;
    }

    public static void main(String[] args) {
        try {
            ServeurXMLRPC srv = new ServeurXMLRPC();
            WebServer webserver = new WebServer(srv.port);
            webserver.addHandler("service", srv); // enregistre le service
            // ajouter ici le gestionnaire système (voir plus loin)
            webserver.start(); // démarre le serveur web
            System.out.println("Serveur XML-RPC actif sur le port " + srv.port);
        } catch (Exception exception) {
            System.err.println("Serveur XML-RPC: " + exception.toString());
        }
    }
}
