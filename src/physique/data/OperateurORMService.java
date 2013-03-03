/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.Operateur;

/**
 *
 * @author benoit
 */
public interface OperateurORMService {

    public Operateur addOperateur(Operateur operateur) throws Exception;

    public void removeOperateur(Operateur operateur) throws Exception;

    public void updateOperateur(Operateur operateur) throws Exception;

    public List<Operateur> getAll() throws Exception;

    public Operateur getById(long id) throws Exception;

    public List<Operateur> getByNom(String nom) throws Exception;

    public List<Operateur> getByPrenom(String prenom) throws Exception;

    public Operateur getByLogin(String login) throws Exception;
}
