package classes;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Municipio {

    private List<Municipio> municipios;
	
	private String nome;
	private long pib;
	private long populacao;
	private int ano;
	
	// FUNÇÕES PARA XML
	public Municipio() {
	}
    public Municipio(List<Municipio> municipios) {
        this.municipios = municipios;
    }
    @XmlElement(name = "municipio")
    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
	//FIM FUNÇÕES XML
    
	public Municipio(String nome, int ano) {
		this.nome = nome;
		this.ano = ano;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPib() {
		return pib;
	}

	public void setPib(long d) {
		this.pib = d;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long pop) {
		this.populacao = pop;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Municipio [nome=");
		builder.append(nome);
		builder.append(", pib=");
		builder.append(pib);
		builder.append(", populacao=");
		builder.append(populacao);
		builder.append(", ano=");
		builder.append(ano);
		builder.append("]");
		return builder.toString();
	}
	
}
