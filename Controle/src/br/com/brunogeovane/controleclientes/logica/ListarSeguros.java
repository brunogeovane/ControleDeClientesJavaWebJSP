 package br.com.brunogeovane.controleclientes.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.brunogeovane.controleclientes.dao.SeguroDao;
import br.com.brunogeovane.controleclientes.model.Seguro;

public class ListarSeguros implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SeguroDao dao = new SeguroDao();
		List<Seguro> lista = dao.listarSeguros();

		req.setAttribute("lista", lista);

		return "/listarSeguros.jsp";
		
	}
}
