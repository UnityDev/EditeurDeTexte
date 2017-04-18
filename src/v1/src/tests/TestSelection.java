package src.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.receiver.Moteur;

public class TestSelection {
	private static Moteur moteur = new Moteur();
	
	@Before
	public void setUp(){
		moteur = new Moteur();
	}
	
	@Test
	public void executeSelection(){
		StringBuffer str = new StringBuffer("testaco");
		moteur.getBuffer().setTexte(str);
		moteur.setSelection(0, 4);
		assertEquals(moteur.getSelection().toString(), "test");
	}

}
