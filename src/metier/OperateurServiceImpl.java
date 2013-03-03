/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import physique.data.OperateurORMService;

/**
 *
 * @author saturne
 */
public class OperateurServiceImpl implements OperateurService {

    OperateurORMService operateurSrv = physique.data.PhysiqueDataFactory.getOperateurORMSrv();

    @Override
    public Operateur addOperateur(Operateur operateur) throws Exception {
        if (operateur != null) {
            return operateurSrv.addOperateur(operateur);
        } else {
            throw new Exception("addOperateur impossible : Paramètre null !");
        }
    }

    @Override
    public void removeOperateur(Operateur operateur) throws Exception {
        if (operateur != null) {
            operateurSrv.removeOperateur(operateur);
        } else {
            throw new Exception("removeOperateur impossible : Paramètre null !");
        }
    }

    @Override
    public void updateOperateur(Operateur operateur) throws Exception {
        if (operateur != null) {
            operateurSrv.updateOperateur(operateur);
        } else {
            throw new Exception("updateOperateur impossible : Paramètre null !");
        }
    }

    @Override
    public List<Operateur> getAll() throws Exception {
        return operateurSrv.getAll();
    }

    @Override
    public Operateur getById(long id) throws Exception {
        if (id < 0) {
            throw new Exception("getById impossible : id négatif !");
        } else {
            return operateurSrv.getById(id);
        }
    }

    @Override
    public List<Operateur> getByNom(String nom) throws Exception {
        if (nom != null) {
            return operateurSrv.getByNom(nom);
        } else {
            throw new Exception("getByNom impossible : Paramètre null !");
        }
    }

    @Override
    public List<Operateur> getByPrenom(String prenom) throws Exception {
        if (prenom != null) {
            return operateurSrv.getByPrenom(prenom);
        } else {
            throw new Exception("getByPrenom impossible : Paramètre null !");
        }
    }

    @Override
    public Operateur getByLogin(String login) throws Exception {
        if (login != null) {
            return operateurSrv.getByLogin(login);
        } else {
            throw new Exception("getByLogin impossible : Paramètre null !");
        }
    }
}
