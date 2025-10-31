package com.exchange.conversor;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String opcao;

		do {
			System.out.println("#####################################");
			System.out.println("");
			System.out.println("Digite uma das opções a seguir: ");
        	System.out.println("1 - Dólar para Peso Argentino");
       		System.out.println("2 - Peso Argentino para Dólar");
       		System.out.println("3 - Dólar para Real Brasileiro");
        	System.out.println("4 - Real Brasileiro para Dólar");
			System.out.println("5 - Euro para Real Brasileiro");
			System.out.println("6 - Real Brasileiro para Euro");
        	System.out.println("7 - Sair");
			System.out.println("");
			System.out.println("#####################################");

			opcao = scanner.nextLine();
		
			Conversor.convertePorOpcao(opcao);

		} while (!opcao.equals("5"));

		scanner.close();
	}

}
