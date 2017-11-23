package br.com.fiap.main;



import java.util.Date;
import java.util.List;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.PedidoDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;
import br.com.fiap.factory.DaoFactory;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ClienteDao clienteDao = DaoFactory.getDaoFactory().getClienteDao();
		PedidoDao pedidoDao = DaoFactory.getDaoFactory().getPedidoDao();
		
		
		Cliente c = new Cliente("Victor Monteiro","victorluiz.monteiro@gmail.com");
		Cliente c1 = new Cliente("Josue Silva","josue@gmail.com");
		
		clienteDao.insert(c);
		clienteDao.insert(c1);
		
		
		
		Pedido p = new Pedido(c.getId(),new Date(),"Furadeira",400);
		Pedido p1 = new Pedido(c.getId(),new Date(),"Estintor",600);
		
		Pedido p2 = new Pedido(c1.getId(),new Date(),"Maquina de lavar",700);
		Pedido p3 = new Pedido(c1.getId(),new Date(),"Banheira",400);
		pedidoDao.insert(p);
		pedidoDao.insert(p1);
		pedidoDao.insert(p2);
		pedidoDao.insert(p3);
		
		List<Pedido>pedidosCliente1 = pedidoDao.listAll(1);
		List<Pedido>pedidosCliente2 = pedidoDao.listAll(2);
		
		Cliente cliente1 = clienteDao.findById(1);

		Cliente cliente2 = clienteDao.findById(2);
		
		System.out.println("Nome : " + cliente1.getNome() + "\nEmail : " + cliente1.getEmail());
		System.out.println("Nome : " + cliente2.getNome() + "\nEmail : " + cliente2.getEmail());
		
		pedidosCliente1.forEach(System.out::println);
		pedidosCliente2.forEach(System.out::println);
		



		
		
		

	}

}
