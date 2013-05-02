/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import metier.Acquisition;
import metier.Client;
import metier.Montre;
import metier.Operateur;
import metier.Rapport;

/**
 *
 * @author Max
 */
public class XMLRPCServiceImpl implements XMLRPCService {

    ClientORMService clientSrv = PhysiqueDataFactory.getClienORMSrv();
    MontreORMService montreSrv = PhysiqueDataFactory.getMontreORMSrv();
    AcquisitionORMService acquisitionSrv = PhysiqueDataFactory.getAcquisitionORMSrv();
    RapportORMService rapportSrv = PhysiqueDataFactory.getRapportORMSrv();
    OperateurORMService operateurSrv = PhysiqueDataFactory.getOperateurORMSrv();

    @Override
    public Hashtable addClient(String nom, String prenom) throws Exception {
        Hashtable ht = new Hashtable();
        System.out.println("Method addClient, params : " + nom + ", " + prenom);
        Client clientCreate = new Client();
        clientCreate.setNom(nom);
        clientCreate.setPrenom(prenom);
        Client clientAdd = this.clientSrv.addClient(clientCreate);
        ht.put("idClient", String.valueOf(clientAdd.getId()));
        return ht;
    }

    @Override
    public Hashtable addMontre(String fabricant, String idClient) throws Exception {
        Hashtable ht = new Hashtable();
        System.out.println("\nMethod addMontre, params : " + fabricant + ", " + idClient + "\n");
        Rapport rapportCreate = new Rapport();
        Montre montreCreate = new Montre();

        rapportCreate.setDateUpdate(new Date());
        rapportCreate.setEmpty(true);
        rapportCreate.setAcquisition(null);

        montreCreate.setFabricant(fabricant);
        montreCreate.setRapport(this.rapportSrv.addRapport(rapportCreate));
        montreCreate.setProprietaire(this.clientSrv.getById(Long.parseLong(idClient)));

        Montre montreAdd = this.montreSrv.addMontre(montreCreate);
        ht.put("idMontre", String.valueOf(montreAdd.getId()));
        return ht;
    }

    @Override
    public Hashtable addAcquisition(Double[] tabPts, String idOperateur, String posMontre, String variationDeMarche, String repere, String amplitude) throws Exception {
        Hashtable ht = new Hashtable();
        System.out.println("Method addAcquisition, params : " + tabPts + ", " + idOperateur + ", " + posMontre);
        Acquisition acquisitionCreate = new Acquisition();
        acquisitionCreate.setDateAcquisition(new Date());
        acquisitionCreate.setOperateur(this.operateurSrv.getById(Long.parseLong(idOperateur)));
        acquisitionCreate.setPositionMontre(posMontre);
        acquisitionCreate.setTabpoints(tabPts);
        acquisitionCreate.setVariationDeMarche(Double.parseDouble(variationDeMarche));
        acquisitionCreate.setRepere(Double.parseDouble(repere));
        acquisitionCreate.setAmplitude(Integer.parseInt(amplitude));
        Acquisition acquisitionAdd = this.acquisitionSrv.addAcquisition(acquisitionCreate);
        ht.put("idAcquisition", String.valueOf(acquisitionAdd.getId()));
        return ht;
    }

    @Override
    public Hashtable getClientById(String idClient) throws Exception {
        Hashtable ht = new Hashtable();
        Client client = this.clientSrv.getById(Long.parseLong(idClient));
        if (client == null) {
            ht.put("idClient", String.valueOf(0));
        } else {
            ht.put("idClient", String.valueOf(client.getId()));
        }
        return ht;
    }

    @Override
    public Hashtable getMontreById(String idMontre) throws Exception {
        Hashtable ht = new Hashtable();
        Montre montre = this.montreSrv.getById(Long.parseLong(idMontre));
        if (montre == null) {
            ht.put("idMontre", String.valueOf(0));
        } else {
            ht.put("idMontre", String.valueOf(montre.getId()));
        }
        return ht;
    }

    @Override
    public Hashtable getOperateurByLogin(String login) throws Exception {
        Hashtable ht = new Hashtable();
        System.out.println("Passage getByLogin, param : " + login);
        Operateur operateur = new Operateur();
        operateur = this.operateurSrv.getByLogin(login);
        if (operateur == null) {
            System.out.println("PASSAGEnull");
            ht.put("idOperateur", String.valueOf(0));
        } else {
            System.out.println("PASSAGE");
            ht.put("idOperateur", String.valueOf(operateur.getId()));
        }
        return ht;
    }

    @Override
    public void updateRapport(String idRapport, String idAcquisition, String defaut) throws Exception {
        Rapport rapportRecup = this.rapportSrv.getById(Long.parseLong(idRapport));
        Acquisition acquisitionRecup = this.acquisitionSrv.getById(Long.parseLong(idAcquisition));
        List<Acquisition> acquisitions = new ArrayList<Acquisition>();

        if (rapportRecup.isEmpty()) {
            acquisitions.add(acquisitionRecup);
        } else {
            acquisitions = rapportRecup.getAcquisition();
            acquisitions.add(acquisitionRecup);
        }

        Rapport rapportUpdate = new Rapport();
        rapportUpdate.setAcquisition(acquisitions);
        rapportUpdate.setDateUpdate(acquisitionRecup.getDateAcquisition());
        rapportUpdate.setId(Long.parseLong(idRapport));
        rapportUpdate.setEmpty(false);
        rapportUpdate.setDefaut(defaut);
        this.rapportSrv.updateRapport(rapportUpdate);
    }

    @Override
    public Hashtable getRapportByMontre(String idMontre) throws Exception {
        Hashtable ht = new Hashtable();
        System.out.println("Passage getByMontre, param : " + idMontre);
        Rapport rapport = new Rapport();
        Montre montre = new Montre();
        montre = this.montreSrv.getById(Long.parseLong(idMontre));
        rapport = montre.getRapport();
        if (rapport == null) {
            System.out.println("PASSAGEnull");
            ht.put("idRapport", String.valueOf(0));
        } else {
            System.out.println("PASSAGE");
            ht.put("idRapport", String.valueOf(rapport.getId()));
        }
        return ht;
    }
}
