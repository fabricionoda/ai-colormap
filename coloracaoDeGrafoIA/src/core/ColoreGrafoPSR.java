package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import exceptions.ImpossivelColorirException;
import exceptions.ReferenciaCiclicaException;

public class ColoreGrafoPSR extends ColoreGrafo {
	
	class NosPorQuantidadeAdjacentes {
		
		private Integer quantidade;
		private GrafoNo no;
		
		public NosPorQuantidadeAdjacentes(GrafoNo no, Integer quantidade) {
			this.quantidade = quantidade;
			this.no = no;
		}
			
	}	

	private LinkedList<GrafoNo> nos = new LinkedList<GrafoNo>();
	private LinkedList<CoresEnum> cores = new LinkedList<CoresEnum>();
	private LinkedList<String> restricoes = new LinkedList<String>();
	private LinkedList<GrafoNo> nosVisitados = new LinkedList<GrafoNo>();

	private GrafoNo procuraNo(String nomeNo) {
		for (GrafoNo no : this.nos) {
			if (no.getNome().equals(nomeNo)) {
				return no;
			}
		}
		return null;
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
		
		List indices = new ArrayList();
		List elementos = new ArrayList(); 
		
		
		// INT na key da zica
		for (GrafoNo no : this.nos) {
			indices.add(no.getQuantidadeNosAdjacentes());
			elementos.add(no);
		}
		
		return retorno;
	}
	
	public void colore() throws ImpossivelColorirException {
		this.nosVisitados.clear();
		this.percorreGrafoApartirDe(null);
	}		
	
	@Override
	protected void percorreGrafoApartirDe(GrafoNo noInicial)
			throws ImpossivelColorirException {
		
		LinkedList<GrafoNo> nosRestritivos = this.nosMaisRestritivos();
		for (GrafoNo no : nosRestritivos) {
			nosVisitados.add(no);	
			processaNo(no);
		}
	}

	@Override
	protected void naoFoiPossivelColorir() throws ImpossivelColorirException {
		// imprementassao do backtracking
		
		
	}

}
