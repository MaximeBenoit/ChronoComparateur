/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author saturne
 */
public class Propriete {

    private double pointMort;
    private double decalage;
    private int angleBalancier;

    public Propriete() {
    }

    /**
     * Get the value of angleBalancier
     *
     * @return the value of angleBalancier
     */
    public int getAngleBalancier() {
        return angleBalancier;
    }

    /**
     * Set the value of angleBalancier
     *
     * @param angleBalancier new value of angleBalancier
     */
    public void setAngleBalancier(int angleBalancier) {
        this.angleBalancier = angleBalancier;
    }

    /**
     * Get the value of decalage
     *
     * @return the value of decalage
     */
    public double getDecalage() {
        return decalage;
    }

    /**
     * Set the value of decalage
     *
     * @param decalage new value of decalage
     */
    public void setDecalage(double decalage) {
        this.decalage = decalage;
    }

    /**
     * Get the value of pointMort
     *
     * @return the value of pointMort
     */
    public double getPointMort() {
        return pointMort;
    }

    /**
     * Set the value of pointMort
     *
     * @param pointMort new value of pointMort
     */
    public void setPointMort(double pointMort) {
        this.pointMort = pointMort;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.pointMort) ^ (Double.doubleToLongBits(this.pointMort) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.decalage) ^ (Double.doubleToLongBits(this.decalage) >>> 32));
        hash = 83 * hash + this.angleBalancier;
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
        final Propriete other = (Propriete) obj;
        if (Double.doubleToLongBits(this.pointMort) != Double.doubleToLongBits(other.pointMort)) {
            return false;
        }
        if (Double.doubleToLongBits(this.decalage) != Double.doubleToLongBits(other.decalage)) {
            return false;
        }
        if (this.angleBalancier != other.angleBalancier) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("pointMort : " + this.pointMort + ", decalage : " + this.decalage + ", angleBalancier : " + this.angleBalancier);
    }
}
