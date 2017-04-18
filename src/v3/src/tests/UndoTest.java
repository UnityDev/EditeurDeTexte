package src.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.receiver.Moteur;
import src.receiver.Enregistreur;

public class UndoTest {
	
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
		assertEquals(moteur.getBuffer().getTexte().toString(), "testaco");
		
	}

}