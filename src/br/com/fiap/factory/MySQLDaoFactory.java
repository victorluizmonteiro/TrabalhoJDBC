package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.ClienteDaoImpl;
import br.com.fiap.dao.PedidoDao;
import br.com.fiap.dao.PedidoDaoImpl;

public class MySQLDaoFactory extends DaoFactory {
	private static final String DRIVER ="com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/vendas_trabalho1";
	
	public static Connection criaConexao()throws Exception{
		return DriverManager.getConnection(URL,"root","");
	}
	@Override
	public ClienteDao getClienteDao() {
		
		return new ClienteDaoImpl();
	}

	@Override
	public PedidoDao getPedidoDao() {
		
		return new PedidoDaoImpl();
	}
	

}
