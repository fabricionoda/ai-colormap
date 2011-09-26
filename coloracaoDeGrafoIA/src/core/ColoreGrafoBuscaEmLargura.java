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

	public void colore(GrafoNo noInicial) throws ImpossivelColorirException {
		
		this.percorreGrafoApartirDe(noInicial);
	}

	@Override
	protected void naoFoiPossivelColorir() throws ImpossivelColorirException {
		throw new ImpossivelColorirException("Não é possível colorir o grafo.");
		
	}	
}
