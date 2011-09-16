package coloreGrafo;
import junit.framework.TestCase;
import coloracaodegrafoia.ColoreGrafo;
import coloracaodegrafoia.GrafoNo;

public class coloreGrafoTest extends TestCase {

    public coloreGrafoTest() {

        GrafoNo a = new GrafoNo();
        GrafoNo b = new GrafoNo();
        GrafoNo c = new GrafoNo();
        GrafoNo d = new GrafoNo();

        a.adicionaNoAdjacente(b);
        a.adicionaNoAdjacente(c);

        b.adicionaNoAdjacente(a);
        b.adicionaNoAdjacente(c);

        c.adicionaNoAdjacente(a);
        c.adicionaNoAdjacente(b);
        c.adicionaNoAdjacente(d);

        d.adicionaNoAdjacente(c);

        ColoreGrafo grafo = new ColoreGrafo();
        grafo.colore(a);




    }

}