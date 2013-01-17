/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.Client;
import metier.Montre;

/**
 *
 * @author benoit
 */
class MontreORMServiceImpl implements MontreORMService {

    public MontreORMServiceImpl() {
    }

    @Override
    public void addMontre(Montre montre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeMontre(Montre montre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateMontre(Montre montre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Montre> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Montre getById(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Montre> getByFabricant(String fabricant) {
        ConnexionService.getPersistance();
        Query query = ConnexionService.em.createNamedQuery("getMontreByFabricant");
        query.setParameter("fabricant", fabricant);//
        List<Montre> montre = query.getResultList();
        ConnexionService.disconect();
        return montre;
    }
    
}
