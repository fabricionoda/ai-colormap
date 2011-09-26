package coloreGrafo;

import core.ColoreGrafoPSR;
import core.CoresEnum;
import exceptions.ColoreGrafoException;
import junit.framework.TestCase;

public class ColorePSRTest extends TestCase {
	
	public void testPSRCasoIdeal() {
		
		ColoreGrafoPSR colore = new ColoreGrafoPSR();
		
		colore.variaveis("A", "B", "C", "D", "E", "F");		
		colore.dominio(CoresEnum.BLUE, CoresEnum.GREEN, CoresEnum.RED);
		try {
			colore.novaRestricao("A", "B");
			colore.novaRestricao("A", "C");
			colore.novaRestricao("A", "E");
			colore.novaRestricao("B", "E");
			colore.novaRestricao("B", "E");
			colore.novaRestricao("B", "F");
			colore.novaRestricao("C", "E");
			colore.novaRestricao("C", "F");
			colore.novaRestricao("D", "F");
			colore.novaRestricao("E", "F");
			colore.colore();
		} catch (ColoreGrafoException e) {
			fail(e.getMessage());
		}
		
		assertEquals(6, colore.getVariaveis().size());
		
	}

}
