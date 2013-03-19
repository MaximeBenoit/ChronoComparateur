/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author saturne
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "rapportGetAll", query = "SELECT r FROM Rapport r"),
    @NamedQuery(name = "rapportGetByDateUpdate", query = "SELECT r FROM Rapport r WHERE r.dateUpdate = :dateUpdate")
})
public class Rapport implements Serializable{
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
    private boolean isEmpty;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateUpdate;
    @OneToMany(mappedBy = "rapport",cascade= CascadeType.REMOVE)
    private List<Acquisition> acquisitions;

    
    public Rapport() {
    }

    public List<Acquisition> getAcquisition() {
        return acquisitions;
    }

    public void setAcquisition(List<Acquisition> acquisitions) {
        this.acquisitions = acquisitions;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
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
        hash = 83 * hash + (this.acquisitions != null ? this.acquisitions.hashCode() : 0);
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
        return ("Id : " + this.id + ", dateUpdate : " + this.dateUpdate + ", montre : " + this.acquisitions.toString());
    }
}
