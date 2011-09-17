package main;

import core.ColoreGrafo;
import core.ColoreGrafoBuscaEmLargura;
import core.GrafoNo;
import exceptions.ColoreGrafoException;

public class Main {
	
    public static void main(String[] args) {

    	GrafoNo noInicial;
        noInicial = CarregaArquivoGrafo.geraGrafoDoArquivo("C:/Users/shiga/Desktop/grafo.txt");

        try {
        	ColoreGrafo coloreGrafo = new ColoreGrafoBuscaEmLargura();
        	coloreGrafo.colore(noInicial);
        } catch(ColoreGrafoException e) {
        	System.out.println("FATAL ERROR: " + e.getMessage());
        }
 
    }

}
