package br.com.brunogeovane.controleclientes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.brunogeovane.controleclientes.conexao.Conexao;
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
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Conta conta = new Conta (rs.getInt("idConta"), rs.getInt("numero"), rs.getInt("saldo"), rs.getInt("idCliente"), rs.getInt("tipoConta"));
				resultadoConsulta.add(conta);
			}
		//	int a = rs.getInt("idCliente");
		//	int b = rs.getInt("tipoCliente");
		//	String sql1 = "SELECT nome ClienteFisico FROM ClienteFisico UNION SELECT nome ClienteJuridico FROM ClienteJuridico where idCliente = a and tipoCliente = b ";
		//	stmt = conexao.prepareStatement(sql1);
	//		ResultSet rs1 = stmt.executeQuery();
			
		//	while (rs1.next()) {
		//		Conta conta = new Conta (rs1.getString("nome"));
		//		resultadoConsulta.add(conta);
		//	}
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

	public List<Conta> listarContasDesativadas() {
		ArrayList<Conta> resultadoConsulta = new ArrayList<Conta>();
		String sql = "SELECT * FROM Conta where situacao = 0";
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
				Conta conta = new Conta (rs.getInt("idConta"), rs.getInt("numero"), rs.getInt("saldo"), rs.getInt("idCliente"), rs.getInt("tipoConta"));
				resultadoConsulta.add(conta);
			}
			stmt.close();
			return resultadoConsulta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void ativarConta(Conta conta) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Conta SET situacao = ? WHERE idConta = ?";
		try {
			int desativada = 1;
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, desativada);
			stmt.setInt(2, conta.getIdConta());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void depositarConta(Conta conta) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Conta SET saldo = ? WHERE numero = ?";
		try {
			int saldo = conta.getSaldo();
			int resultado = saldo + conta.getValor();
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, resultado);
			stmt.setInt(2, conta.getNumero());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	

	}

