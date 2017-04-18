package src.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.receiver.Moteur;

public class TestInserer {
	private static Moteur moteur = new Moteur();

	@Before
	public void setUp(){
		moteur = new Moteur();
	}

	@Test
	public void executeInserer(){
		StringBuffer str = new StringBuffer("testaco");
		moteur.getBuffer().setTexte(str);
		moteur.inserer("testaco");
		assertEquals(moteur.getBuffer().getTexte().toString(), "testacotestaco");
	}

}

