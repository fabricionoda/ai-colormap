package core;

import java.util.LinkedList;

import exceptions.ImpossivelColorirException;

public class ColoreGrafoBuscaEmLargura extends ColoreGrafo {

	@Override
	protected void percorreGrafoApartirDe(GrafoNo noInicial) throws ImpossivelColorirException {
        LinkedList<GrafoNo> fila = new LinkedList<GrafoNo>();
        LinkedList<GrafoNo> visitados = new LinkedList<GrafoNo>();

        GrafoNo no, noAdjacente;

        fila.add(noInicial);
        visitados.add(noInicial);

        while (fila.size() > 0 ) {

            no = fila.removeFirst();          
            for ( int i = 0; i< no.getQuantidadeNosAdjacentes(); i++ ) {
                noAdjacente = no.getNosAdjacentes().get(i);
                
                if ( ! visitados.contains(noAdjacente) ) {
                    visitados.add(noAdjacente);
                    fila.add(noAdjacente);
                }                
            }

            this.processaNo(no);
        }
        
	}

	@Override
	protected void processaNo(GrafoNo noProcessado) throws ImpossivelColorirException {
		
		CoresEnum cor = CoresEnum.WHITE;
		boolean corDiferenteDosAdjacentes = false;
		GrafoNo noAdjacente;
		int tentativas = 0;
		int maxTentativas = ColoreGrafoHelper.getInstancia().getQuantidadeDeCores();

		while (! corDiferenteDosAdjacentes) {
			corDiferenteDosAdjacentes = true;
			cor = this.getProximaCor();
			
			for ( int i = 0; i < noProcessado.getQuantidadeNosAdjacentes(); i++ ) {
				noAdjacente = noProcessado.getNosAdjacentes().get(i);
			
				if (noAdjacente.getCor().equals(cor)) {
					corDiferenteDosAdjacentes = false;
				}
			}
						
			if (tentativas > maxTentativas) {
				throw new ImpossivelColorirException("Não é possível colorir o grafo.");
			}
			
			tentativas ++;			
		}
		
		noProcessado.setCor(cor);
	}
}
