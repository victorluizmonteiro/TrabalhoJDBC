package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import br.com.fiap.entity.Cliente;
import br.com.fiap.factory.MySQLDaoFactory;

public class ClienteDaoImpl implements ClienteDao {
	Cliente cliente = null;
	ResultSet rs;
	PreparedStatement stmt;
	Connection cn = null;

	@Override
	public Cliente insert(Cliente cliente) throws Exception {
		try {
			cn = MySQLDaoFactory.criaConexao();

			stmt = cn.prepareStatement("INSERT INTO CLIENTES (NOME, EMAIL) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				cliente.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			cn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();

		}

		return cliente;

	}

	@Override
	public Cliente findById(int id) throws Exception {
		try {
			cn = MySQLDaoFactory.criaConexao();
			stmt = cn.prepareStatement("SELECT * FROM CLIENTES WHERE IDCLIENTE = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				cliente = new Cliente(rs.getInt("IDCLIENTE"), rs.getString("NOME"), rs.getString("EMAIL"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			cn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}

		return cliente;

	}

}
