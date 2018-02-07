package br.com.gustavorodrigues.cinema.modelo;

import com.google.gson.Gson;


public class Ingresso {

	private long id;
	private String nomeComprador;
	private Double valor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeComprador() {
		return nomeComprador;
	}

	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Ingresso(long id, String nomeComprador, Double valor) {
		this.id = id;
		this.nomeComprador = nomeComprador;
		this.valor = valor;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

}
