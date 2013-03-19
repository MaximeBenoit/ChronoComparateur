/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Max
 */
public interface RequetesService {
    public Client addClient(String nom, String prenom) throws Exception;
    public Montre addMontre(String fabricant, long idClient) throws Exception;
    public Acquisition addAcquisition(short[] tabPts, long idOperateur, String posMontre) throws Exception;
    public void updateRapport(long idRapport, long idAcquisition) throws Exception;
    public Client getClientById(long idClient) throws Exception;
    public Montre getMontreById(long idMontre) throws Exception;
    public Operateur getOperateurByLogin(String login) throws Exception;
}
