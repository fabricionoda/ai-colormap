package coloreGrafo;
import main.ColoreGrafosController;
import core.ColoreGrafoBuscaEmLargura;
import core.ColoreGrafoHelper;
import core.CoresEnum;
import core.GrafoNo;
import exceptions.ColoreGrafoException;
import exceptions.ImpossivelColorirException;
import exceptions.ReferenciaCiclicaException;
import junit.framework.TestCase;

public class coloreGrafoTest extends TestCase {

	@Override
	protected void setUp() {
		ColoreGrafoHelper.getInstancia().reset();
	}
	
    public void testColoreGrafo() {

        GrafoNo a = new GrafoNo("a");
        GrafoNo b = new GrafoNo("b");
        GrafoNo c = new GrafoNo("c");
        GrafoNo d = new GrafoNo("d");

        try {
	        a.adicionaNoAdjacente(b);
	        a.adicionaNoAdjacente(c);
	        b.adicionaNoAdjacente(c);
	        c.adicionaNoAdjacente(d);
	        
	        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
	        grafo.colore(a);
	    } catch (ColoreGrafoException e) {
	    	fail(e.getMessage());
		}
	           
        assertEquals(CoresEnum.RED , a.getCor());
        assertEquals(2, a.getQuantidadeNosAdjacentes());
        
        assertEquals(CoresEnum.GREEN , b.getCor());
        assertEquals(2, b.getQuantidadeNosAdjacentes());
        
        assertEquals(CoresEnum.BLUE , c.getCor());
        assertEquals(3, c.getQuantidadeNosAdjacentes());
        
        assertEquals(CoresEnum.RED , d.getCor());
        assertEquals(1, d.getQuantidadeNosAdjacentes());
    }
    
    public void testAdicionaMultiplosAdjacentes() {

        GrafoNo a = new GrafoNo("a");
        GrafoNo b = new GrafoNo("b");
        GrafoNo c = new GrafoNo("c");
        GrafoNo d = new GrafoNo("d");

        try {
        	a.adicionaNoAdjacente(a);
        	fail("Deveria ter dado excecao");
        } catch (ReferenciaCiclicaException e) {
    	}
        
        try {
        	a.adicionaNoAdjacente(b);
        	a.adicionaNoAdjacente(b);
        	a.adicionaNoAdjacente(b);
        	a.adicionaNoAdjacente(b);
        	
            a.adicionaNoAdjacente(c);
            b.adicionaNoAdjacente(c);
            c.adicionaNoAdjacente(d);
        
            ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
            grafo.colore(a);            
        } catch (ImpossivelColorirException e) {
        	fail(e.getMessage());
    	} catch (ReferenciaCiclicaException e) {
    		fail(e.getMessage());
    	}	
               
        assertEquals(CoresEnum.RED , a.getCor());
        assertEquals(CoresEnum.GREEN , b.getCor());
        assertEquals(CoresEnum.BLUE , c.getCor());
        assertEquals(CoresEnum.RED , d.getCor());
    }
    
    public void testTentaColorirGrafoImpossivelDeSerColorido() {

        GrafoNo a = new GrafoNo("a");
        GrafoNo b = new GrafoNo("b");
        GrafoNo c = new GrafoNo("c");
        GrafoNo d = new GrafoNo("d");

        try {
        	a.adicionaNoAdjacente(b);
        	a.adicionaNoAdjacente(c);
        	a.adicionaNoAdjacente(d);
        	
        	b.adicionaNoAdjacente(c);
        	b.adicionaNoAdjacente(d);
        	
        	c.adicionaNoAdjacente(d);
        	
        } catch (ColoreGrafoException ex) {
        	fail(ex.getMessage());
    	}	

        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        try {
        	grafo.colore(a);
        	fail("Deveria ter dado excecao");
        } catch (ColoreGrafoException ex) {
        	//
        }
    }
    
    public void testRodaGrafosDoController() {
    	try {
    		ColoreGrafosController.getInstancia().buscaLargura4Nos();
    		ColoreGrafosController.getInstancia().buscaLargura5Nos();
    		ColoreGrafosController.getInstancia().buscaLargura6Nos();
    		ColoreGrafosController.getInstancia().buscaLargura7Nos();
    		ColoreGrafosController.getInstancia().buscaLargura8Nos();
    		ColoreGrafosController.getInstancia().buscaLargura10Nos();
    		ColoreGrafosController.getInstancia().buscaLargura15Nos();
    		ColoreGrafosController.getInstancia().buscaLargura20Nos();
    		ColoreGrafosController.getInstancia().buscaLargura30Nos();
    		ColoreGrafosController.getInstancia().buscaLargura40Nos();
    		
    		assertTrue(true);
    	} catch (Exception e) {
    		fail(e.getMessage());
    	}
    }

}