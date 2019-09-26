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

	public List<Seguro> listarContas() {
		ArrayList<Seguro> resultadoConsulta = new ArrayList<Seguro>();
		String sql = "SELECT * FROM Conta";
		String sql1 = "SELECT * FROM Conta";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Seguro conta = new seguro (rs.getInt("idConta"), rs.getInt("numero"), rs.getInt("saldo"), rs.getInt("idCliente"), rs.getInt("tipoConta"));
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

	}

