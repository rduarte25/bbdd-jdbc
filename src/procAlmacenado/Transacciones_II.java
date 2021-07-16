package procAlmacenado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Transacciones_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
Connection miconexion = null;
		
		try {
			
			miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
			
			miconexion.setAutoCommit(false);
			
			Statement miSentencia_1 = miconexion.createStatement();
			
			Statement miSentencia_2 = miconexion.createStatement();
			
			Statement miSentencia_3 = miconexion.createStatement();
		
			String miConsulta_1 = "DELETE FROM capacitacion WHERE idcapacitacion = 13";
			
			String miConsulta_2 = "DELETE FROM capacitacion WHERE idtipo_capacitacion = 3";
			
			String miConsulta_3 = "UPDATE capacitacion SET descripcion_capacitacion = 'Descripción Actualizada'";
			
			boolean ejecutar = ejecutarTransaccion();
			
			if (ejecutar) {
				
				miSentencia_1.executeUpdate(miConsulta_1);
				
				miSentencia_2.executeUpdate(miConsulta_2);
				
				miSentencia_3.executeUpdate(miConsulta_3);
				
				miconexion.commit();
				
				System.out.println("Transacción Ok");
				
			} else {
				System.out.println("No se realizó ningún cambio");
			}			
			
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
	
	static boolean ejecutarTransaccion () {
		
		String ejecucion = JOptionPane.showInputDialog("Ejecuto?");
		
		if (ejecucion.equalsIgnoreCase("si")) {
			return true;
		} else {
			return false;
		}
		
	}

}
