/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author saturne
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "acquisitionGetAll", query = "SELECT s FROM Acquisition s"),
    @NamedQuery(name = "acquisitionGetByDateAcquisition", query = "SELECT s FROM Acquisition s WHERE s.dateAcquisition = :dateAcquisition"),
    @NamedQuery(name = "acquisitionGetByPositionMontre", query = "SELECT s FROM Acquisition s WHERE s.positionMontre = :positionMontre")
})
public class Acquisition implements Serializable {

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
    private short[] tabpoints;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateAcquisition;
    @ManyToOne
    private Operateur operateur;
    private PositionMontre positionMontre;
    

    public Acquisition() {
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

    public short[] getTabpoints() {
        return tabpoints;
    }

    public void setTabpoints(short[] tabpoints) {
        this.tabpoints = tabpoints;
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
        final Acquisition other = (Acquisition) obj;
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
