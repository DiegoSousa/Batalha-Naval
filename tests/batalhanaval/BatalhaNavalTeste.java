package batalhanaval;

import static org.junit.Assert.*;
import org.junit.Test;


public class BatalhaNavalTeste {

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

	@Test
	public void tipoTamTest() {
		assertEquals(4, Tipo.CRUZADOR.getTam());
		assertEquals(4, Tipo.DESTROYER.getTam());
		assertEquals(2, Tipo.PATRULHA.getTam());
		assertEquals(5, Tipo.PORTA_AVIOES.getTam());
		assertEquals(3, Tipo.SUBMARINO.getTam());
	}

	@Test
	public void tabuleiroAddEmbarcacaoTest() {
		Tabuleiro tabuleiro = new Tabuleiro();
		try {
			tabuleiro.addEmbarcacao("CRUZADOR", 7, 4, 11, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Embarcacao[][] m = tabuleiro.getTabuleiro();
		assertNotNull(m);
		assertEquals(Tipo.CRUZADOR, m[6][3].getTipo());// ps:O local é n-1 na
														// linha e na coluna.
		assertEquals(Tipo.CRUZADOR, m[7][3].getTipo());
		assertEquals(Tipo.CRUZADOR, m[8][3].getTipo());
		assertEquals(Tipo.CRUZADOR, m[9][3].getTipo());
		assertEquals(Tipo.CRUZADOR, m[10][3].getTipo());
		assertNull(m[13][3]);
	}

	@Test
	public void tabuleiroShootAtTest() {
		Tabuleiro tabuleiro = new Tabuleiro();
		String result;
		try {
			tabuleiro.addEmbarcacao("DESTROYER", 5, 7, 5, 10);
			result = tabuleiro.shootAt(4, 6);
			assertEquals("ACERTOU", result);
			result = tabuleiro.shootAt(5, 1);
			assertEquals("AGUA", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}