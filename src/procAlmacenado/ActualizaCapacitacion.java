package procAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ActualizaCapacitacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nueva_descripcion = JOptionPane.showInputDialog("Intreza la descripcion");
		
		int idcapacitacion = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id"));
		
		Connection miconexion = null;
		
		try {
			
			miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
		
			CallableStatement miSentencia = miconexion.prepareCall("{CALL ACTUALIZA_CAPACITACION(?, ?)}");
			
			miSentencia.setString(1, nueva_descripcion);
			
			miSentencia.setInt(2, idcapacitacion);
			
			miSentencia.execute();
			
			System.out.println("Actualizacion Ok");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
