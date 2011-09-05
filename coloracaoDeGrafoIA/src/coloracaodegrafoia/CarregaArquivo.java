package coloracaodegrafoia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CarregaArquivo {

   static public LinkedList<String> leArquivo(String caminhoDoArquivo) {
    try {
        LinkedList<String> listaNo = new LinkedList<String>();
        BufferedReader in = new BufferedReader(new FileReader(caminhoDoArquivo));
        String str = "";

        while (in.ready()) {
            str = in.readLine();
            listaNo.add(str) ;
        }
        in.close();
        return listaNo;
    } catch (IOException e) {
    }
    return null;

   }

   static public String getNosAdjacentes (String nomeNoAdjacente) {
        return nomeNoAdjacente.substring(nomeNoAdjacente.indexOf("=") + 1 ,nomeNoAdjacente.indexOf(";") );
   }

   static public String getNomeNo (String nomeNoAdjacente) {
        return nomeNoAdjacente.substring(0 ,nomeNoAdjacente.indexOf("=") );
   }

}