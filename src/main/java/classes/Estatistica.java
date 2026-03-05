package classes;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlRootElement;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Estatistica {

	private double mediaPop, medianaPop, modaPop, varianciaPop, desvPop;
	private double mediaPib, medianaPib, modaPib, varianciaPib, desvPib;
	
	public Estatistica() {
		
	}
	
	public double getMediaPop() {
		return mediaPop;
	}
	public void setMediaPop(List<Double> valores) {
		this.mediaPop = valores.stream()
	            		.mapToDouble(Double::doubleValue)
	            		.average()
	            		.orElse(0);
	}
	public double getMedianaPop() {
		return medianaPop;
	}
	public void setMedianaPop(List<Double> valores) {
	    List<Double> ordenado = valores.stream()
	            .sorted()
	            .toList();

	    int n = ordenado.size();

	    if (n % 2 == 0)
	    	this.medianaPop = (ordenado.get(n/2 - 1) + ordenado.get(n/2)) / 2.0;
	    else
	    	this.medianaPop = ordenado.get(n/2);
	}
	public double getModaPop() {
		return modaPop;
	}
	public void setModaPop(List<Double> valores) {
	    Map<Double, Integer> freq = new HashMap<>();

	    for (double v : valores)
	        freq.put(v, freq.getOrDefault(v, 0) + 1);

	    this.modaPop = Collections.max(freq.entrySet(),
	            Map.Entry.comparingByValue()).getKey();
	}
	public double getVarianciaPop() {
		return varianciaPop;
	}
	public void setVarianciaPop(List<Double> valores) {
		double media = mediaPop;

		this.varianciaPop =  valores.stream()
	            .mapToDouble(v -> Math.pow(v - media, 2))
	            .average()
	            .orElse(0);
	}
	public double getDesvPop() {
		return desvPop;
	}
	public void setDesvPop() {
		this.desvPop = Math.sqrt(varianciaPop);
	}
	public double getMediaPib() {
		return mediaPib;
	}
	public void setMediaPib(List<Double> valores) {
		this.mediaPib = valores.stream()
        				.mapToDouble(Double::doubleValue)
        				.average()
        				.orElse(0);
	}
	public double getMedianaPib() {
		return medianaPib;
	}
	public void setMedianaPib(List<Double> valores) {
	    List<Double> ordenado = valores.stream()
	            .sorted()
	            .toList();

	    int n = ordenado.size();

	    if (n % 2 == 0)
	    	this.medianaPib = (ordenado.get(n/2 - 1) + ordenado.get(n/2)) / 2.0;
	    else
	    	this.medianaPib = ordenado.get(n/2);
	}
	public double getModaPib() {
		return modaPib;
	}
	public void setModaPib(List<Double> valores) {
	    Map<Double, Integer> freq = new HashMap<>();

	    for (double v : valores)
	        freq.put(v, freq.getOrDefault(v, 0) + 1);

	    this.modaPib = Collections.max(freq.entrySet(),
	            Map.Entry.comparingByValue()).getKey();
	}
	public double getVarianciaPib() {
		return varianciaPib;
	}
	public void setVarianciaPib(List<Double> valores) {
		double media = mediaPib;

		this.varianciaPib =  valores.stream()
	            .mapToDouble(v -> Math.pow(v - media, 2))
	            .average()
	            .orElse(0);
	}
	public double getDesvPib() {
		return desvPib;
	}
	public void setDesvPib() {
		this.desvPib = Math.sqrt(varianciaPib);
	}
	
	
}
