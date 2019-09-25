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
	public List<Conta> listarContas() {
		ArrayList<Conta> resultadoConsulta = new ArrayList<Conta>();
		String sql = "SELECT * FROM Conta where situacao = 1";
		String sql1 = "SELECT * FROM Conta where situacao = 666";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Conta conta = new Conta (rs.getInt("idConta"), rs.getInt("numero"), rs.getInt("saldo"), rs.getInt("idCliente"), rs.getInt("tipoConta"));
				resultadoConsulta.add(conta);
			}
			stmt = conexao.prepareStatement(sql1);
			ResultSet rs1 = stmt.executeQuery();
			
			while (rs1.next()) {
				Conta conta = new Conta (rs1.getInt("idConta"), rs1.getInt("numero"),rs1.getInt("saldo"), rs1.getInt("idCliente"), rs1.getInt("tipoConta"));
				resultadoConsulta.add(conta);
			}
			stmt.close();
			return resultadoConsulta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void desativarConta(Conta conta) {
		String sql = "UPDATE Conta SET situacao = ? WHERE idConta = ?";
		try {
			int desativada = 0;
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, desativada);
			stmt.setInt(2, conta.getIdConta());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	}

