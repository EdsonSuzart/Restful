package br.com.restful.recursos;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import br.com.restful.controlador.ClienteCon;
import br.com.restful.modelo.Cliente;

//Classe responsavel por conter os metodos REST de acesso ao WebSErvice

@Path ("/cliente")
public class ClienteResource {
	
	
	//método responsavel por fazer chamada ao controlador
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<Cliente> listarTodos() throws SQLException{
		return new ClienteCon().listarTodos();
	}

}
