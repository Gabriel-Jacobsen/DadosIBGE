package leitura;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

import java.util.*;

import classes.Municipio;

public class Leitor {
	
	private static String lerDadosPib(String ano) throws Exception{
		 HttpClient client = HttpClient.newHttpClient();

	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create("https://apisidra.ibge.gov.br/values/t/5938/n6/all/v/37/p/"+ano))
	                .GET()
	                .build();

	        HttpResponse<String> response =
	                client.send(request, HttpResponse.BodyHandlers.ofString());
		
		//System.out.println(response.body());
		
		return response.body();
	}
	
	private static String lerDadosPopulacao(String ano) throws Exception{
		 HttpClient client = HttpClient.newHttpClient();

	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create("https://apisidra.ibge.gov.br/values/t/6579/n6/all/v/9324/p/"+ano))
	                .GET()
	                .build();

	        HttpResponse<String> response =
	                client.send(request, HttpResponse.BodyHandlers.ofString());
		
	     //System.out.println(response.body());
	        
		return response.body();
	}

	public static Map<String, Municipio> Ler(String ano) throws Exception {
		Map<String, Municipio> mapa = new HashMap<>();
		
		Gson gson = new Gson();

		Type tipoLista = new TypeToken<List<ListaPib>>(){}.getType();
		List<ListaPib> listaPib = gson.fromJson(lerDadosPib(ano), tipoLista);
		
		tipoLista = new TypeToken<List<ListaPopulacao>>(){}.getType();
		List<ListaPopulacao> listaPop = gson.fromJson(lerDadosPopulacao(ano), tipoLista);
		
		listaPop.remove(0); //retira cabeçalho
		listaPib.remove(0);
		
		for (ListaPopulacao linha : listaPop) { //popula mapa com população
			try {
		    String chave = linha.getMunicipio() + "-" + linha.getAno();

		    Municipio m = new Municipio(linha.getMunicipio(), Integer.parseInt(linha.getAno()));
		    
		    m.setPopulacao(Long.parseLong(linha.getValor()));
		    mapa.put(chave, m);
			}  catch (Exception name) {
				
			} 
		}
		
		for (ListaPib linha : listaPib) { //adiciona o pib
			try {
		    String chave = linha.getMunicipio() + "-" + linha.getAno();

		    Municipio m = mapa.get(chave);

		    if (m != null) {
		        m.setPib(Long.parseLong(linha.getValor()));
		    }
			}  catch (Exception name) {
				
			} 
		}
		
		return mapa;
	}
	
}
