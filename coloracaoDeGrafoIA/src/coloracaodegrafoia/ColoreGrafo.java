package coloracaodegrafoia;

import java.util.LinkedList;

public class ColoreGrafo {
    
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

        fila.add(noInicial);
        visitados.add(no);

        noInicial.setCor(red);
        GrafoNo no;
        GrafoNo noAdjacente;        
        while (fila.size() > 0 ) {
            
            no = fila.removeFirst();           
            for ( int i = 0; i< no.getQuantidadeNosAdjacentes(); i++ ) {
                noAdjacente = no.getNosAdjacentes(i);
                
                if ( ! visitados.contains(noAdjacente) ) {
                    visitados.add(noAdjacente);
                    fila.add(noAdjacente);
                    
                    cor = randomCor(); // RED
                    
                }
            }

            boolean corIgual = false;
            while ( true ) {
                cor = randomCor(); // RED
                i = 0;
                while (! corIgual) ) {
                    noAdjacente = no.getNosAdjacentes(i);
                    corIgual = (noAdjacente.getCor().equal(cor));
                    i++;
                }
            }     
        }    
    }

}
