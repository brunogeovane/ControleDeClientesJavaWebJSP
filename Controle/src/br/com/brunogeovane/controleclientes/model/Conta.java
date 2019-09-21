package br.com.brunogeovane.controleclientes.model;

public class Conta {
	private int idConta;
	private int tipoConta;
	private int idCliente;
	private int tipoCliente;
	private int numero;
	private int saldo;
	private int situação;
	//private String nome;
	
	public Conta(int idConta, int numero, int saldo) {
		 //criado para listar
	this.idCliente = idCliente;
    this.idConta = idConta;
	this.tipoCliente = tipoCliente;
	this.tipoConta = tipoConta;
	this.numero = numero;
	this.saldo = saldo;
	//this.setNome(nome);
			}
	public Conta() {
		// criado pro inserts da conta
	}

	public int getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public int getSaldo() {
		return saldo;
	}
	public int getSituação() {
		return situação;
	}
	public void setSituação(int situação) {
		this.situação = situação;
	}
	public int getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	
	

	
	
}

