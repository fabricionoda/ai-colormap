package core;

import java.util.LinkedList;
import exceptions.ReferenciaCiclicaException;

//RELACIONAMENTO E DADOS DO GRAFO
public class GrafoNo {

    private CoresEnum cor; // RGB
    private LinkedList<GrafoNo> nosAdjacentes;
    private String nome;
    
    public GrafoNo(String nomeDoGrafo) {
        this.nosAdjacentes = new LinkedList<GrafoNo>();
        this.cor = CoresEnum.WHITE;
        this.nome = nomeDoGrafo;
    }
    
    public String getNome() {
    	return nome;
    }

    public CoresEnum getCor() {
        return this.cor;
    }

    public void setCor(CoresEnum cor) {
        this.cor = cor;
    }

    public LinkedList<GrafoNo> getNosAdjacentes() {
        return this.nosAdjacentes;
    }

    public void adicionaNoAdjacente(GrafoNo no) throws ReferenciaCiclicaException {
    	if(no.equals(this)) {
    		throw new ReferenciaCiclicaException("Não pode ter relacionamento cíclico nos nós");
    	}
    	
    	if (! this.nosAdjacentes.contains(no)) {
    		this.nosAdjacentes.addLast(no);
    		no.nosAdjacentes.addLast(this);
    	}	
    }

    public GrafoNo getNoAdjacente(int indice) {
        return this.nosAdjacentes.get(indice);
    }

    public int getQuantidadeNosAdjacentes() {
        return this.nosAdjacentes.size();
    }



}
