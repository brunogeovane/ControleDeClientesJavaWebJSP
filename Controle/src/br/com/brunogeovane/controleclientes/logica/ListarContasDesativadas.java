package br.com.brunogeovane.controleclientes.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brunogeovane.controleclientes.dao.ContaDao;
import br.com.brunogeovane.controleclientes.model.Conta;

public class ListarContasDesativadas implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContaDao dao = new ContaDao();
		List<Conta> lista = dao.listarContasDesativadas();

		req.setAttribute("lista", lista);

		return "ListarContasDesativadas.jsp";
		
	}

}
