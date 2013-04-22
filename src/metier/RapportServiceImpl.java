/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.List;
import physique.data.RapportORMService;

/**
 *
 * @author saturne
 */
public class RapportServiceImpl implements RapportService {
    RapportORMService rapportSrv = physique.data.PhysiqueDataFactory.getRapportORMSrv();

    @Override
    public Rapport addRapport(Rapport rapport) throws Exception {
        if(rapport != null) {
           return rapportSrv.addRapport(rapport);
        } else {
            throw new Exception("addRapport impossible : Paramètre null !");
        }
        
    }

    @Override
    public void removeRapport(Rapport rapport) throws Exception {
        if(rapport != null) {
            rapportSrv.removeRapport(rapport);
        } else {
            throw new Exception("removeRapport impossible : Paramètre null !");
        }
    }

    @Override
    public void updateRapport(Rapport rapport) throws Exception {
        if(rapport != null) {
            rapportSrv.updateRapport(rapport);
        } else {
            throw new Exception("updateRapport impossible : Paramètre null !");
        }
    }

    @Override
    public List<Rapport> getAll() throws Exception {
        return rapportSrv.getAll();
    }

    @Override
    public Rapport getById(long id) throws Exception {
        if(id < 0) {
            throw new Exception("getById impossible : id négatif !");
        } else {
            return rapportSrv.getById(id);
        }
    }

    @Override
    public List<Rapport> getByDateUpdate(Date dateUpdate) throws Exception {
        if(dateUpdate != null) {
            return rapportSrv.getByDateUpdate(dateUpdate);
        } else {
            throw new Exception("getByDateUpdate impossible : Paramètre null !");
        }
    }

//    @Override
//    public Rapport getByMontre(Montre montre) throws Exception {
//        if(montre != null) {
//            return rapportSrv.getByMontre(montre);
//        } else {
//            throw new Exception("getByMontre impossible : Paramètre null !");
//        }
//    }

    @Override
    public List<Rapport> getByDefaut(Rapport defaut) throws Exception {
        if (defaut != null) {
            return rapportSrv.getByDefaut(defaut);
        } else {
            throw new Exception("getByDefaut impossible : Paramètre null !");
        }
    }
    
    
}
