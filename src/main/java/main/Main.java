package main;

import java.util.Scanner;

import classes.Controle;

public class Main {	
	
	public static void main(String [] args)  throws Exception {
		String 
		t1 = "============================================\n"
			+ "|Digite o ano que deseja reitrar os dados:|\n"
			+ "===========================================",
		t2 = "============================================\n"
			+ "|Qual operação deseja fazer?              |\n"
			+ "|1: Gerar Estatisticas                    |\n"
			+ "|2: Salvar Registros                      |\n"
			+ "|3: Salvar Dados Estatisticos             |\n"
			+ "===========================================",
		t3 = "============================================\n"
			+ "|Qual operação deseja fazer?              |\n"
			+ "|1: Salvar JSON.                          |\n"
			+ "|2: Salvar XML.                           |\n"
			+ "==========================================="
			;
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		Controle controle = new Controle();
		
		while (true) {
		System.out.println(t1);
		try {
			controle.getDados(scanner.nextLine());
			break;
		} catch (NumberFormatException e) {
			System.out.println("Valor inválido! Tente novamente.");
		}
		}
		
		loop:
		while (true) {
			System.out.println(t2);
			switch (scanner.nextLine()) {
		    case "1": 
		    	controle.gerarEstatisticas();
		    	System.out.println(controle.getEstatisticas());
		    	break;
		    case "2":  
		    	System.out.println(t3);
		    	String resposta2 = scanner.nextLine();
		    		if (resposta2.equals("JSON")) {
		    			controle.salvarJson();
		    		} else if (resposta2.equals("XML")){
		    			controle.salvarXML();
		    		}
		    	break;
		    case "3": 
		    	System.out.println(t3);
		    	String resposta3 = scanner.nextLine();
		    		if (resposta3.equals("JSON")) {
		    			controle.salvarEstatisticaJson();
		    		} else if (resposta3.equals("XML")){
		    			controle.salvarEstatisticaXML();
		    		}
		    	break;
		    default: break loop;
			}
		}
	}
	
}
