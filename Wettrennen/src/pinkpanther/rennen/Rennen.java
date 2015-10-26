package pinkpanther.rennen;


import java.util.Vector;

import pinkpanther.tier.Panther;

public class Rennen {
    private String name;
    private int anzTeilnehmer;
    private Vector<Panther> panthers = new Vector<Panther>();
    private double zurueckzulegenderWeg;

    public Rennen(String name, int anzTeilnehmer, Vector<Panther> panthers,
            double zurueckgelegterWeg) {
        this.name = name;
        this.anzTeilnehmer = anzTeilnehmer;
        this.panthers = panthers;
        this.zurueckzulegenderWeg = zurueckgelegterWeg;
    }

    public void addPanther(Panther panther) {
        this.panthers.add(panther);
    }

    public void removePanther(String name) {
        for (Panther p : this.panthers) {
            if (p.getName().equals(name)) {
                this.panthers.remove(p);
            }
        }
    }

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

    public void lassPantherLaufen(Vector<Panther> panthers) {
        for (Panther panther : panthers) {
            panther.bewege();
        }
    }

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
