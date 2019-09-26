<%@page import="br.com.brunogeovane.controleclientes.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="br.com.brunogeovane.controleclientes.dao.ClienteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Controle de Clientes</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="index.jsp"><i class="material-icons">
power_settings_new
</i>Controle de Clientes</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Alterna navegação">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="material-icons">
scatter_plot
</i>Conta
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="desativadas.jsp">Controle</a>
          <a class="dropdown-item" href="FormConta.jsp">Criar Conta</a>
          <a class="dropdown-item" href="desativadas.jsp">Desativadas</a>
        </div>
      </li>
	    
	    <li class="nav-item">
        <a class="nav-link" href="sistema?logica=ListarClientes"><i class="material-icons">
build
</i>Lista de Clientes<span class="sr-only">(Página atual)</span></a>
      </li>
	    
	
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="material-icons">
library_add
</i>Novo Cliente
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="FormFisico.jsp">Fisico</a>
          <a class="dropdown-item" href="FormJuridico.jsp">Juridico</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
<br>
	<h3>Cadastro de Seguro</h3><br>
<form action="sistema?logica=CriarSeguro" method="post">


		 <div class="form-group row">
    <label class="col-sm-2 col-form-label">Número</label>
    <div class="col-sm-10">
      <input name="numero" type="text" class="form-control" placeholder="Número da conta">
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">Valor</label>
    <div class="col-sm-10">
      <input name="valor" type="text" class="form-control" placeholder="00.00">
    </div>
  </div>
		<select name="idCliente" class="form-control form-control-lg">
		<%
			List<Cliente> lista = new ClienteDao().listarClientes();
		
			for (Cliente cliente : lista) {
				out.println("<option value='" + cliente.getIdCliente() + "'>" + cliente.getIdCliente() + " - " + cliente.getTipoCliente() + " - " + cliente.getNome() +  "</option>");
			}
		%>
		</select> 
		<br> <p class="text-danger">Atenção por favor confirme o padrão do Cliente abaixo:</p>
		<select name="tipoCliente" class="form-control form-control-lg">
		<%
			List<Cliente> lista2 = new ClienteDao().listarClientes();
		
			for (Cliente cliente : lista) {
				out.println("<option value='" + cliente.getTipoCliente() + "'>" + cliente.getIdCliente() + " - " + cliente.getTipoCliente() +"</option>");
			}
		%>
		</select>
<br>		
		<center><input type="submit" class="btn btn-dark" value="Criar Seguro"></center>
	</form>
</body>
</html>