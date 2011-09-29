package core;

import java.util.LinkedList;
import java.util.TreeMap;

import exceptions.ImpossivelColorirBackTrackRequiredException;
import exceptions.ImpossivelColorirException;
import exceptions.ReferenciaCiclicaException;

public class ColoreGrafoPSR extends ColoreGrafo {
	
	private LinkedList<GrafoNo> nos = new LinkedList<GrafoNo>();
	private LinkedList<CoresEnum> cores = new LinkedList<CoresEnum>();
	private LinkedList<String> restricoes = new LinkedList<String>();
	private boolean heuristicaDeOrdenarPorRestricao = true;
	
	private GrafoNo procuraNo(String nomeNo) {
		for (GrafoNo no : this.nos) {
			if (no.getNome().equals(nomeNo)) {
				return no;
			}
		}
		return null;
	}
	
	public void ativarHeuristicaDeOrdenarPorRestricao() {
		this.heuristicaDeOrdenarPorRestricao = true;
	}
	
	public void desativarHeuristicaDeOrdenarPorRestricao() {
		this.heuristicaDeOrdenarPorRestricao = false;
	}	
	
	public void variaveis(String... nos) {
		for (String no : nos) {
			this.nos.add(new GrafoNo(no));
		}
	}
	
	public LinkedList<GrafoNo> getVariaveis() {
		return this.nosMaisRestritivos();
	}
	
	public void dominio(CoresEnum... cores) {
		for (CoresEnum cor : cores) {
			this.cores.add(cor);
		}
	}
	
	public LinkedList<String> getDominios() {
		return this.restricoes;
	}	
	
	public void novaRestricao(String no1, String no2) throws ReferenciaCiclicaException {
		this.restricoes.add(no1 + "!=" +  no2);
		
		GrafoNo graf1 = this.procuraNo(no1);
		GrafoNo graf2 = this.procuraNo(no2);
		
		if (graf1 == null || graf2 == null) {
			throw new RuntimeException("Nó informado não existe");
		}
		
		graf1.adicionaNoAdjacente(graf2);
		graf2.adicionaNoAdjacente(graf1);
	}
	
	private LinkedList<GrafoNo> nosMaisRestritivos() {
		LinkedList<GrafoNo> retorno = new LinkedList<GrafoNo>();
  	    TreeMap<GrafoNo,Integer> nosMaisRestritivos = new TreeMap<GrafoNo,Integer>();
  	    
		for (GrafoNo no : this.nos) {
			nosMaisRestritivos.put(no, no.getQuantidadeNosAdjacentes());
		}
		
		for (GrafoNo no : nosMaisRestritivos.descendingKeySet()) {
			retorno.add(no);
		}
		
		return retorno;
		
	}
	
	public void colore() throws ImpossivelColorirException {
		this.percorreGrafoApartirDe(null);
	}		
	
	private LinkedList<GrafoNo> getNosParaProcessar() {
		if (this.heuristicaDeOrdenarPorRestricao) {
			return this.nosMaisRestritivos();
		} else {
			return this.nos;
		}		
	}
	
	private boolean backtrackTentaNosAdjacentes(GrafoNo noParaProcessar) {
		int iAdjacente = 0;
		boolean adjacenteColorido = false;
		
		while (iAdjacente < noParaProcessar.getQuantidadeNosAdjacentes() && (! adjacenteColorido)) {
			GrafoNo noAdjacente = noParaProcessar.getNoAdjacente(iAdjacente);
			
			try { 
				this.processaNo(noAdjacente);
				adjacenteColorido = true;
			} catch (ImpossivelColorirException e) {				
				// nothing
			}
			
			iAdjacente ++;
		}
		
		return adjacenteColorido;
	}
	
	private void executaBackTrack(LinkedList<GrafoNo> nosParaProcessar, Integer indice)
			throws ImpossivelColorirException {
		
		GrafoNo noAtual = nosParaProcessar.get(indice);
		
		this.backtrackTentaNosAdjacentes(noAtual);
		
		

		
	}
	
	@Override
	protected void percorreGrafoApartirDe(GrafoNo noInicial) throws ImpossivelColorirException {
		
		LinkedList<GrafoNo> nosParaProcessar = this.getNosParaProcessar();
		
		int i = 0;
		while ( i < nosParaProcessar.size() ) {
			try {
				this.processaNo(nosParaProcessar.get(i));
				i++;
			} catch (ImpossivelColorirBackTrackRequiredException e) {
				this.executaBackTrack(nosParaProcessar, i);				
			}
		}
		
	}

	@Override
	protected void naoFoiPossivelColorir() throws ImpossivelColorirException {
		throw new ImpossivelColorirBackTrackRequiredException("BackTrack");
		
	}

}
