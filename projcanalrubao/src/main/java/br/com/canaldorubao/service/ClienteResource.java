package br.com.canaldorubao.service;

import java.util.List;

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

import org.glassfish.jersey.server.internal.process.RespondingContext;

import br.com.canaldorubao.dao.cliente.ClienteDAO;
import br.com.canaldorubao.model.cliente.Cliente;

@Path("/cliente")
public class ClienteResource {

	private ClienteDAO db = new ClienteDAO();
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Cliente incluirCLiente(Cliente cliente) {
		return db.insert(cliente);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/alterar")
	public Response alterarCliente(Cliente cliente) {
		if ( ! db.exists(cliente.getId())) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Cliente "+cliente.getId() +  " não existe!")
					.build();
		}
		
		Cliente clienteDB = db.update(cliente);
		return Response
				.ok()
				.entity("Cliente "+clienteDB.getId() + " atualizado com sucesso!").build();
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/excluir/{id}")
	public Response excluirCliente(@PathParam("id") Long id) {
		if ( id == 0) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("ID do cliente invalido! " +  " não existe!")
					.build();
		}
		
		if ( ! db.exists(id)) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Cliente "+id +  " não existe!")
					.build();
		}
		
		db.delete(id);
		return Response
				.ok()
				.entity("Cliente "+id + " excluido com sucesso!")
				.build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consulta/id/{id}")
	public Cliente buscaId(@PathParam("id") Long id) {
		return db.getById(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consulta/todos")
	public List<Cliente> buscaTodos(){
		return db.getAll();
	}
	
	
}





