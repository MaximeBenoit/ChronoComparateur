/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.Client;

/**
 *
 * @author benoit
 */
public interface ClientORMService {

    public Client addClient(Client client) throws Exception;

    public void removeClient(Client client) throws Exception;

    public void updateClient(Client client) throws Exception;

    public List<Client> getAll() throws Exception;

    public Client getById(long id) throws Exception;

    public List<Client> getByNom(String nom) throws Exception;

    public List<Client> getByPrenom(String prenom) throws Exception;
}
