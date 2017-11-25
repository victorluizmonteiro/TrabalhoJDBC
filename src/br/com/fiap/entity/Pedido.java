package br.com.fiap.entity;

import java.util.Date;

public class Pedido {


	private int id;
	private int idCliente;
	private Date data;
	private String descricao;
	private double valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Pedido(int id, int idCliente, Date data, String descricao, double valor) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Pedido() {
		super();
	}
	public Pedido(int idCliente, Date data, String descricao, double valor) {
		super();
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID DO CLIENTE : "+ idCliente + "\nDescrição : "+ descricao + "\nValor : "+ valor;
	}
	
	
	
	
	
}
