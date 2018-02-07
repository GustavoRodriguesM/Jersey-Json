package br.com.gustavorodrigues.cinema.modelo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Sala {

	private long id;
	private int numeroAssentos;
	private List<Ingresso> ingressos = new ArrayList<>();
	private Cinema cinema;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumeroAssentos() {
		return numeroAssentos;
	}

	public void setNumeroAssentos(int numeroAssentos) {
		this.numeroAssentos = numeroAssentos;
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void adiciona(Ingresso ingresso) {
		this.ingressos.add(ingresso);
	}

	public Sala(long id, int numeroAssentos) {
		this.id = id;
		this.numeroAssentos = numeroAssentos;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

	public void remove(Long ingressoId) {
		this.ingressos.remove(ingressoId.intValue() -1);
	}

	public void troca(Ingresso ingresso) {
		remove(ingresso.getId());
		adiciona(ingresso);
	}

}
