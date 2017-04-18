package src.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.receiver.Enregistreur;
import src.receiver.Moteur;

public class RedoTest {
	
	private static Moteur moteur;
	private static Enregistreur enregistreur;
	
	@Before
	public void setUp(){
		moteur = new Moteur();
		enregistreur = new Enregistreur(this.moteur);
	}
	
	@Test
	public void executeSelection(){
		StringBuffer str = new StringBuffer("testaco");
		moteur.getBuffer().setTexte(str);
		enregistreur.enregistrer(moteur.getBuffer());
		moteur.inserer("testaco");
		enregistreur.enregistrer(moteur.getBuffer());
		enregistreur.undo();
		enregistreur.redo();
		assertEquals(moteur.getBuffer().getTexte().toString(), "testacotestaco");
		
	}

}
