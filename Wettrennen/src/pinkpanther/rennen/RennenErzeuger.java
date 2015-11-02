package pinkpanther.rennen;

import java.util.Vector;

import pinkpanther.tier.Panther;

public class RennenErzeuger {

	public static void main(String[] args) {
		Vector<String> pantherName = new Vector<String>();
		pantherName.add("Black Panther");
		pantherName.add("Pink Panther");
		pantherName.add("Blue Panther");
		pantherName.add("Red Panther");
		Rennen rennen = new Rennen("Cooles Rennen", 4, new Vector<Panther>(),
				1000);
		for (int i = 0; i < rennen.getAnzTeilnehmer(); i++) {
			rennen.addPanther(new Panther(pantherName.get(i)));
		}
		rennen.durchfuehren(rennen);
		System.out.println(rennen.toString().replace(',', ' ')
				.replace('[', ' ').replace(']', ' '));

	}

}
