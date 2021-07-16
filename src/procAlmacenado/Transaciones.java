package procAlmacenado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Transaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Connection miconexion = null;
		
		try {
			
			miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
			
			miconexion.setAutoCommit(false);
			
			Statement miSentencia_1 = miconexion.createStatement();
			
			Statement miSentencia_2 = miconexion.createStatement();
		
			String miConsulta_1 = "INSERT INTO capacitacion (idcapacitacion, fecha, idtipo_capacitacion, descripcion_capacitacion, idtema_capacitacion, duracion, ci_asistente, nombre_asistente, realizado_por, observaciones) VALUES (14, '2019-10-03 00:00:00', '1', 'Descripcion', '1', '48', '12345678', 'Rafael', 'Rafael', 'Observaciones')";
			
			String miConsulta_2 = "UPDATE capacitacion SET fecha = '2019-10-17 00:00:00', idtipo_capacitacion = '2', descripcion_capacitacion = 'Descripcion Actualizada', idtema_capacitacion = '2', duracion = '40', ci_asistente = '123456789', nombre_asistente = 'Rafael Duarte', realizado_por = 'Rafael Duarte', observaciones = 'Observaciones Actualizada' WHERE idcapacitacion = 14";
			
			miSentencia_1.execute(miConsulta_1);
			
			miSentencia_2.execute(miConsulta_2);
			
			miconexion.commit();
			
			System.out.println("Actualizacion Ok");
			
			System.out.println("Actualizacion Ok");
			
		} catch (SQLException e) {
			
			
			try {
				miconexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
	}

}
