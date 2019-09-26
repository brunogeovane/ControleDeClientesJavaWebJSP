  package br.com.brunogeovane.controleclientes.model;

public class Seguro {
	private int idSeguro;
	private int idCliente;
	private int tipoCliente;
	private int numero;
	private int situação;
	private int valor;
	private String nome;
	
	public Seguro (int idSeguro, int numero, int valor, int idCliente, int TipoCliente) {
		 //criado para listar
	this.setIdSeguro(idSeguro);
    this.setNumero(numero);
    this.setValor(valor);
    this.setIdCliente(idCliente);
    this.setTipoCliente(TipoCliente);
    this.setNome(nome);
			}
	public Seguro() {
		// TODO Auto-generated constructor stub
	}
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
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
	public int getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public int getSituação() {
		return situação;
	}
	public void setSituação(int situação) {
		this.situação = situação;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
