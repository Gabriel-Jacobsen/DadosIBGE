package leitura;

import com.google.gson.annotations.SerializedName;

public class ListaPopulacao {
    @SerializedName("D1N")
    private String municipio;

    @SerializedName("D3N")
    private String ano;

    @SerializedName("V")
    private String valor;

    public String getMunicipio() { return municipio; }
    public String getAno() { return ano; }
    public String getValor() { return valor; }
}
