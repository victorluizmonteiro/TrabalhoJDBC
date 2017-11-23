package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.entity.Pedido;
import br.com.fiap.factory.MySQLDaoFactory;

public class PedidoDaoImpl implements PedidoDao{
	ResultSet rs;
	PreparedStatement stmt = null;
	Connection cn = null;
	@Override
	public void insert(Pedido pedido) throws Exception {
		try {
			cn=MySQLDaoFactory.criaConexao();
			
			String sql="INSERT INTO PEDIDOS (IDCLIENTE,DATA,DESCRICAO,VALOR) VALUES (?,?,?,?)";
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, pedido.getIdCliente());
			stmt.setDate(2, new Date(pedido.getData().getTime()));
			stmt.setString(3, pedido.getDescricao());
			stmt.setDouble(4, pedido.getValor());
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if (rs.next()){
				pedido.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
			
 		}
		
		
	}

	@Override
	public List<Pedido> listAll(int idCliente) throws Exception {
		List<Pedido> pedidos = new ArrayList<>();
		
		try {
			cn=MySQLDaoFactory.criaConexao();
			
			
			String sql="SELECT * FROM PEDIDOS WHERE IDCLIENTE=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			while (rs.next()){
				pedidos.add(new Pedido(rs.getInt("IDPEDIDO"),idCliente,rs.getDate("DATA"),rs.getString("DESCRICAO"), rs.getDouble("VALOR")));
			}
		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}
		
		return pedidos;
		
	}

}
