/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlrpc.WebServer;

/**
 *
 * @author Max
 */
public class ServeurXmlRpcRapport {

    MontreService montreService = MetierFactory.getMontreServ();
    RapportService rapportService = MetierFactory.getRapportServ();

    public static void main(String[] args) {
        try {
            ServeurXmlRpcRapport srv = new ServeurXmlRpcRapport();
            WebServer webServer = new WebServer(8000);
            webServer.addHandler("service", srv);
            webServer.start();
            System.out.println("Serveur XML-RPC actif sur le port " + 8000);
        } catch (Exception ex) {
            System.err.println("Serveur XML-RPC : " + ex.toString());
        }
    }

    public Hashtable saveRapport(String id, String date, String idMontre) {
        Hashtable ret = new Hashtable();
        Rapport rapport = new Rapport();
        rapport.setId(Long.parseLong(id));
        rapport.setDateUpdate(new Date(date));
        try {
            rapport.setMontre(montreService.getById(Long.parseLong(idMontre)));
            rapportService.addRapport(rapport);

            if (rapportService.getById(Long.parseLong(id)) != null) {
                ret.put("check", "Et ca marche bien !");
            } else {
                ret.put("check", "Et ca marche pas !");
            }
        } catch (Exception ex) {
            Logger.getLogger(ServeurXmlRpcRapport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
