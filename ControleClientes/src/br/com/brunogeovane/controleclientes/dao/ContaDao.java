package br.com.brunogeovane.controleclientes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.brunogeovane.controleclientes.conexao.Conexao;
import br.com.brunogeovane.controleclientes.model.Cliente;
import br.com.brunogeovane.controleclientes.model.Conta
;

public class ContaDao {

	private Connection conexao;
	private PreparedStatement stmt;

	public ContaDao() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserirConta(Conta conta) {
		String sql = "INSERT INTO Conta (tipoConta, tipoCliente, idCliente, numero, saldo, situacao) VALUES (?,?,?,?,?,?)";
		try {
			int ativo = 1;
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getTipoConta());
			stmt.setInt(2, conta.getTipoCliente());
			stmt.setInt(3, conta.getIdCliente());
			stmt.setInt(4, conta.getNumero());
			stmt.setInt(5, conta.getSaldo());
			stmt.setInt(6, ativo);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	
}
