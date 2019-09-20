package br.com.brunogeovane.controleclientes.logica;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.security.sasl.SaslException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brunogeovane.controleclientes.dao.ClienteDao;
import br.com.brunogeovane.controleclientes.model.Cliente;


public class CadastrarClienteFisico implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String telefone = req.getParameter("telefone");
		String cpf = req.getParameter("cpf");
		String nomeMae = req.getParameter("nomeMae");
		String nomePai = req.getParameter("nomePai");


		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		cliente.setCpf(cpf);
		cliente.setNomeMae(nomeMae);
		cliente.setNomePai(nomePai);
		

		new ClienteDao().inserirFisica(cliente);

		return "sucesso.jsp";
	}

}
