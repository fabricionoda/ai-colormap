package coloreGrafo;

import java.util.LinkedList;

import core.ColoreGrafoPSR;
import core.CoresEnum;
import core.GrafoNo;
import exceptions.ColoreGrafoException;
import exceptions.ImpossivelColorirException;
import junit.framework.TestCase;

public class ColorePSRTest extends TestCase {
	
	public void testPSRCasoIdeal() {
		
		ColoreGrafoPSR colore = new ColoreGrafoPSR();
		
		colore.variaveis("A", "B", "C", "D", "E", "F");		
		colore.dominio(CoresEnum.BLUE, CoresEnum.GREEN, CoresEnum.RED);
		colore.ativarHeuristicaDeOrdenarPorRestricao();
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
		
		assertEquals(variaveis.get(0).getNome(), "F");
		assertEquals(variaveis.get(1).getNome(), "E");
		assertEquals(variaveis.get(2).getNome(), "C");
		assertEquals(variaveis.get(3).getNome(), "B");
		assertEquals(variaveis.get(4).getNome(), "A");
		assertEquals(variaveis.get(5).getNome(), "D");
		
	}
	
	public void testPSRCasoBacktrack() {
		
		ColoreGrafoPSR colore = new ColoreGrafoPSR();
		
		colore.variaveis("A", "B", "C", "D", "E", "F");		
		colore.dominio(CoresEnum.BLUE, CoresEnum.GREEN, CoresEnum.RED);
		colore.desativarHeuristicaDeOrdenarPorRestricao();
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
		} catch (ImpossivelColorirException e) {
			fail("backtrack deveria ter sido capturado");
		} catch (ColoreGrafoException e) {
			fail(e.getMessage());
		}
		
		LinkedList<GrafoNo> variaveis = colore.getVariaveis();
		
		assertEquals(6, variaveis.size());
		
		assertEquals(variaveis.get(0).getNome(), "F");
		assertEquals(variaveis.get(1).getNome(), "E");
		assertEquals(variaveis.get(2).getNome(), "C");
		assertEquals(variaveis.get(3).getNome(), "B");
		assertEquals(variaveis.get(4).getNome(), "A");
		assertEquals(variaveis.get(5).getNome(), "D");
		
	}	

}
