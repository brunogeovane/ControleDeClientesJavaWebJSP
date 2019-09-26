package br.com.brunogeovane.controleclientes.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String DSN = "jdbc:mysql://localhost/ControleClientes";
	private static final String USUARIO = "root";
	private static final String SENHA = "";

	public Connection getConexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
