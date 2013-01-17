/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;

/**
 *
 * @author saturne
 */
public class Rapport {
    
    private long id;
    private Date dateUpdate;
    private Montre montre;

    
    public Rapport(long id, Montre montre) {
        this.id = id;
        this.dateUpdate = new Date();
        this.montre = montre;
    }

    /**
     * Get the value of montre
     *
     * @return the value of montre
     */
    public Montre getMontre() {
        return montre;
    }

    /**
     * Set the value of montre
     *
     * @param montre new value of montre
     */
    public void setMontre(Montre montre) {
        this.montre = montre;
    }


    /**
     * Get the value of dateUpdate
     *
     * @return the value of dateUpdate
     */
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * Set the value of dateUpdate
     *
     * @param dateUpdate new value of dateUpdate
     */
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
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
        int hash = 3;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + (this.dateUpdate != null ? this.dateUpdate.hashCode() : 0);
        hash = 83 * hash + (this.montre != null ? this.montre.hashCode() : 0);
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
        final Rapport other = (Rapport) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Id : " + this.id + ", dateUpdate : " + this.dateUpdate + ", montre : " + this.montre.toString());
    }
}
