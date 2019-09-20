 package br.com.brunogeovane.controleclientes.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brunogeovane.controleclientes.dao.ClienteDao;
import br.com.brunogeovane.controleclientes.model.Cliente;

public class ListarClientes implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = dao.listarClientes();

		req.setAttribute("lista", lista);

		return "/listarClientes.jsp";
	}
}
