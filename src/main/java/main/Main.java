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
			+ "|4: Pegar Dados de outro ano              |\n"
			+ "===========================================",
		t3 = "============================================\n"
			+ "|Qual operação deseja fazer?              |\n"
			+ "|1: Salvar JSON.                          |\n"
			+ "|2: Salvar XML.                           |\n"
			+ "===========================================",
		t4 = "============================================\n"
		   + "|Valor inválido! Tente novamente           |\n"
		   + "============================================"
			;
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		Controle controle = new Controle();
		
		while (true) {
		System.out.println(t1);
		try {
			String str = scanner.nextLine();
			Integer.parseInt(str);
			controle.getDados(str);
			break;
		} catch (NumberFormatException e) {
			System.out.println(t4);
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
		    		if (resposta2.equals("1")) {
		    			controle.salvarJson();
		    		} else if (resposta2.equals("2")){
		    			controle.salvarXML();
		    		} else {System.out.println(t4);}
		    	break;
		    case "3": 
		    	System.out.println(t3);
		    	String resposta3 = scanner.nextLine();
		    		if (resposta3.equals("1")) {
		    			controle.salvarEstatisticaJson();
		    		} else if (resposta3.equals("2")){
		    			controle.salvarEstatisticaXML();
		    		} else {System.out.println(t4);}
		    	break;
		    case "4": 
				while (true) {
					System.out.println(t1);
					try {
						String str = scanner.nextLine();
						Integer.parseInt(str);
						controle.getDados(str);
						break;
					} catch (NumberFormatException e) {
						System.out.println(t4);
					}
					}
		    	break;
		    default: System.out.println(t4); break;
			}
		}
	}
	
}
