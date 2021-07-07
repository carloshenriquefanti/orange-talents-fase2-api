package br.com.zup.api.marvel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComicDetails {

    @JsonProperty("Price")
    private float price;
	
	@JsonProperty("CodigoMarvel")
    private String codigoMarvel;

    @JsonProperty("MesReferencia")
    private String mesReferencia;
    
    @JsonProperty("Descricao")
    private String descricao;

    public ComicDetails() {
    }

    public ComicDetails(String codigoMarvel, String mesReferencia, String descricao) {
        this.codigoMarvel = codigoMarvel;
        this.mesReferencia = mesReferencia;
        this.descricao = descricao;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(String valor) {
        this.price = price;
    }

    public String getCodigoMarvel() {
        return codigoMarvel;
    }

    public void setCodigoMarvel(String codigoMarvel) {
        this.codigoMarvel = codigoMarvel;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String Descricao) {
        this.descricao = Descricao;
    }
}
