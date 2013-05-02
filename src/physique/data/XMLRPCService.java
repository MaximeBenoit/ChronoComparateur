/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.Hashtable;

/**
 *
 * @author Max
 */
public interface XMLRPCService {

    public Hashtable addClient(String nom, String prenom) throws Exception;
    
    public Hashtable addMontre(String fabricant, String idClient) throws Exception;

    public Hashtable addAcquisition(Double[] tabPts, String idOperateur, String posMontre, String variationDeMarche, String repere, String amplitude) throws Exception;

    public void updateRapport(String idRapport, String idAcquisition, String defaut) throws Exception;
    
    public Hashtable getClientById(String idClient) throws Exception;

    public Hashtable getMontreById(String idMontre) throws Exception;

    public Hashtable getOperateurByLogin(String login) throws Exception;
    public Hashtable getRapportByMontre(String idMontre) throws Exception;
}
