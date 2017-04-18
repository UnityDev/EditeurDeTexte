package src.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.receiver.Moteur;

public class TestColler {
	
	private static Moteur moteur;
	
	@Before
	public void setUp(){
		moteur = new Moteur();
	}
	
	@Test
	public void executeSelection(){
		StringBuffer str = new StringBuffer("testaco");
		moteur.getBuffer().setTexte(str);
		moteur.getPressePapier().setContenu("test");
		moteur.coller();
		assertEquals(new StringBuffer("testtestaco").toString() , moteur.getBuffer().getTexte().toString());
		
	}

}
