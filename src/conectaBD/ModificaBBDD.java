package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModificaBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Connection miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
			
			Statement miStatement = miconexion.createStatement();
			
			//String sql = "INSERT INTO rol (idrol, nombre) VALUES (NULL, 'Usuario Avansado')";
			
			//String sql = "UPDATE rol SET nombre = 'Usuario más Avanzado' WHERE idrol = 3";
			
			String sql = "DELETE FROM rol WHERE idrol = 3";
			
			miStatement.executeUpdate(sql);
			
			//System.out.println("Registrado");
			
			//System.out.println("Modificado");
			
			System.out.println("Eliminado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
