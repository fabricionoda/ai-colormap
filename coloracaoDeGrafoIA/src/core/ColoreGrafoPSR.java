package core;

import java.util.LinkedList;
import exceptions.ImpossivelColorirException;
import exceptions.ReferenciaCiclicaException;

public class ColoreGrafoPSR extends ColoreGrafo {

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
		return this.nos;
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
		return this.nos;
	}
	
	public void colore() throws ImpossivelColorirException {
		nosVisitados.clear();
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
