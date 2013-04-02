/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author maxime
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "montreGetAll", query = "SELECT m FROM Montre m"),
    @NamedQuery(name = "getMontreByFabricant", query = "SELECT m FROM Montre m WHERE m.fabricant = :fabricant"),
    @NamedQuery(name = "getMontreByProprietaire", query = "SELECT m FROM Montre m WHERE m.proprietaire = :proprietaire"),
    @NamedQuery(name = "getMontreByRapport", query = "SELECT m FROM Montre m WHERE m.rapport = :rapport")
})
public class Montre implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fabricant;
    @ManyToOne
    private Client proprietaire;
    
    @ManyToOne(cascade= CascadeType.REMOVE)
    private Rapport rapport;
    

    public Montre() {
    }

    public Rapport getRapport() {
        return rapport;
    }

    public void setRapport(Rapport rapport) {
        this.rapport = rapport;
    }

    
    /**
     * Get the value of proprietaire
     *
     * @return the value of proprietaire
     */
    public Client getProprietaire() {
        return proprietaire;
    }

    /**
     * Set the value of proprietaire
     *
     * @param proprietaire new value of proprietaire
     */
    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * Get the value of fabricant
     *
     * @return the value of fabricant
     */
    public String getFabricant() {
        return fabricant;
    }

    /**
     * Set the value of fabricant
     *
     * @param fabricant new value of fabricant
     */
    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + (this.fabricant != null ? this.fabricant.hashCode() : 0);
        hash = 79 * hash + (this.proprietaire != null ? this.proprietaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Montre other = (Montre) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Id : " + this.id + ", fabricant : " + this.fabricant + ", proprietaire : " + this.proprietaire.toString());
    }
}
