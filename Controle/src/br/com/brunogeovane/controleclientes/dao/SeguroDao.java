package br.com.brunogeovane.controleclientes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.brunogeovane.controleclientes.conexao.Conexao;
import br.com.brunogeovane.controleclientes.model.Seguro;

public class SeguroDao {

	private Connection conexao;
	private PreparedStatement stmt;

	public SeguroDao() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserirSeguro(Seguro seguro) {
		String sql = "INSERT INTO Seguro (situacao, tipoCliente, idCliente, numero, valor) VALUES (?,?,?,?,?)";
		try {
			int ativo = 1;
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, ativo);
			stmt.setInt(2, seguro.getTipoCliente());
			stmt.setInt(3, seguro.getIdCliente());
			stmt.setInt(4, seguro.getNumero());
			stmt.setInt(5, seguro.getValor());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Seguro> listarSeguros() {
		ArrayList<Seguro> resultadoConsulta = new ArrayList<Seguro>();
		String sql = "SELECT * FROM Seguro where situacao = 1";
		String sql1 = "SELECT * FROM Seguro where situacao = 666";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Seguro seguro = new Seguro (rs.getInt("idSeguro"), rs.getInt("numero"), rs.getInt("valor"), rs.getInt("idCliente"), rs.getInt("tipoCliente"));
				resultadoConsulta.add(seguro);
			}
			stmt = conexao.prepareStatement(sql1);
			ResultSet rs1 = stmt.executeQuery();
			while (rs1.next()) {
				Seguro seguro = new Seguro (rs.getInt("idSeguro"), rs.getInt("numero"), rs.getInt("valor"), rs.getInt("idCliente"), rs.getInt("tipoCliente"));
				resultadoConsulta.add(seguro);
			}
			stmt.close();
			return resultadoConsulta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void desativarSeguro(Seguro seguro) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Seguro SET situacao = ? WHERE idSeguro = ?";
		try {
			int desativada = 0;
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, desativada);
			stmt.setInt(2, seguro.getIdSeguro());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void ativarSeguro(Seguro seguro) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Seguro SET situacao = ? WHERE idSeguro = ?";
		try {
			int desativada = 1;
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, desativada);
			stmt.setInt(2, seguro.getIdSeguro());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Seguro> listarSegurosDesativadas() {
		ArrayList<Seguro> resultadoConsulta = new ArrayList<Seguro>();
		String sql = "SELECT * FROM Seguro where situacao = 0";
		String sql1 = "SELECT * FROM Seguro where situacao = 666";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Seguro seguro = new Seguro (rs.getInt("idSeguro"), rs.getInt("numero"), rs.getInt("valor"), rs.getInt("idCliente"), rs.getInt("tipoCliente"));
				resultadoConsulta.add(seguro);
			}
			stmt = conexao.prepareStatement(sql1);
			ResultSet rs1 = stmt.executeQuery();
			while (rs1.next()) {
				Seguro seguro = new Seguro (rs.getInt("idSeguro"), rs.getInt("numero"), rs.getInt("valor"), rs.getInt("idCliente"), rs.getInt("tipoCliente"));
				resultadoConsulta.add(seguro);
			}
			stmt.close();
			return resultadoConsulta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	}

	
