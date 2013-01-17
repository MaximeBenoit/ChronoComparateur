/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import physique.data.MontreORMService;

/**
 *
 * @author saturne
 */
public class MontreServiceImpl implements MontreService {

    MontreORMService montreSrv = physique.data.PhysiqueDataFactory.getMontreORMSrv();

    @Override
    public void addMontre(Montre montre) throws Exception {
        if(montre != null) {
            montreSrv.addMontre(montre);
        } else {
            throw new Exception("addMontre impossible : Paramètre null !");
        }
    }

    @Override
    public void removeMontre(Montre montre) throws Exception {
        if(montre != null) {
            montreSrv.removeMontre(montre);
        } else {
            throw new Exception("removeMontre impossible : Paramètre null !");
        }
    }

    @Override
    public void updateMontre(Montre montre) throws Exception {
        if(montre != null) {
            montreSrv.updateMontre(montre);
        } else {
            throw new Exception("updateMontre impossible : Paramètre null !");
        }
    }

    @Override
    public List<Montre> getAll() throws Exception {
        return montreSrv.getAll();
    }

    @Override
    public Montre getById(long id) throws Exception {
        if(id < 0) {
            throw new Exception("getById impossible : id négatif !");
        } else {
            return montreSrv.getById(id);
        }
    }

    @Override
    public List<Montre> getByFabricant(String fabricant) throws Exception {
        if(fabricant != null) {
            return montreSrv.getByFabricant(fabricant);
        } else {
            throw new Exception("getByFabricant impossible : Paramètre null !");
        }
    }
}
