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
public class Signal {
    
    private long id;
    private Date dateAcquisition;
    private Operateur operateur;
    private PositionMontre positionMontre;

    public Signal(long id, Date dateAcquisition, Operateur operateur, PositionMontre positionMontre) {
        this.id = id;
        this.dateAcquisition = dateAcquisition;
        this.operateur = operateur;
        this.positionMontre = positionMontre;
    }
    

    /**
     * Get the value of positionMontre
     *
     * @return the value of positionMontre
     */
    public PositionMontre getPositionMontre() {
        return positionMontre;
    }

    /**
     * Set the value of positionMontre
     *
     * @param positionMontre new value of positionMontre
     */
    public void setPositionMontre(PositionMontre positionMontre) {
        this.positionMontre = positionMontre;
    }

    /**
     * Get the value of operateur
     *
     * @return the value of operateur
     */
    public Operateur getOperateur() {
        return operateur;
    }

    /**
     * Set the value of operateur
     *
     * @param operateur new value of operateur
     */
    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }


    /**
     * Get the value of dateAcquisition
     *
     * @return the value of dateAcquisition
     */
    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    /**
     * Set the value of dateAcquisition
     *
     * @param dateAcquisition new value of dateAcquisition
     */
    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
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
        hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 11 * hash + (this.dateAcquisition != null ? this.dateAcquisition.hashCode() : 0);
        hash = 11 * hash + (this.operateur != null ? this.operateur.hashCode() : 0);
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
        final Signal other = (Signal) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Id : " + this.id + ", dateAcquisition : " + this.dateAcquisition + ", operateur : " + this.operateur.toString());
    }
}
