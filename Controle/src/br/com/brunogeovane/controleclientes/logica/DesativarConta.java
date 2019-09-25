package br.com.brunogeovane.controleclientes.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brunogeovane.controleclientes.dao.ContaDao;
import br.com.brunogeovane.controleclientes.model.Conta;

public class DesativarConta implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int idConta = Integer.parseInt(req.getParameter("idConta"));
		
		
		Conta conta = new Conta();
		conta.setIdConta(idConta);
		
		new ContaDao().desativarConta(conta);

		return "sucesso.jsp";
	}

}
