package br.com.gustavorodrigues.cinema.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.gustavorodrigues.cinema.dao.SalaDAO;
import br.com.gustavorodrigues.cinema.modelo.Ingresso;
import br.com.gustavorodrigues.cinema.modelo.Sala;

@Path("salas")
public class SalaResource {

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("id") long id) {
		return new SalaDAO().busca(id).toJson();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adiciona(String json) {
		
		try {
			Sala sala = new Gson().fromJson(json, Sala.class);
			new SalaDAO().adiciona(sala);
			URI uri = URI.create("http://localhost:9090/salas/" + sala.getId());
			return Response.created(uri).build();
		}catch(Exception e) {
			return Response.serverError().build();
		}
	}
	
	@Path("{id}/ingressos/{ingressoId}")
	@DELETE
	public Response remove(@PathParam("id") long id, @PathParam("ingressoId") Long ingressoId) {
		Sala sala = new SalaDAO().busca(id);
		sala.remove(ingressoId);
		return Response.ok().build();
	}
	
	@Path("{id}/ingressos/{ingressoId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response altera(String json, @PathParam("id") long id, @PathParam("ingressoId") Long ingressoId) {
		Sala sala = new SalaDAO().busca(id);
		Ingresso ingresso = new Gson().fromJson(json, Ingresso.class);
		sala.troca(ingresso);
		return Response.ok().build();
	}
}
