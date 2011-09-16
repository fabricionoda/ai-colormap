package coloracaodegrafoia;

import java.util.LinkedList;

public class ColoreGrafo {
	
	private static LinkedList<coresEnum> cores = new LinkedList<coresEnum>();
	
	private coresEnum getNextColor() {
		coresEnum cor;
		cor = cores.removeFirst();
		cores.add(cor);
		return cor;
	}
    
    public void carregaArquivo(String caminho) {
        LinkedList<String> buffer = CarregaArquivo.leArquivo(caminho);

        System.out.println("Carregando arquivo: ");
        int i = 0;
        while ( i < buffer.size()) {
            System.out.println("linha " + buffer.get(i));
            System.out.println("nomeNo " + CarregaArquivo.getNomeNo(buffer.get(i)));
            System.out.println("adj " + CarregaArquivo.getNosAdjacentes(buffer.get(i)));
            i++;
        }           
    }
    
    public void colore(GrafoNo noInicial) {
        LinkedList<GrafoNo> fila = new LinkedList<GrafoNo>();
        LinkedList<GrafoNo> visitados = new LinkedList<GrafoNo>();

        GrafoNo no;
        GrafoNo noAdjacente;
        coresEnum cor; 
        
        fila.add(noInicial);
        visitados.add(noInicial);
        //noInicial.setCor(coresEnum.RED);
        
        while (fila.size() > 0 ) {
            
            no = fila.removeFirst();           
            for ( int i = 0; i< no.getQuantidadeNosAdjacentes(); i++ ) {
                noAdjacente = no.getNosAdjacentes().get(i);
                
                if ( ! visitados.contains(noAdjacente) ) {
                    visitados.add(noAdjacente);
                    fila.add(noAdjacente);
                    
                    cor = this.getNextColor(); // RED
                    
                }
            }

            boolean corIgual = false;
            while ( true ) {
                cor = getNextColor(); // RED
                int i = 0;
                while (! corIgual ) {
                    noAdjacente = no.getNosAdjacentes().get(i);
                    corIgual = (noAdjacente.getCor().equals(cor));
                    i++;
                }
            }     
        }    
    }

}
