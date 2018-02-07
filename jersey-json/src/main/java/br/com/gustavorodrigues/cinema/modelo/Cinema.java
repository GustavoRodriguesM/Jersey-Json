package br.com.gustavorodrigues.cinema.modelo;

import com.google.gson.Gson;

public class Cinema {

	private long id;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	
	public Cinema(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

}
