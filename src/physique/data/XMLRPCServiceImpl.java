/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.ArrayList;
import java.util.Date;
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
    public Client addClient(String nom, String prenom) throws Exception {
        Client clientCreate = new Client();
        clientCreate.setNom(nom);
        clientCreate.setPrenom(prenom);
        Client clientAdd = this.clientSrv.addClient(clientCreate);
        return clientAdd;
    }

    @Override
    public Montre addMontre(String fabricant, long idClient) throws Exception {
        Rapport rapportCreate = new Rapport();
        Montre montreCreate = new Montre();

        rapportCreate.setDateUpdate(new Date());
        rapportCreate.setEmpty(true);
        rapportCreate.setAcquisition(null);

        montreCreate.setFabricant(fabricant);
        montreCreate.setRapport(rapportCreate);

        Montre montreAdd = this.montreSrv.addMontre(montreCreate);
        return montreAdd;
    }

    @Override
    public Acquisition addAcquisition(short[] tabPts, long idOperateur, String posMontre) throws Exception {
        Acquisition acquisitionCreate = new Acquisition();
        acquisitionCreate.setDateAcquisition(new Date());
        acquisitionCreate.setOperateur(this.operateurSrv.getById(idOperateur));
        acquisitionCreate.setPositionMontre(posMontre);
        acquisitionCreate.setTabpoints(tabPts);
        Acquisition acquisitionAdd = this.acquisitionSrv.addAcquisition(acquisitionCreate);
        return acquisitionAdd;
    }

    @Override
    public Client getClientById(long idClient) throws Exception {
        Client client = this.clientSrv.getById(idClient);
        return client;

    }

    @Override
    public Montre getMontreById(long idMontre) throws Exception {
        Montre montre = this.montreSrv.getById(idMontre);
        return montre;
    }

    @Override
    public Operateur getOperateurByLogin(String login) throws Exception {
        Operateur operateur = this.operateurSrv.getByLogin(login);
        return operateur;
    }

    @Override
    public void updateRapport(long idRapport, long idAcquisition) throws Exception {
        Rapport rapportRecup = this.rapportSrv.getById(idRapport);
        Acquisition acquisitionRecup = this.acquisitionSrv.getById(idAcquisition);
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
        rapportUpdate.setId(idRapport);
        rapportUpdate.setEmpty(false);
        this.rapportSrv.updateRapport(rapportUpdate);
    }
}
