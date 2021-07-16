package procAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaCapacitacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection miconexion = null;
		
		try {
			
			miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
		
			CallableStatement miSentencia = miconexion.prepareCall("{CALL MAESTRA_CAPACITACION()}");
			
			ResultSet resultadoConsulta = miSentencia.executeQuery();
			
			while (resultadoConsulta.next()) {
				System.out.print(resultadoConsulta.getDate("fecha"));
				System.out.print(", ");
				System.out.println(resultadoConsulta.getString("descripcion_capacitacion"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
