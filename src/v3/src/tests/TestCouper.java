package src.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


import src.receiver.Moteur;

public class TestCouper {
	private static Moteur moteur = new Moteur();
	
	@Before
	public void setUp(){
		moteur = new Moteur();
	}
	
	@Test
	public void executeCouper(){
		StringBuffer str = new StringBuffer("testaco");
		moteur.getBuffer().setTexte(str);
		moteur.setSelection(0, 4);
		moteur.couper();
		assertEquals("test", moteur.getPressePapier().getContenu().toString());
		assertEquals("aco", moteur.getBuffer().getTexte().toString());		
	}

}
