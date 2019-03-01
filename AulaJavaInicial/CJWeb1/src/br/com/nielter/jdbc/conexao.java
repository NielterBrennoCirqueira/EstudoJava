package br.com.nielter.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	
	public static Connection getConnerction(){
		Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CJWeb1","postgres","123456");
			    System.out.println("Conectado com Sucesso");
			} catch (SQLException e) {
				System.out.println("Não Pode Conectar: " + e.getMessage());
			}
			return con;
	}
}
