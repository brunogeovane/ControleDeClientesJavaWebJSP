package br.com.brunogeovane.controleclientes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.brunogeovane.controleclientes.model.Cliente;
import br.com.brunogeovane.controleclientes.conexao.Conexao;

public class ClienteDao {

	private Connection conexao;
	private PreparedStatement stmt;

	public ClienteDao() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserirFisica(Cliente cliente) {
		String sql = "INSERT INTO ClienteFisico (tipoCliente, nome, endereco, telefone, cpf, nomeMae, nomePai) VALUES (?,?,?,?,?,?,?)";
		try {
			int fisica = 1;
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, fisica);
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getCpf());
			stmt.setString(6, cliente.getNomeMae());
			stmt.setString(7, cliente.getNomePai());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	public void inserirJuridica(Cliente cliente) {
		String sql = "INSERT INTO ClienteJuridico (tipoCliente, nome, endereco, telefone, cnpj, nomeFantasia) VALUES (?,?,?,?,?,?)";
		try {
			int juridico = 2;
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, juridico);
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getCnpj());
			stmt.setString(6, cliente.getNomeFantasia());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public List<Cliente> listarClientes() {
		ArrayList<Cliente> resultadoConsulta = new ArrayList<Cliente>();
		String sql = "SELECT * FROM ClienteFisico";
		String sql1 = "SELECT * FROM ClienteJuridico";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cliente cliente = new Cliente (rs.getInt("idCliente"), rs.getInt("tipoCliente"), rs.getString("nome"));
				resultadoConsulta.add(cliente);
			}
			stmt = conexao.prepareStatement(sql1);
			ResultSet rs1 = stmt.executeQuery();
			
			while (rs1.next()) {
				Cliente cliente = new Cliente (rs1.getInt("idCliente"), rs1.getInt("tipoCliente"), rs1.getString("nome"));
				resultadoConsulta.add(cliente);
			}
			stmt.close();
			return resultadoConsulta;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	}