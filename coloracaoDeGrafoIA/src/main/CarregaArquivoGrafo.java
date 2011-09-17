package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import core.GrafoNo;

public class CarregaArquivoGrafo {

   static private LinkedList<String> leArquivo(String caminhoDoArquivo) {
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
   
   static private String getNosAdjacentes (String nomeNoAdjacente) {
       return nomeNoAdjacente.substring(nomeNoAdjacente.indexOf("=") + 1 ,nomeNoAdjacente.indexOf(";") );
  }

   static private String getNomeNo (String nomeNoAdjacente) {
       return nomeNoAdjacente.substring(0 ,nomeNoAdjacente.indexOf("=") );
   }   
   
   static public GrafoNo geraGrafoDoArquivo(String caminho) {
	   
	   CarregaArquivoGrafo.carregaArquivo(caminho);
	   // TODO: implementar criacao do grafo apartir do arquivo lido
	   return null;
   }
   
   static private void carregaArquivo(String caminho) {	   
       LinkedList<String> buffer = CarregaArquivoGrafo.leArquivo(caminho);

       System.out.println("Carregando arquivo: ");
       int i = 0;
       while ( i < buffer.size()) {
           System.out.println("linha " + buffer.get(i));
           System.out.println("nomeNo " + CarregaArquivoGrafo.getNomeNo(buffer.get(i)));
           System.out.println("adj " + CarregaArquivoGrafo.getNosAdjacentes(buffer.get(i)));
           i++;
       }
   }   

}