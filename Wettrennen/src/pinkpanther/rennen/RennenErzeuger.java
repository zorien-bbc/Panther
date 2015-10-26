package pinkpanther.rennen;

import java.util.Vector;

import pinkpanther.tier.Panther;

public class RennenErzeuger {

    public static void main(String[] args) {
        String[] pantherName = { "Pink Panther", "Red Panther", "Blue Panther",
                "Black Panther" };
        Rennen rennen = new Rennen("Cooles Rennen", 4, new Vector<Panther>(),
                1000);
        for (int i = 0; i < rennen.getAnzTeilnehmer(); i++) {
            rennen.addPanther(new Panther(pantherName[i]));
        }
        rennen.durchfuehren(rennen);
        for (Panther p : rennen.getPanthers()) {
            System.out.println(p.toString());
        }
    }

}
