package core;

import exceptions.ImpossivelColorirException;

public abstract class ColoreGrafo {
	
	protected CoresEnum getProximaCor() {
		return ColoreGrafoHelper.getInstancia().getProximaCor();
	}
	
	protected abstract void percorreGrafoApartirDe(GrafoNo noInicial) throws ImpossivelColorirException;
	
	protected abstract void naoFoiPossivelColorir() throws ImpossivelColorirException;
	
	
	protected void processaNo(GrafoNo noProcessado) throws ImpossivelColorirException {
		
		CoresEnum cor = CoresEnum.WHITE;
		boolean corDiferenteDosAdjacentes = false;
		GrafoNo noAdjacente;
		int tentativas = 0;
		int maxTentativas = ColoreGrafoHelper.getInstancia().getQuantidadeDeCores();
		
		while (! corDiferenteDosAdjacentes) {
			
			do {
				cor = this.getProximaCor();
			} while (noProcessado.getCor().equals(cor));
			
			Log.show("  " + noProcessado.getNome() + " -> " + cor);			
			corDiferenteDosAdjacentes = true;
			
			for ( int i = 0; i < noProcessado.getQuantidadeNosAdjacentes(); i++ ) {
				noAdjacente = noProcessado.getNosAdjacentes().get(i);
			
				if (noAdjacente.getCor().equals(cor)) {
					corDiferenteDosAdjacentes = false;
				}
			}
						
			if (tentativas > maxTentativas) {
				this.naoFoiPossivelColorir();
			}
			
			tentativas ++;			
		}
		
		noProcessado.setCor(cor);
	}
	
}
