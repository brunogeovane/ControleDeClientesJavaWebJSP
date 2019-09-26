package br.com.brunogeovane.controleclientes.logica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brunogeovane.controleclientes.dao.ContaDao;
import br.com.brunogeovane.controleclientes.dao.SeguroDao;
import br.com.brunogeovane.controleclientes.model.Conta;
import br.com.brunogeovane.controleclientes.model.Seguro;

public class CriarSeguro implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero = Integer.parseInt(req.getParameter("numero"));
		int valor = Integer.parseInt(req.getParameter("valor"));
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		int tipoCliente = Integer.parseInt(req.getParameter("tipoCliente"));
		
		
		Seguro seguro = new Seguro();
		seguro.setNumero(numero);
		seguro.setValor(valor);
		seguro.setIdCliente(idCliente);
		seguro.setTipoCliente(tipoCliente);
		
		

		new SeguroDao().inserirSeguro(seguro);

		return "sucesso.jsp";
	}
}
