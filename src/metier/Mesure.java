/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author saturne
 */
public class Mesure {
    
    private double periodeIdeale;
    private double tempsTACaTIC;
    private String tempsTICaTAC;
    private Propriete propriete;


    public Mesure() {
    }
    /**
     * Get the value of propriete
     *
     * @return the value of propriete
     */
    public Propriete getPropriete() {
        return propriete;
    }

    /**
     * Set the value of propriete
     *
     * @param propriete new value of propriete
     */
    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }
    
    /**
     * Get the value of tempsTICaTAC
     *
     * @return the value of tempsTICaTAC
     */
    public String getTempsTICaTAC() {
        return tempsTICaTAC;
    }

    /**
     * Set the value of tempsTICaTAC
     *
     * @param tempsTICaTAC new value of tempsTICaTAC
     */
    public void setTempsTICaTAC(String tempsTICaTAC) {
        this.tempsTICaTAC = tempsTICaTAC;
    }


    /**
     * Get the value of tempsTACaTIC
     *
     * @return the value of tempsTACaTIC
     */
    public double getTempsTACaTIC() {
        return tempsTACaTIC;
    }

    /**
     * Set the value of tempsTACaTIC
     *
     * @param tempsTACaTIC new value of tempsTACaTIC
     */
    public void setTempsTACaTIC(double tempsTACaTIC) {
        this.tempsTACaTIC = tempsTACaTIC;
    }


    /**
     * Get the value of periodeIdeale
     *
     * @return the value of periodeIdeale
     */
    public double getPeriodeIdeale() {
        return periodeIdeale;
    }

    /**
     * Set the value of periodeIdeale
     *
     * @param periodeIdeale new value of periodeIdeale
     */
    public void setPeriodeIdeale(double periodeIdeale) {
        this.periodeIdeale = periodeIdeale;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.periodeIdeale) ^ (Double.doubleToLongBits(this.periodeIdeale) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.tempsTACaTIC) ^ (Double.doubleToLongBits(this.tempsTACaTIC) >>> 32));
        hash = 83 * hash + (this.tempsTICaTAC != null ? this.tempsTICaTAC.hashCode() : 0);
        hash = 83 * hash + (this.propriete != null ? this.propriete.hashCode() : 0);
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
        final Mesure other = (Mesure) obj;
        if (Double.doubleToLongBits(this.periodeIdeale) != Double.doubleToLongBits(other.periodeIdeale)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tempsTACaTIC) != Double.doubleToLongBits(other.tempsTACaTIC)) {
            return false;
        }
        if ((this.tempsTICaTAC == null) ? (other.tempsTICaTAC != null) : !this.tempsTICaTAC.equals(other.tempsTICaTAC)) {
            return false;
        }
        if (this.propriete != other.propriete && (this.propriete == null || !this.propriete.equals(other.propriete))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return ("PeriodeIdeale : " + this.periodeIdeale + ", tempsTACaTIC : " + this.tempsTACaTIC + ", tempsTICaTAC : " + this.tempsTICaTAC + ", propriete : " + this.propriete.toString());
    }
}
