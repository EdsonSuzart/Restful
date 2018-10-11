package br.com.restful.fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConectarBanco {

	// CLasse que irá fazer conexão com o Banco de Dados
	private static final String URL ="jdbc:mysql://localhost:3306/cliente";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	//Método responsa por criar uma conexao com o BD
	public static Connection criarConexao() throws SQLException {

		// Referencia ao driver mysql para versoes antigas do java
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	public static void main(String[] args) {
		try {
			Connection cone = ConectarBanco.criarConexao();
			System.out.println("Conexão deu certo!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Conexão falhou!!");
		}
	}

	public void fecharConexao(Connection conexao, PreparedStatement pstnt, ResultSet rs) {

		try {

			if (conexao != null) {
				conexao.close();
			}
			if (pstnt != null) {
				pstnt.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception ex) {
			System.out.println("Erro ao fechar conexao com o banco: " + URL);
			ex.printStackTrace();
		}

	}
}
