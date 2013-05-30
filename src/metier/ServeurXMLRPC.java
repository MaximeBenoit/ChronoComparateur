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
        Hashtable ht = new Hashtable();
        ht = this.requetesSrv.addClient(nom, prenom);
        System.err.println("\n====================\nServeur XML-RPC\nMéthode addClient :\n\tNom => " 
                + nom + "\n\tPrenom => " + prenom + "\n\tValeur retournée => " 
                + ht.get("idClient") + "\n=====================\n");
        return ht;
    }

    public Hashtable addMontre(String fabricant, String idClient) throws Exception {
        Hashtable ht = new Hashtable();
        ht = this.requetesSrv.addMontre(fabricant, idClient);
        System.err.println("\n====================\nServeur XML-RPC \nMéthode addMontre :\n\tFabricant => " 
                + fabricant + "\n\tClient => " + idClient + "\n\tValeur retournée => " 
                + ht.get("idMontre") + "\n=====================\n");
        return ht;
    }

    public Hashtable addAcquisition(byte[] tabBytes, String idOperateur, String posMontre, String variationDeMarche, String repere, String amplitude) throws Exception {
        Hashtable ht = new Hashtable();
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
        ht = this.requetesSrv.addAcquisition(tabPts, idOperateur, posMontre, variationDeMarche, repere, amplitude);
        System.err.println("\n=====================\nServeur XML-RPC \nMéthode addAcquisition :\n\tOperateur => " 
                + idOperateur + "\n\tPosition montre => " + posMontre + "\n\tVariation de marche =>  " + variationDeMarche +"\n\tRepere =>  " + repere +"\n\tAmplitude =>  " + amplitude +"\n\tValeur retournée => " 
                + ht.get("idAcquisition") + "\n=====================\n");
        return ht;
    }
    
    public Hashtable getClientById(String idClient) throws Exception {
        Hashtable ht = new Hashtable();
        ht=this.requetesSrv.getClientById(idClient);
         System.err.println("\n=====================\nServeur XML-RPC \nMéthode getClientById :\n\tClient => " 
                + idClient + "\n\tValeur retournée => " 
                + ht.get("idClient") + "\n=====================\n");
        return ht;
    }

    public Hashtable getMontreById(String idMontre) throws Exception {
        Hashtable ht = new Hashtable();
        ht = this.requetesSrv.getMontreById(idMontre);
        System.err.println("\n=====================\nServeur XML-RPC \nMéthode getMontreById :\n\tMontre => " 
                + idMontre + "\n\tValeur retournée => " 
                + ht.get("idMontre") + "\n=====================\n");
        return ht;
    }

    public Hashtable getOperateurByLogin(String login) throws Exception {
         Hashtable ht = new Hashtable();
         ht = this.requetesSrv.getOperateurByLogin(login);
          System.err.println("\n=====================\nServeur XML-RPC \nMéthode getOperateurByLogin :\n\tLogin => " 
                + login + "\n\tValeur retournée => " 
                + ht.get("idOperateur") + "\n=====================\n");
        return ht;
    }
    
    public Hashtable getRapportByMontre(String idMontre) throws Exception {
        Hashtable ht = new Hashtable();
        ht = this.requetesSrv.getRapportByMontre(idMontre);
         System.err.println("\n=====================\nServeur XML-RPC \nMéthode getRapportByMontre :\n\tMontre => " 
                + idMontre + "\nValeur retournée => " 
                + ht.get("idRapport") + "\n=====================\n");
        return ht;
    }
    
    public void updateRapport(String idRapport, String idAcquisition, String defaut) throws Exception {
        System.err.println("\n=====================\nServeur XML-RPC :\nMéthode updateRapport :\n\tRapport => " 
                + idRapport + "\n\tAcquisition => " + idAcquisition + "\n\tDefaut =>  " + defaut + "\n=====================\n");
        this.requetesSrv.updateRapport(idRapport, idAcquisition, defaut);
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
