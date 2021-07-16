package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Connection;

public class ConectaSistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Connection miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
			
			Statement miStatement = miconexion.createStatement();
			
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM capacitacion");
			
			while(miResultSet.next()) {
				System.out.println(miResultSet.getInt("idcapacitacion") + " " + miResultSet.getString("descripcion_capacitacion") + " " + miResultSet.getDate("fecha"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
