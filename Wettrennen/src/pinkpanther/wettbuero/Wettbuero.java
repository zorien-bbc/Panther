package pinkpanther.wettbuero;

import java.util.Vector;

import pinkpanther.rennen.Rennen;
import pinkpanther.tier.Panther;

public class Wettbuero {
	private Rennen rennen;
	private Vector<Wette> wetten;
	private final double faktor = 10.0;

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
		Wettbuero wtb = new Wettbuero(rennen, new Vector<Wette>());
		for (int i = 0; i < 3; i++) {
			wtb.wetteAnnehmen(new Wette(pantherName.get(i), i + i, "Spieler"
					+ i));
		}
		System.out.println(wtb.toString().replace(',', ' ').replace('[', ' ')
				.replace(']', ' '));
		wtb.rennenDurchfuehren();
	}

	public Wettbuero(Rennen rennen, Vector<Wette> wetten) {
		this.rennen = rennen;
		this.wetten = wetten;
	}

	public void wetteAnnehmen(Wette wette) {
		for (Wette w : wetten) {
			if (!w.getPantherName().equals(wette.getPantherName())) {
				wetten.addElement(wette);
			}
		}
	}

	public void rennenDurchfuehren() {
		Panther panther = rennen.durchfuehren(rennen);
		for (Wette wette : wetten) {
			if (wette.getPantherName().equals(panther.getName())) {
				System.err.println("Wetten Gewinner: " + wette.getSpieler()
						+ " Gewinn: " + wette.getWettEinsatz() * faktor);
			}
		}

		System.out.println(rennen.toString().replace(',', ' ')
				.replace('[', ' ').replace(']', ' '));
	}

	@Override
	public String toString() {
		return "Wettbuero " + wetten;
	}

}
