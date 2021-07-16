package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private Connection miconexion = null;
	
	
	public Conexion () {
		
	}
	
	public Connection conexion () {
		
		try {
			
			miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return miconexion;
	}
	
	
}
