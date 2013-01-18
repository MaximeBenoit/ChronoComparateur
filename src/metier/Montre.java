/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;

/**
 *
 * @author saturne
 */
public class Montre {
    
    private long id;
    private String fabricant;
    private Client proprietaire;
    private List<Signal> signal;

    
    public Montre() {
    }
    
/**
     * Get the value of signal
     *
     * @return the value of signal
     */
    public List<Signal> getSignal() {
        return signal;
    }

    /**
     * Set the value of signal
     *
     * @param signal new value of signal
     */
    public void setSignal(List<Signal> signal) {
        this.signal = signal;
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
        hash = 79 * hash + (this.signal != null ? this.signal.hashCode() : 0);
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
