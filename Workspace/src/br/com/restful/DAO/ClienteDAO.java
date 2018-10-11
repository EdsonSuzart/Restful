package br.com.restful.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.restful.modelo.Cliente;
import br.com.restful.fabrica.ConectarBanco;

public class ClienteDAO extends ConectarBanco {

	private static ClienteDAO instance;

	// Metodo responsavel por criar uma instancia da classe ClienteDAO
	public static ClienteDAO getInstance() {

		if (instance == null) 
			instance = new ClienteDAO();
			return instance;
	}

	public ArrayList<Cliente> listarTodos() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idcliente, nome, matricula ");// utiliza codigos sql para indicar o que deve ser buscado
		sql.append("FROM dados ");
		sql.append("ORDER BY nome ASC ");

		Connection conex = ConectarBanco.criarConexao();// Traz a classe conectar e faz a conexão com o bd

		PreparedStatement comando = conex.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();// traz o resultado que estiver
		ArrayList<Cliente> lista = new ArrayList<Cliente>();// instancia uma lista de Cliente

		while (resultado.next()) {
			Cliente f = new Cliente();// instanciando um objeto que irá trazer como resultado os dados do
										// banco de dados
			f.setId(resultado.getInt("idcliente"));
			f.setNome(resultado.getString("nome"));
			f.setMatricula(resultado.getInt("matricula"));

			lista.add(f);

		}
		return lista;

	}

}
