package pinkpanther.tier;

import java.util.Random;

/**
 * 
 * @author Oliver Aschwanden, Miguel Gomes, Nils Oriet
 *
 */
public class Panther {
    private String name;
    private String rasse;
    private double maxSpeed;
    private double zurueckgelegterWeg;

    public Panther(String name) {
        this.name = name;
        this.rasse = "Panther";
        this.maxSpeed = 16.7;
        this.zurueckgelegterWeg = 0;
    }

    /**
     * Generiert eine zufällige Zahl zwischen 0 und der Maximalen
     * Geschwindigkeit
     * 
     * @return randomValue
     */
    public double generateRandom() {
        Random r = new Random();
        double randomValue = 10 + (this.getMaxSpeed() - 0) * r.nextDouble();
        randomValue = Math.round(randomValue);
        return randomValue;
    }

    /**
     * Lässt Tier bewegen
     */
    public void bewege() {
        this.setZurueckgelegterWeg(this.getZurueckgelegterWeg()
                + generateRandom());
    }

    @Override
    public String toString() {
        return "Panther [name=" + name + ", rasse=" + rasse + ", maxSpeed="
                + maxSpeed + ", zurueckgelegterWeg=" + zurueckgelegterWeg + "]";
    }

    public double getZurueckgelegterWeg() {
        return zurueckgelegterWeg;
    }

    public void setZurueckgelegterWeg(double zurueckgelegterWeg) {
        this.zurueckgelegterWeg = zurueckgelegterWeg;
    }

    public String getName() {
        return name;
    }

    public String getRasse() {
        return rasse;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

}
