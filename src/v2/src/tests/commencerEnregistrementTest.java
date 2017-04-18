package src.tests;

import org.junit.Before;
import org.junit.Test;

import src.receiver.Enregistreur;
import src.receiver.Moteur;

public class commencerEnregistrementTest {
	
	private static Moteur moteur;
	private static Enregistreur enregistreur;
	
	@Before
	public void setUp(){
		moteur = new Moteur();
		enregistreur = new Enregistreur();
	}
	
	@Test
	public void executeCommencer(){
		
		
	}

}

