package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import core.GrafoNo;
import exceptions.ReferenciaCiclicaException;

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
   
   static public GrafoNo geraGrafoDoArquivo(String caminho) throws ReferenciaCiclicaException {
	   
	   Map<String, GrafoNo> nos = CarregaArquivoGrafo.carregaArquivo(caminho);
	   Iterator<GrafoNo> iterator = nos.values().iterator();
	   
	   if (iterator.hasNext())
		   return iterator.next();
	   else
		   return null;
   }
   
   static Map<String, GrafoNo> carregaArquivo(String caminho) throws ReferenciaCiclicaException {	   
       List<String> buffer = CarregaArquivoGrafo.leArquivo(caminho);
       Map<String, GrafoNo> nosCriados = new HashMap<String, GrafoNo>();
       
       int i = 0;
       
       String stringDeAdjacentes = null;
       String noAtual;
       while ( i < buffer.size()) {
           System.out.println("Linha do Arquivo: " + buffer.get(i));
           System.out.println("Vértice " + CarregaArquivoGrafo.getNomeNo(buffer.get(i)));
           System.out.println("Nós Adjacentes:  " + CarregaArquivoGrafo.getNosAdjacentes(buffer.get(i)));

           noAtual = CarregaArquivoGrafo.getNomeNo(buffer.get(i));
           if ( ! nosCriados.containsKey(noAtual)) {
        	   nosCriados.put(noAtual, new GrafoNo(noAtual));
           }
           
           stringDeAdjacentes = CarregaArquivoGrafo.getNosAdjacentes(buffer.get(i)).trim();           

            StringTokenizer tokens = new StringTokenizer(stringDeAdjacentes, ",");
            while (tokens.hasMoreElements()) {
                if ( ! nosCriados.containsKey(tokens.nextToken())) {
             	   nosCriados.put(tokens.nextToken(), new GrafoNo(tokens.nextToken()));
                }
                
                nosCriados.get(tokens.nextToken()).adicionaNoAdjacente(nosCriados.get(noAtual));
            }

            i++;

       }
       
       return nosCriados;
   }   

}