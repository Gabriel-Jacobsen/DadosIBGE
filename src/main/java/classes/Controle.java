package classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Permanencia.SalvarJSON;
import Permanencia.SalvarXML;
import leitura.Leitor;

public class Controle {
	private Map<String, Municipio> mapa = new HashMap<>();
	private SalvarJSON salvJson = new SalvarJSON();
	private SalvarXML salvXml = new SalvarXML();
	private Estatistica estat = new Estatistica();
	
	public boolean getDados(String ano) throws Exception{
		Map<String, Municipio> map = Leitor.Ler(ano);
		mapa.putAll(map);
		return true;
	}

	public boolean salvarJson() {
		List<Municipio> lista =  mapa.values().stream().toList();
		  salvJson.salvarComoJson(lista, "Dados.json");
		return true;
	}
	
	public boolean salvarXML() {
		List<Municipio> lista = mapa.values().stream().toList();
		Municipio wrapper = new Municipio(lista);
		SalvarXML.salvarComoXml(wrapper, "Dados.xml");
		return true;
	}
	
	public boolean gerarEstatisticas() {
		estat.setMediaPop(mapa.values().stream().map(m -> (double) m.getPopulacao()).toList());
		estat.setMedianaPop(mapa.values().stream().map(m -> (double) m.getPopulacao()).toList());
		estat.setModaPop(mapa.values().stream().map(m -> (double) m.getPopulacao()).toList());
		estat.setVarianciaPop(mapa.values().stream().map(m -> (double) m.getPopulacao()).toList());
		estat.setDesvPop();
		estat.setMediaPib(mapa.values().stream().map(m -> (double) m.getPib()).toList());
		estat.setMedianaPib(mapa.values().stream().map(m -> (double) m.getPib()).toList());
		estat.setModaPib(mapa.values().stream().map(m -> (double) m.getPib()).toList());
		estat.setVarianciaPib(mapa.values().stream().map(m -> (double) m.getPib()).toList());
		estat.setDesvPib();
		return true;
	}
	
	public String getEstatisticas() {
		return "POPULAÇÃO: \n"
			 + "Media: "+ estat.getMediaPop()+"\n"
			 + "Mediana:"+ estat.getMedianaPop()+"\n"
			 + "Moda:"+ estat.getModaPop()+"\n"
			 + "Variancia: "+ estat.getVarianciaPop()+"\n"
			 + "Desvio Padrão: "+ estat.getDesvPop()+"\n"
			 + "PIB: \n"
			 + "Media: "+ estat.getMediaPib()+"\n"
			 + "Mediana:"+ estat.getMedianaPib()+"\n"
			 + "Moda:"+ estat.getModaPib()+"\n"
			 + "Variancia: "+ estat.getVarianciaPib()+"\n"
			 + "Desvio Padrão: "+ estat.getDesvPib();
				
	}
	
	public boolean salvarEstatisticaJson() {
		  salvJson.salvarComoJson(estat, "Estatistica.json");
		return true;
	}
	
	public boolean salvarEstatisticaXML() {
		SalvarXML.salvarComoXml(estat, "Estatistica.xml");
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Controle [mapa=");
		builder.append(mapa.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
