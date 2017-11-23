package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;

public interface ClienteDao {

		Cliente insert (Cliente cliente) throws Exception;
		Cliente findById(int id)throws Exception;
}
