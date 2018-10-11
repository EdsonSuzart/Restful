package br.com.restful.controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.restful.DAO.ClienteDAO;
import br.com.restful.modelo.Cliente;

//Classe responsavel por ser um controlador entre o recurso e a camada DAO
public class ClienteCon {

	public ArrayList<Cliente> listarTodos() throws SQLException {
		return ClienteDAO.getInstance().listarTodos();
	}
}
