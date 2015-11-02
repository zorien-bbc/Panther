package pinkpanther.wettbuero;

public class Wette {
	private String pantherName;
	private int wettEinsatz;
	private String spieler;

	public Wette(String pantherName, int wettEinsatz, String spieler) {
		this.pantherName = pantherName;
		this.wettEinsatz = wettEinsatz;
		this.spieler = spieler;
	}

	@Override
	public String toString() {
		return "Wette: \n\tPanther Name=" + pantherName + "\n\tEinsatz="
				+ wettEinsatz + "\n\tSpieler=" + spieler;
	}

	public String getPantherName() {
		return pantherName;
	}

	public int getWettEinsatz() {
		return wettEinsatz;
	}

	public String getSpieler() {
		return spieler;
	}

}
