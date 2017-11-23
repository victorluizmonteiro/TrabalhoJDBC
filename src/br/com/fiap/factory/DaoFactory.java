package br.com.fiap.factory;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.PedidoDao;

public abstract class DaoFactory {
	
	public abstract ClienteDao getClienteDao();
	public abstract PedidoDao getPedidoDao();
	
	
	
	public static DaoFactory getDaoFactory() {
		
		return new MySQLDaoFactory();
	}
	

}
