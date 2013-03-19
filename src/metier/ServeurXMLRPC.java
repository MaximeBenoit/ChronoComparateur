/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

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

    public Client addClient(String nom, String prenom) throws Exception {
        return this.requetesSrv.addClient(nom, prenom);
    }

    public Montre addMontre(String fabricant, long idClient) throws Exception {
        return this.requetesSrv.addMontre(fabricant, idClient);
    }

    public Acquisition addAcquisition(short[] tabPts, long idOperateur, String posMontre) throws Exception {
        return this.requetesSrv.addAcquisition(tabPts, idOperateur, posMontre);
    }

    public Client getClientById(long idClient) throws Exception {
        return this.requetesSrv.getClientById(idClient);
    }

    public Montre getMontreById(long idMontre) throws Exception {
        return this.requetesSrv.getMontreById(idMontre);
    }

    public Operateur getOperateurByLogin(String login) throws Exception {
        return this.requetesSrv.getOperateurByLogin(login);
    }
    
    public void updateRapport(long idRapport, long idAcquisition) throws Exception {
        this.requetesSrv.updateRapport(idRapport, idAcquisition);
    }

    public static void main(String[] args) {
        try {
            ServeurXMLRPC srv = new ServeurXMLRPC();
            
            WebServer webServer = new WebServer(srv.port);              //Création serveur XML-RPC
            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
            
            PropertyHandlerMapping phm = new PropertyHandlerMapping();  
            phm.addHandler("service", ServeurXMLRPC.class);             //Associer serveur au service
            xmlRpcServer.setHandlerMapping(phm);                        //Ajouter ici le gestionnaire système
            
            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();  
            serverConfig.setEnabledForExtensions(true);                 //Configuration
            serverConfig.setContentLengthOptional(false);
            
            webServer.start();                                          //Démarre le serveur web
            System.out.println("Serveur XML-RPC actif sur le port " + srv.port);
        } catch (Exception exception) {
            System.err.println("Serveur XML-RPC: " + exception.toString());
        }
    }
}
