package br.com.gustavorodrigues.cinema.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.gustavorodrigues.cinema.modelo.Cinema;
import br.com.gustavorodrigues.cinema.modelo.Ingresso;
import br.com.gustavorodrigues.cinema.modelo.Sala;

public class SalaDAO {

	private static Map<Long, Sala> banco = new HashMap<Long, Sala>();
	private static AtomicLong contador = new AtomicLong(1);

	static {
		Sala sala = new Sala(contador.getAndIncrement(), 40);
		sala.adiciona(new Ingresso(1, "Gustavo Rodrigues", 15.00));
		sala.adiciona(new Ingresso(2, "Daniela Silva", 30.00));
		sala.adiciona(new Ingresso(3, "Antonio Silveira", 15.00));
		Cinema cinema = new Cinema(1,"Cinemark");
		sala.setCinema(cinema);
		banco.put(sala.getId(), sala);
	}

	public void adiciona(Sala sala) {
		sala.setId(contador.getAndIncrement());
		banco.put(sala.getId(), sala);
	}

	public Sala busca(long id) {
		return banco.get(id);
	}

	public void remove(long id) {
		banco.remove(id);
	}

}
