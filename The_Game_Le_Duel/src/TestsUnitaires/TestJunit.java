package TestsUnitaires;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import joueur.AttributsJoueur;
import table.Jeu;
import table.Pioche;

public class TestJunit {
	
	@Test
	public void testInitPiocheSans1et60() {
		Boolean test = false;
		int[] Pioch = new int[58];
		Pioche.init(Pioch);
		if(Pioch[0]==2 && Pioch[Pioch.length-1]==59) {
			
			test=true;
		}
		Assert.assertTrue(test);
		
	}
	@Test
	public void testMelangePioche() {
		int[] Tri� = new int[58];
		int[] melang� = new int[58];
		Boolean �gal=false;
		Pioche.init(Tri�);	
		Pioche.init(melang�);
		Pioche.melange(melang�);
		if(Arrays.equals(Tri�,melang�)) {
			�gal=true;
		}
		else
			�gal=false;
		
		Assert.assertFalse(�gal); // Elles sont differentes
	}

}
