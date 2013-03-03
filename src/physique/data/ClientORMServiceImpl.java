/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.Client;

/**
 *
 * @author benoit
 */
class ClientORMServiceImpl implements ClientORMService {

    public ClientORMServiceImpl() {
    }

    @Override
    public Client addClient(Client client) {
        ConnexionService.getPersistance();
        ConnexionService.em.persist(client);
        ConnexionService.em.flush();
        ConnexionService.disconect();
        return client;
    }

    @Override
    public void removeClient(Client client) {
        ConnexionService.getPersistance();
        ConnexionService.em.remove(ConnexionService.em.merge(client));
        ConnexionService.disconect();
    }

    @Override
    public void updateClient(Client client) {
        ConnexionService.getPersistance();
        ConnexionService.em.merge(client);
        ConnexionService.disconect();
    }

    @Override
    public List<Client> getAll() throws Exception {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("clientGetAll");
        List<Client> clients = query.getResultList();
        ConnexionService.disconect();
        return clients;
    }

    @Override
    public Client getById(long id) {
        ConnexionService.getPersistance();
        Client client = ConnexionService.em.find(Client.class, id);
        ConnexionService.disconect();
        return client;
    }

    @Override
    public List<Client> getByNom(String nom) {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("getClientByNom");
        query.setParameter("nom", nom);
        List<Client> client = query.getResultList();
        ConnexionService.disconect();
        return client;
    }

    @Override
    public List<Client> getByPrenom(String prenom) {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("getClientByPrenom");
        query.setParameter("prenom", prenom);
        List<Client> client = query.getResultList();
        ConnexionService.disconect();
        return client;
    }
}
