package br.com.brunogeovane.controleclientes.logica;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brunogeovane.controleclientes.dao.ContaDao;
import br.com.brunogeovane.controleclientes.model.Conta;

public class DepositarValor implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int numero = Integer.parseInt(req.getParameter("numerodaconta"));
       int valor = Integer.parseInt(req.getParameter("valor"));
       int saldo = Integer.parseInt(req.getParameter("saldo"));
		
		
		Conta conta = new Conta();
		conta.setNumero(numero);
		conta.setValor(valor);
		conta.setSaldo(saldo);
		
		new ContaDao().depositarConta(conta);

		return "/sistema?logica=ListarDepositar";
	}

}
