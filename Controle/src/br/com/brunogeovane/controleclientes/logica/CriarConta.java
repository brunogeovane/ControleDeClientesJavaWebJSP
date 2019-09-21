package br.com.brunogeovane.controleclientes.logica;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brunogeovane.controleclientes.dao.ContaDao;
import br.com.brunogeovane.controleclientes.model.Conta;

public class CriarConta implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero = Integer.parseInt(req.getParameter("numero"));
		double saldo = Integer.parseInt(req.getParameter("saldo"));
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		int tipoCliente = Integer.parseInt(req.getParameter("tipoCliente"));
		int tipoConta = Integer.parseInt(req.getParameter("tipoConta"));
		
		
		Conta conta = new Conta();
		conta.setNumero(numero);
		conta.setSaldo((int) saldo);
		conta.setIdCliente(idCliente);
		conta.setTipoCliente(tipoCliente);
		conta.setTipoConta(tipoConta);
		
		

		new ContaDao().inserirConta(conta);

		return "sucesso.jsp";
	}
}
