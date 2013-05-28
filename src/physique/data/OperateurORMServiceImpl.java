/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import metier.Operateur;

/**
 *
 * @author benoit
 */
class OperateurORMServiceImpl implements OperateurORMService {

    public OperateurORMServiceImpl() {
    }

    @Override
    public Operateur addOperateur(Operateur operateur) {
        ConnexionService.getPersistance();
        ConnexionService.em.persist(operateur);
        ConnexionService.em.flush();// Mettre flush en com pour initialiser la BDD
        ConnexionService.disconect();
        return operateur;
    }

    @Override
    public void removeOperateur(Operateur operateur) {
        ConnexionService.getPersistance();
        ConnexionService.em.remove(ConnexionService.em.merge(operateur));
        ConnexionService.disconect();
    }

    @Override
    public void updateOperateur(Operateur operateur) {
        ConnexionService.getPersistance();
        ConnexionService.em.merge(operateur);
        ConnexionService.disconect();
    }

    @Override
    public List<Operateur> getAll() throws Exception {
        ConnexionService.getPersistance();//Connexion BDD
        Query query = ConnexionService.em.createNamedQuery("operateurGetAll");//Envoi requete
        List<Operateur> operateurs = query.getResultList();//Recuperation list
        ConnexionService.disconect();//Déconexion
        return operateurs;



    }

    @Override
    public Operateur getById(long id) {
        ConnexionService.getPersistance();
        Operateur operateur = ConnexionService.em.find(Operateur.class, id);
        ConnexionService.disconect();
        return operateur;
    }

    @Override
    public List<Operateur> getByNom(String nom) {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("operateurGetByNom");
        query.setParameter("nom", nom);//Parametre de la requete (recuperer colone Nom);
        List<Operateur> operateurs = query.getResultList();
        ConnexionService.disconect();
        return operateurs;


    }

    @Override
    public List<Operateur> getByPrenom(String prenom) {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("getByPrenom");
        query.setParameter("prenom", prenom);
        List<Operateur> operateurs = query.getResultList();
        ConnexionService.disconect();
        return operateurs;
    }

    @Override
    public Operateur getByLogin(String login) {
        System.out.println(login);
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("getByLogin");
        query.setParameter("login", login);
        Operateur operateurs;
        try {
            operateurs = (Operateur) query.getSingleResult();
        } catch (NoResultException e) {
            operateurs = null;
        }
        ConnexionService.disconect();
        return operateurs;
    }
}
