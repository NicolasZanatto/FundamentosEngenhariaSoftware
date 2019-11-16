package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConexao() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/sistemaescola?useTimezone=true&serverTimezone=GMT","root","64317593");
		}catch(Exception erro) {
			throw new RuntimeException("Erro 1: " + erro);
		}
	}
}
