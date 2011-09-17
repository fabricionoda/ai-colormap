package core;

import java.util.LinkedList;

public class ColoreGrafoHelper {
	
	private static ColoreGrafoHelper instancia;
	private LinkedList<CoresEnum> cores = new LinkedList<CoresEnum>();
	
	public static ColoreGrafoHelper getInstancia() {
		if (instancia == null) {
			instancia = new ColoreGrafoHelper();
			instancia.reset();
		}
		
		return instancia;
	}
	
	public void reset() {
		instancia.cores.clear();
		instancia.cores.add(CoresEnum.RED);
		instancia.cores.add(CoresEnum.GREEN);
		instancia.cores.add(CoresEnum.BLUE);		
	}

	public CoresEnum getProximaCor() {
		CoresEnum cor;
		cor = this.cores.removeFirst();
		this.cores.add(cor);
		return cor;
	}
	
	public int getQuantidadeDeCores() {
		return this.cores.size();
	}

}
