package main;

import java.util.LinkedList;
import java.util.List;

import core.ColoreGrafoBuscaEmLargura;
import core.GrafoNo;
import exceptions.ColoreGrafoException;

public class ColoreGrafosController {

	private static ColoreGrafosController instancia;
	
	private ColoreGrafosController() {
		
	}
	
	public static ColoreGrafosController getController() {
		return ColoreGrafosController.getInstancia();
	}
	
	public static ColoreGrafosController getInstancia() {
		if (instancia == null)
			instancia = new ColoreGrafosController();
		
		return instancia;
	}
	
	private LinkedList<GrafoNo> grafoSimples4Nos() throws ColoreGrafoException {
        GrafoNo a = new GrafoNo("a");
        GrafoNo b = new GrafoNo("b");
        GrafoNo c = new GrafoNo("c");
        GrafoNo d = new GrafoNo("d");

        a.adicionaNoAdjacente(b);
        a.adicionaNoAdjacente(c);
        b.adicionaNoAdjacente(c);
        c.adicionaNoAdjacente(d);
        
        LinkedList<GrafoNo> nos =  new LinkedList<GrafoNo>();
        nos.add(a);
        nos.add(b);
        nos.add(c);
        nos.add(d);
        return nos;
	}
	
	private List<GrafoNo> grafoSimples7Nos() throws ColoreGrafoException {
        GrafoNo a = new GrafoNo("a");
        GrafoNo b = new GrafoNo("b");
        GrafoNo c = new GrafoNo("c");
        GrafoNo d = new GrafoNo("d");
        GrafoNo e = new GrafoNo("e");
        GrafoNo f = new GrafoNo("f");
        GrafoNo h = new GrafoNo("h");

        a.adicionaNoAdjacente(b);
        a.adicionaNoAdjacente(c);
        b.adicionaNoAdjacente(c);
        c.adicionaNoAdjacente(d);
        e.adicionaNoAdjacente(c);
        e.adicionaNoAdjacente(b);        
        f.adicionaNoAdjacente(h);        
        
        LinkedList<GrafoNo> nos =  new LinkedList<GrafoNo>();
        nos.add(a);
        nos.add(b);
        nos.add(c);
        nos.add(d);
        nos.add(e);
        nos.add(f);
        nos.add(h);
        return nos;	
	}
	
	private List<GrafoNo> grafoSimples20Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples7Nos();
		
        GrafoNo a = nos.get(0);
        GrafoNo i = new GrafoNo("i");
        GrafoNo j = new GrafoNo("j");
        GrafoNo k = new GrafoNo("k");
        GrafoNo l = new GrafoNo("l");
        GrafoNo m = new GrafoNo("m");
        GrafoNo n = new GrafoNo("n");
        GrafoNo o = new GrafoNo("o");
        GrafoNo p = new GrafoNo("p");
        GrafoNo q = new GrafoNo("q");
        GrafoNo r = new GrafoNo("r");
        GrafoNo s = new GrafoNo("s");
        GrafoNo t = new GrafoNo("t");
        GrafoNo u = new GrafoNo("u");
        i.adicionaNoAdjacente(nos.get(1));
        i.adicionaNoAdjacente(nos.get(6));
        j.adicionaNoAdjacente(nos.get(3));
        k.adicionaNoAdjacente(j);
        l.adicionaNoAdjacente(k);
        m.adicionaNoAdjacente(l);
        m.adicionaNoAdjacente(nos.get(2));
        o.adicionaNoAdjacente(n);
        p.adicionaNoAdjacente(n);
        q.adicionaNoAdjacente(a);
        r.adicionaNoAdjacente(p);
        s.adicionaNoAdjacente(l);
        s.adicionaNoAdjacente(m);
        t.adicionaNoAdjacente(n);
        u.adicionaNoAdjacente(j);
        u.adicionaNoAdjacente(n);
        
        nos.add(i);
        nos.add(j);
        nos.add(k);
        nos.add(l);
        nos.add(m);
        nos.add(n);
        nos.add(o);
        nos.add(p);
        nos.add(q);
        nos.add(r);
        nos.add(s);
        nos.add(t);
        nos.add(u);
        return nos;	
	}
	
	private List<GrafoNo> grafoSimples30Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples20Nos();
		GrafoNo a = nos.get(0);
		GrafoNo p = nos.get(19);
		
		GrafoNo v = new GrafoNo("v");
		GrafoNo w = new GrafoNo("w");
		GrafoNo x = new GrafoNo("x");
		GrafoNo y = new GrafoNo("y");
		GrafoNo z = new GrafoNo("z");
		GrafoNo a1 = new GrafoNo("a1");
		GrafoNo a2 = new GrafoNo("a2");
		GrafoNo a3 = new GrafoNo("a3");
		GrafoNo a4 = new GrafoNo("a4");
		GrafoNo a5 = new GrafoNo("a5");
		
		v.adicionaNoAdjacente(p);
		w.adicionaNoAdjacente(y);
		w.adicionaNoAdjacente(v);
		w.adicionaNoAdjacente(a5);
		x.adicionaNoAdjacente(y);
		x.adicionaNoAdjacente(a4);
		z.adicionaNoAdjacente(a1);
		z.adicionaNoAdjacente(a);
		z.adicionaNoAdjacente(p);
		a2.adicionaNoAdjacente(a3);
		a2.adicionaNoAdjacente(a4);
		a2.adicionaNoAdjacente(a5);		
		
		nos.add(v);
		nos.add(w);
		nos.add(x);
		nos.add(y);
		nos.add(z);
		nos.add(a1);
		nos.add(a2);
		nos.add(a3);
		nos.add(a4);
		nos.add(a5);
		return nos;
	}
	
	public GrafoNo buscaLargura4Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples4Nos();
        
		GrafoNo a = nos.get(0);
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}
	
	public GrafoNo buscaLargura5Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples4Nos();
        
		GrafoNo a = nos.get(0);
        GrafoNo e = new GrafoNo("e");
        e.adicionaNoAdjacente(nos.get(3));
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}
	
	public GrafoNo buscaLargura6Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples4Nos();
        
		GrafoNo a = nos.get(0);
        GrafoNo e = new GrafoNo("e");
        GrafoNo f = new GrafoNo("f");
        
        e.adicionaNoAdjacente(nos.get(3));
        f.adicionaNoAdjacente(nos.get(2));
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}
	
	public GrafoNo buscaLargura7Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples7Nos();
        
		GrafoNo a = nos.get(0);
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}
	
	public GrafoNo buscaLargura8Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples7Nos();
        
		GrafoNo a = nos.get(0);
        GrafoNo i = new GrafoNo("i");
        i.adicionaNoAdjacente(nos.get(1));
        i.adicionaNoAdjacente(nos.get(6));
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}
	
	public GrafoNo buscaLargura10Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples7Nos();
        
		GrafoNo a = nos.get(0);
        GrafoNo i = new GrafoNo("i");
        GrafoNo j = new GrafoNo("j");
        GrafoNo k = new GrafoNo("k");
        i.adicionaNoAdjacente(nos.get(1));
        i.adicionaNoAdjacente(nos.get(6));
        j.adicionaNoAdjacente(nos.get(3));
        k.adicionaNoAdjacente(j);
        k.adicionaNoAdjacente(nos.get(6));
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}
	
	public GrafoNo buscaLargura15Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples7Nos();
        
		GrafoNo a = nos.get(0);
        GrafoNo i = new GrafoNo("i");
        GrafoNo j = new GrafoNo("j");
        GrafoNo k = new GrafoNo("k");
        GrafoNo l = new GrafoNo("l");
        GrafoNo m = new GrafoNo("m");
        GrafoNo n = new GrafoNo("n");
        GrafoNo o = new GrafoNo("o");
        GrafoNo p = new GrafoNo("p");
        i.adicionaNoAdjacente(nos.get(1));
        i.adicionaNoAdjacente(nos.get(6));
        j.adicionaNoAdjacente(nos.get(3));
        k.adicionaNoAdjacente(j);
        l.adicionaNoAdjacente(k);
        m.adicionaNoAdjacente(l);
        m.adicionaNoAdjacente(nos.get(2));
        o.adicionaNoAdjacente(n);
        p.adicionaNoAdjacente(n);
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}
	
	public GrafoNo buscaLargura20Nos() throws ColoreGrafoException {
		GrafoNo a = this.grafoSimples20Nos().get(0); 
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}
	
	public GrafoNo buscaLargura30Nos() throws ColoreGrafoException {
		GrafoNo a = this.grafoSimples30Nos().get(0);
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}
	
	public GrafoNo buscaLargura40Nos() throws ColoreGrafoException {
		LinkedList<GrafoNo> nos = (LinkedList<GrafoNo>) this.grafoSimples30Nos();
		GrafoNo a = nos.get(0);
		
        GrafoNo a6 = new GrafoNo("a6");
        GrafoNo a7 = new GrafoNo("a7");
        GrafoNo a8 = new GrafoNo("a8");
        GrafoNo a9 = new GrafoNo("a9");
        GrafoNo b1 = new GrafoNo("b1");
        GrafoNo b2 = new GrafoNo("b2");
        GrafoNo b3 = new GrafoNo("b3");
        GrafoNo b4 = new GrafoNo("b4");
        GrafoNo b5 = new GrafoNo("b5");
        GrafoNo b6 = new GrafoNo("b6");
        
        a6.adicionaNoAdjacente(nos.get(4));
        a6.adicionaNoAdjacente(nos.get(3));
        a6.adicionaNoAdjacente(nos.get(6));
        a6.adicionaNoAdjacente(nos.get(14));
        a7.adicionaNoAdjacente(nos.get(13));
        a7.adicionaNoAdjacente(nos.get(20));
        a7.adicionaNoAdjacente(nos.get(24));
        a7.adicionaNoAdjacente(nos.get(27));
        a8.adicionaNoAdjacente(b3);
        a8.adicionaNoAdjacente(a7);
        a8.adicionaNoAdjacente(b5);
        a8.adicionaNoAdjacente(nos.get(19));
        a9.adicionaNoAdjacente(nos.get(9));
        a9.adicionaNoAdjacente(nos.get(17));
        a9.adicionaNoAdjacente(b3);
        b1.adicionaNoAdjacente(nos.get(3));
        b1.adicionaNoAdjacente(nos.get(8));
        b1.adicionaNoAdjacente(nos.get(9));
        b1.adicionaNoAdjacente(a9);
        b2.adicionaNoAdjacente(b5);
        b2.adicionaNoAdjacente(b6);
        b2.adicionaNoAdjacente(b4);
        b2.adicionaNoAdjacente(a6);
        b2.adicionaNoAdjacente(nos.get(5));
        b2.adicionaNoAdjacente(nos.get(4));
        b2.adicionaNoAdjacente(nos.get(25));
        b3.adicionaNoAdjacente(nos.get(25));
        b3.adicionaNoAdjacente(nos.get(22));
        b3.adicionaNoAdjacente(nos.get(21));
        b4.adicionaNoAdjacente(nos.get(10));
        b5.adicionaNoAdjacente(nos.get(17));
        b6.adicionaNoAdjacente(nos.get(10));
        b6.adicionaNoAdjacente(nos.get(4));
        b6.adicionaNoAdjacente(nos.get(18));
        b6.adicionaNoAdjacente(nos.get(27));
        
        ColoreGrafoBuscaEmLargura grafo = new ColoreGrafoBuscaEmLargura();
        grafo.colore(a);
        return a;
	}	
	
}
