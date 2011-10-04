package main;

import static main.ColoreGrafosController.getController;

import java.io.IOException;
import java.util.Scanner;

import exceptions.ColoreGrafoException;

public class Main {
	
	private static void mostraApresentacao() {
		System.out.println("Tabalho de Introducao a Inteligencia Artificial");
		System.out.println("Professor: Mauro");
		System.out.println("Alunos:");
		System.out.println("  Fabricio Noda RA ");
		System.out.println("  Henrique S. Yoshio RA ");
		System.out.println("  Luiz Guilherme S. Anjos RA 45220");
		System.out.println("  Marcelo T. Tsunematsu RA");
		System.out.println(" ");
		System.out.println(" ");		
	}
	
	private static void mostraGrafosBuscaEmLargura() throws IOException, ColoreGrafoException {

		String opcaoGrafo = "s";
		
		do {
			System.out.println("Selecione um dos grafos a seguir: ");
			System.out.println(" 1 - Grafo 4 nós");
			System.out.println(" 2 - Grafo 5 nós");
			System.out.println(" 3 - Grafo 6 nós");
			System.out.println(" 4 - Grafo 7 nós");
			System.out.println(" 5 - Grafo 8 nós");
			System.out.println(" 6 - Grafo 10 nós");
			System.out.println(" 7 - Grafo 15 nós");
			System.out.println(" 8 - Grafo 20 nós");
			System.out.println(" 9 - Grafo 30 nós");
			System.out.println(" 0 - Grafo 40 nós");
			System.out.println(" s - Sair");
			
			System.out.println(" -> ");			
			Scanner in = new Scanner(System.in);
			opcaoGrafo = in.next();
			switch (opcaoGrafo.charAt(0)) {
				case '1': getController().buscaLargura4Nos(); break;
				case '2': getController().buscaLargura5Nos(); break;
				case '3': getController().buscaLargura6Nos(); break;
				case '4': getController().buscaLargura7Nos(); break;
				case '5': getController().buscaLargura8Nos(); break;
				case '6': getController().buscaLargura10Nos(); break;
				case '7': getController().buscaLargura15Nos(); break;
				case '8': getController().buscaLargura20Nos(); break;
				case '9': getController().buscaLargura30Nos(); break;
				case '0': getController().buscaLargura40Nos(); break;
			}
		} while( opcaoGrafo.charAt(0) != 's' );		
	}
	
	private static void mostraGrafosPsr() throws IOException, ColoreGrafoException {
		
		char opcaoGrafo = '1';
		do {
			System.out.println("Selecione uma dos grafos abaixo: ");
			System.out.println(" 1 - Grafo 4 nós");
			System.out.println(" 2 - Grafo 5 nós");
			System.out.println(" 3 - Grafo 6 nós");
			System.out.println(" 4 - Grafo 7 nós");
			System.out.println(" 5 - Grafo 8 nós");
			System.out.println(" 6 - Grafo 10 nós");
			System.out.println(" 7 - Grafo 15 nós");
			System.out.println(" 8 - Grafo 20 nós");
			System.out.println(" 9 - Grafo 30 nós");
			System.out.println(" 0 - Grafo 40 nós");
			System.out.println(" s - Sair");
			
			opcaoGrafo = (char) System.in.read();
			switch (opcaoGrafo) {
			case 1: ColoreGrafosController.getInstancia().buscaLargura4Nos();
					break;

			}

		} while( opcaoGrafo != 's' );
		
	}	
		
	private static void mostraMenu() throws IOException, Exception {
		
		char opcao = 's';
    	do {
    		System.out.println("Selecione uma das opcoes abaixo: ");
    		System.out.println(" 1 - Coloracao de mapa com busca em largura");
    		System.out.println(" 2 - Coloracao de mapa utilizando PSR");
    		System.out.println(" s - Sair");
			opcao = (char) System.in.read();				
			switch (opcao) {
				case '1': mostraGrafosBuscaEmLargura();	break;
				case '2': mostraGrafosPsr(); break;
			}
    	} while (opcao != 's');	
		
	}
	
    public static void main(String[] args) {
    	
    	mostraApresentacao();
        try {    	
        	mostraMenu();
        } catch (IOException e) { 
			System.out.println("Erro de leitura, tente novamente.");
		} catch(Exception e) {
        	System.out.println("ERROR: " + e.getClass().getName() + ", " + e.getMessage());
        } 
 
    }

}
