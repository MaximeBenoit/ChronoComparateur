/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Hashtable;

/**
 *
 * @author Max
 */
public interface RequetesService {
    public Hashtable addClient(String nom, String prenom) throws Exception;
    public Hashtable addMontre(String fabricant, String idClient) throws Exception;
    public Hashtable addAcquisition(Double[] tabPts, String idOperateur, String posMontre) throws Exception;
    public void updateRapport(String idRapport, String idAcquisition) throws Exception;
    public Hashtable getClientById(String idClient) throws Exception;
    public Hashtable getMontreById(String idMontre) throws Exception;
    public Hashtable getOperateurByLogin(String login) throws Exception;
}
