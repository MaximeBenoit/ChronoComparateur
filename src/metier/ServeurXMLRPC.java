/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Hashtable;
import org.apache.xmlrpc.WebServer;


/**
 *
 * @author saturne
 */
public class ServeurXMLRPC {

    private int port = 8000; // le port par défaut pour le serveur web
    private RequetesService requetesSrv = MetierFactory.getRequeteSrv();

    public ServeurXMLRPC() {
    }

    public ServeurXMLRPC(int port) {
        this.port = port;
    }

    public Hashtable addClient(String nom, String prenom) throws Exception {
        return this.requetesSrv.addClient(nom, prenom);
    }

    public Hashtable addMontre(String fabricant, String idClient) throws Exception {
        return this.requetesSrv.addMontre(fabricant, idClient);
    }

    public Hashtable addAcquisition(byte[] tabBytes, String idOperateur, String posMontre) throws Exception {
        double[] tabDouble = new double[tabBytes.length / 2];
        Double[] tabPts = new Double[tabDouble.length];
        byte n1 = 0;
        byte n2 =0; 
        
        // Cast tabBytes -> tabDouble
        for(int i = 0,i2 = 0; i<tabDouble.length; i++){   
            n1 = tabBytes[i2];
            n2 = tabBytes[i2+1];
            i2 = i2+2;
            tabDouble[i] = (n1 & 0xFF) | (n2<<8);
        }
        
        for(int i = 0; i < tabDouble.length; i++) {
            tabPts[i] = new Double(tabDouble[i]);
        }
        
        return this.requetesSrv.addAcquisition(tabPts, idOperateur, posMontre);
    }

    public Hashtable getClientById(String idClient) throws Exception {
        return this.requetesSrv.getClientById(idClient);
    }

    public Hashtable getMontreById(String idMontre) throws Exception {
        return this.requetesSrv.getMontreById(idMontre);
    }

    public Hashtable getOperateurByLogin(String login) throws Exception {
        System.out.println("Passage getOperateurByLogin, param : " + login);
        return this.requetesSrv.getOperateurByLogin(login);
    }
    
    public void updateRapport(String idRapport, String idAcquisition) throws Exception {
        this.requetesSrv.updateRapport(idRapport, idAcquisition);
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
