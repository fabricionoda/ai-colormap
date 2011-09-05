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

        noInicial = new GrafoNo();
        noInicial.setCor(coresEnum.RED);

        fila.add(noInicial);

        GrafoNo no = noInicial;

        for ( int i = 0; i< no.getQuantidadeNosAdjacentes(); i++ ) {
            if ( ! fila.contains(no.getNosAdjacentes().get(i))) {
                fila.add(no.getNosAdjacentes().get(i));

                
            }
        }
    }

}
