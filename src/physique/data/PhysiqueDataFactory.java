/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

/**
 *
 * @author benoit
 */
public class PhysiqueDataFactory {
    
    private static OperateurORMService operateurORMSrv = new OperateurORMServiceImpl();
    private static AcquisitionORMService AcquisitionORMSrv = new AcquisitionORMServiceImpl();
    private static ClientORMService clienORMSrv = new ClientORMServiceImpl();
    private static MontreORMService montreORMSrv = new MontreORMServiceImpl();
    private static RapportORMService rapportORMSrv = new RapportORMServiceImpl();
    private static ProprieteService proprieteSrv = new ProprieteServiceImpl();
    private static MesureService mesureSrv = new MesureServiceImpl();
    private static XMLRPCService requeteSrv = new XMLRPCServiceImpl();
    
    public static ClientORMService getClienORMSrv() {
        return clienORMSrv;
    }

    public static MontreORMService getMontreORMSrv() {
        return montreORMSrv;
    }

    public static RapportORMService getRapportORMSrv() {
        return rapportORMSrv;
    }

    
    
    public static OperateurORMService getOperateurORMSrv() {
        return operateurORMSrv;
    }


    public static AcquisitionORMService getAcquisitionORMSrv() {
        return AcquisitionORMSrv;
    }

    public static ProprieteService getProprieteSrv() {
        return proprieteSrv;
    }

    public static MesureService getMesureSrv() {
        return mesureSrv;
    }

    public static XMLRPCService getRequeteSrv() {
        return requeteSrv;
    }


   

    
}

