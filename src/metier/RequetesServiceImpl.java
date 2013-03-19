/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

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

    public Client addClient(String nom, String prenom) throws Exception {
        if(nom == null || prenom == null) {
            System.out.println("Erreur addClient, paramètre null");
            return null;
        } else {
            return xmlRpcService.addClient(nom, prenom);
        }
    }

    public Montre addMontre(String fabricant, long idClient) throws Exception {
        if(fabricant == null || idClient <= 0) {
            System.out.println("Erreur addMontre, paramètre null");
            return null;
        } else {
            return xmlRpcService.addMontre(fabricant, idClient);
        }
    }

    public Acquisition addAcquisition(short[] tabPts, long idOperateur, String posMontre) throws Exception {
        if(tabPts == null || idOperateur <= 0 || posMontre == null) {
            System.out.println("Erreur addAcquisition, paramètre null");
            return null;
        } else {
            return xmlRpcService.addAcquisition(tabPts, idOperateur, posMontre);
        }
    }

    public Client getClientById(long idClient) throws Exception {
        if(idClient <= 0) {
            System.out.println("Erreur getClientById, paramètre <= 0");
            return null;
        } else {
            return xmlRpcService.getClientById(idClient);
        }
    }

    public Montre getMontreById(long idMontre) throws Exception {
        if(idMontre <= 0) {
            System.out.println("Erreur getMontreById, paramètre <= 0");
            return null;
        } else {
            return xmlRpcService.getMontreById(idMontre);
        }
    }

    public Operateur getOperateurByLogin(String login) throws Exception {
        if(login == null) {
            System.out.println("Erreur getOperateurByLogin, paramètre null");
            return null;
        } else {
            return xmlRpcService.getOperateurByLogin(login);
        }
    }

    @Override
    public void updateRapport(long idRapport, long idAcquisition) throws Exception {
        if(idRapport <= 0 || idAcquisition <= 0) {
            System.out.println("Erreur updateRapport, paramètre null");
        } else {
            xmlRpcService.updateRapport(idRapport, idAcquisition);
        }
    }
}
