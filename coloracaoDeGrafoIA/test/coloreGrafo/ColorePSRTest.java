package coloreGrafo;

import java.util.LinkedList;

import core.ColoreGrafoPSR;
import core.CoresEnum;
import core.GrafoNo;
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
			colore.novaRestricao("B", "F");
			colore.novaRestricao("C", "E");
			colore.novaRestricao("C", "F");
			colore.novaRestricao("D", "F");
			colore.novaRestricao("E", "F");
			colore.colore();
		} catch (ColoreGrafoException e) {
			fail(e.getMessage());
		}
		
		LinkedList<GrafoNo> variaveis = colore.getVariaveis();
		
		assertEquals(6, variaveis.size());
		
		assertEquals(variaveis.get(0).getNome(), "E");
		assertEquals(variaveis.get(1).getNome(), "F");
		assertEquals(variaveis.get(1).getNome(), "A");
		assertEquals(variaveis.get(1).getNome(), "C");
		assertEquals(variaveis.get(1).getNome(), "B");
		assertEquals(variaveis.get(1).getNome(), "D");
		
	}

}
