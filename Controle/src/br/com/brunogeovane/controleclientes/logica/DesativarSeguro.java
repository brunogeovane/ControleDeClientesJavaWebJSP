package br.com.brunogeovane.controleclientes.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brunogeovane.controleclientes.dao.SeguroDao;
import br.com.brunogeovane.controleclientes.model.Seguro;

public class DesativarSeguro implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int idSeguro = Integer.parseInt(req.getParameter("idSeguro"));
		
		
		Seguro seguro = new Seguro();
		seguro.setIdSeguro(idSeguro);
		
		new SeguroDao().desativarSeguro(seguro);

		return "/sistema?logica=ListarSegurosDesativados";
	}

}
