package core;

import exceptions.ImpossivelColorirException;

public abstract class ColoreGrafo {
	
	protected CoresEnum getProximaCor() {
		return ColoreGrafoHelper.getInstancia().getProximaCor();
	}
	
	protected abstract void percorreGrafoApartirDe(GrafoNo noInicial) throws ImpossivelColorirException;

	protected abstract void processaNo(GrafoNo noProcessado) throws ImpossivelColorirException;
	
	public void colore(GrafoNo noInicial) throws ImpossivelColorirException {
		
		this.percorreGrafoApartirDe(noInicial);
	}

}
