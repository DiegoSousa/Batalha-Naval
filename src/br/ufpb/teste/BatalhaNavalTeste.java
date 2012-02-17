package br.ufpb.teste;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import br.ufpb.exception.AfundouException;
import br.ufpb.model.Destroyer;
import br.ufpb.model.Embarcacao;

public class BatalhaNavalTeste {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void destroyHitTest() {
		Embarcacao destroyer = new Destroyer();
		assertEquals(4, destroyer.getLife());

		try {
			destroyer.hit();
		} catch (AfundouException e) {
			e.printStackTrace();
		}

		assertEquals(3, destroyer.getLife());

		try {
			destroyer.hit();
			destroyer.hit();
			destroyer.hit();
			fail();
		} catch (AfundouException e) {
			assertEquals(e.getMessage(), "AFUNDOU");	
		}
	}
		
}