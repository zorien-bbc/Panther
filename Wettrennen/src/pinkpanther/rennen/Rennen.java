package pinkpanther.rennen;


import java.util.Vector;

import pinkpanther.tier.Panther;

/**
 * Diese Klasse verwaltet das Rennen
 * @author Miguel Gomes, Nils Oriet, Oliver Aschwanden
 *
 */

public class Rennen {
	
	// Dekleration der Variablen
    private String name;
    private int anzTeilnehmer;
    private Vector<Panther> panthers = new Vector<Panther>();
    private double zurueckzulegenderWeg;

    // Konstruktor
    public Rennen(String name, int anzTeilnehmer, Vector<Panther> panthers,
            double zurueckzulegenderWeg) {
        this.name = name;
        this.anzTeilnehmer = anzTeilnehmer;
        this.panthers = panthers;
        this.zurueckzulegenderWeg = zurueckzulegenderWeg;
    }

    /**
     * F�gt einen Panther dem Rennen hinzu
     * @param panther
     */
    public void addPanther(Panther panther) {
        this.panthers.add(panther);
    }

    /**
     * L�scht einen Panther vom Rennen
     * @param name
     */
    public void removePanther(String name) {
        for (Panther p : this.panthers) {
            if (p.getName().equals(name)) {
                this.panthers.remove(p);
            }
        }
    }

    /**
     * Ermittelt Gewinner des Rennens
     * @param panthers
     * @return Gewinner
     */
    public Panther ermittleGewinner(Vector<Panther> panthers) {
        Panther gewinner = null;
        for (Panther p : panthers) {
            if (p.getZurueckgelegterWeg() >= this.getZurueckzulegenderWeg()) {
                if (gewinner == null
                        || p.getZurueckgelegterWeg() > gewinner
                                .getZurueckgelegterWeg()) {
                    gewinner = p;
                }
            }
        }
        return gewinner;
    }

    /**
     * L�sst alle Panther einmal laufen
     * @param panthers
     */
    public void lassPantherLaufen(Vector<Panther> panthers) {
        for (Panther panther : panthers) {
            panther.bewege();
        }
    }

    /**
     * Startet das Rennen und gibt am Ende denn Gewinner aus
     * @param rennen
     */
    public void durchfuehren(Rennen rennen) {
        while(rennen.ermittleGewinner(rennen.getPanthers())==null){
            rennen.lassPantherLaufen(rennen.getPanthers());
        }
        Panther winner  = rennen.ermittleGewinner(rennen.getPanthers());
        System.err.println(winner.toString());
    }

    
    @Override
    public String toString() {
        return "Rennen [name=" + name + ", anzTeilnehmer=" + anzTeilnehmer
                + ", panthers=" + panthers + ", zurueckgelegterWeg="
                + zurueckzulegenderWeg + "]";
    }

    
    // Getter und Setter
    public String getName() {
        return name;
    }

    public int getAnzTeilnehmer() {
        return anzTeilnehmer;
    }

    public Vector<Panther> getPanthers() {
        return panthers;
    }

    public double getZurueckzulegenderWeg() {
        return zurueckzulegenderWeg;
    }

}
