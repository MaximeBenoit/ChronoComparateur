/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author saturne
 */
public class MetierFactory {

    private static CarteSonService carteSonServ = new CarteSonServiceImpl();
    private static ClientService clientServ = new ClientServiceImpl();
    private static MesureService mesureServ = new MesureServiceImpl();
    private static MontreService montreServ = new MontreServiceImpl();
    private static OperateurService operateurServ = new OperateurServiceImpl();
    private static ProprieteService proprieteServ = new ProprieteServiceImpl();
    private static RapportService rapportServ = new RapportServiceImpl();
    private static AcquisitionService acquisitionServ = new AcquisitionServiceImpl();
    private static RequetesService requeteSrv = new RequetesServiceImpl();
    public static CarteSonService getCarteSonServ() {
        return carteSonServ;
    }

    public static ClientService getClientServ() {
        return clientServ;
    }

    public static MesureService getMesureServ() {
        return mesureServ;
    }

    public static MontreService getMontreServ() {
        return montreServ;
    }

    public static OperateurService getOperateurServ() {
        return operateurServ;
    }

    public static ProprieteService getProprieteServ() {
        return proprieteServ;
    }

    public static RapportService getRapportServ() {
        return rapportServ;
    }

    public static AcquisitionService getAcquisitionServ() {
        return acquisitionServ;
    }

    public static RequetesService getRequeteSrv() {
        return requeteSrv;
    }
    
}
