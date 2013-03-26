/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Hashtable;
import physique.data.PhysiqueDataFactory;
import physique.data.XMLRPCService;

/**
 *
 * @author Max
 */
public class RequetesServiceImpl implements RequetesService{
    XMLRPCService xmlRpcService = PhysiqueDataFactory.getRequeteSrv();
    
    public RequetesServiceImpl() {
    }

    @Override
    public Hashtable addClient(String nom, String prenom) throws Exception {
        if(nom == null || prenom == null) {
            System.out.println("Erreur addClient, paramètre null");
            return null;
        } else {
            return xmlRpcService.addClient(nom, prenom);
        }
    }

    public Hashtable addMontre(String fabricant, String idClient) throws Exception {
        if(fabricant == null || idClient == null) {
            System.out.println("Erreur addMontre, paramètre null");
            return null;
        } else {
            return xmlRpcService.addMontre(fabricant, idClient);
        }
    }

    public Hashtable addAcquisition(Double[] tabPts, String idOperateur, String posMontre) throws Exception {
        if(tabPts == null || idOperateur == null || posMontre == null) {
            System.out.println("Erreur addAcquisition, paramètre null");
            return null;
        } else {
            return xmlRpcService.addAcquisition(tabPts, idOperateur, posMontre);
        }
    }

    public Hashtable getClientById(String idClient) throws Exception {
        if(idClient == null) {
            System.out.println("Erreur getClientById, paramètre <= 0");
            return null;
        } else {
            return xmlRpcService.getClientById(idClient);
        }
    }

    public Hashtable getMontreById(String idMontre) throws Exception {
        if(idMontre == null) {
            System.out.println("Erreur getMontreById, paramètre <= 0");
            return null;
        } else {
            return xmlRpcService.getMontreById(idMontre);
        }
    }

    @Override
    public Hashtable getOperateurByLogin(String login) throws Exception {
        if(login == null) {
            System.out.println("Erreur getOperateurByLogin, paramètre null");
            return null;
        } else {
            return xmlRpcService.getOperateurByLogin(login);
        }
    }

    @Override
    public void updateRapport(String idRapport, String idAcquisition) throws Exception {
        if(idRapport == null || idAcquisition == null) {
            System.out.println("Erreur updateRapport, paramètre null");
        } else {
            xmlRpcService.updateRapport(idRapport, idAcquisition);
        }
    }
}
