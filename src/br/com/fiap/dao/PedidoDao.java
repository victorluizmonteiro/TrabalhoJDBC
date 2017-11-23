package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pedido;

public interface PedidoDao {
	void insert(Pedido pedido)throws Exception;
	List<Pedido>listAll(int idCliente) throws Exception;
}
