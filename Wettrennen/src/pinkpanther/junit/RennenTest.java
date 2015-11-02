package pinkpanther.junit;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import pinkpanther.rennen.Rennen;
import pinkpanther.tier.Panther;

public class RennenTest {
	Rennen rennen = new Rennen("Cooles Rennen", 4, new Vector<Panther>(), 1000);

	@Test
	public void testForErmittleGewinner() {
		String[] pantherName = { "Pink Panther", "Red Panther", "Blue Panther",
				"Black Panther" };

		for (int i = 0; i < 4; i++) {
			rennen.addPanther(new Panther(pantherName[i]));
		}
		rennen.getPanthers().get(0)
				.setZurueckgelegterWeg(rennen.getZurueckzulegenderWeg());
		rennen.getPanthers().get(1)
				.setZurueckgelegterWeg(rennen.getZurueckzulegenderWeg() + 100);
		assertEquals(rennen.ermittleGewinner(rennen.getPanthers()), rennen
				.getPanthers().get(1));
	}

	@Test
	public void testForRemovePanther() {
		String[] pantherName = { "Pink Panther", "Red Panther", "Blue Panther",
				"Black Panther" };

		for (int i = 0; i < 4; i++) {
			rennen.addPanther(new Panther(pantherName[i]));
		}
		rennen.removePanther("Pink Panther");
		assertEquals(3, rennen.getPanthers().size());
	}

}
