/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import physique.data.ClientORMService;

/**
 *
 * @author saturne
 */
public class ClientServiceImpl implements ClientService {

    ClientORMService clientSrv = physique.data.PhysiqueDataFactory.getClienORMSrv();

    @Override
    public Client addClient(Client client) throws Exception {
        if(client != null) {
            return clientSrv.addClient(client);
        } else {
            
            throw new Exception("addClient impossible : Paramètre null !");
           
        }
        
    }

    @Override
    public void removeClient(Client client) throws Exception {
        if(client != null) {
            clientSrv.removeClient(client);
        } else {
            throw new Exception("removeClient impossible : Paramètre null !");
        }
    }

    @Override
    public void updateClient(Client client) throws Exception {
        if(client != null) {
            clientSrv.updateClient(client);
        } else {
            throw new Exception("updateClient impossible : Paramètre null !");
        }
    }

    @Override
    public List<Client> getAll() throws Exception {
        return clientSrv.getAll();
    }

    @Override
    public Client getById(long id) throws Exception {
        if(id < 0) {
            throw new Exception("getById impossible : id négatif !");
        } else {
            return clientSrv.getById(id);
        }
    }

    @Override
    public List<Client> getByNom(String nom) throws Exception {
        if (nom != null) {
            return clientSrv.getByNom(nom);
        } else {
            throw new Exception("getByNom impossible : Paramètre null !");
        }
    }

    @Override
    public List<Client> getByPrenom(String prenom) throws Exception {
        if (prenom != null) {
            return clientSrv.getByPrenom(prenom);
        } else {
            throw new Exception("getByPrenom impossible : Paramètre null !");
        }
    }
}
