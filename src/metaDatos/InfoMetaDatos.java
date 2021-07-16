package metaDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoMetaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		mostrarInfoTabla();
		
	}
	
	static void mostrarInfoBBDD() {
		
		Connection miConexion = null;
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
		
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			System.out.println("Gestor de base de datos " + datosBBDD.getDatabaseProductName());
			
			System.out.println("Versión del Gestor " + datosBBDD.getDatabaseProductVersion());
			
			System.out.println("Nombre del driver " + datosBBDD.getDriverName());
			
			System.out.println("Versión del driver " + datosBBDD.getDriverVersion());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	static void mostrarInfoTabla () {
		
		Connection miConexion = null;
		
		ResultSet listaTabla = null;
		
		ResultSet listaColumnas = null;
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
		
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			System.out.println("Lista de tablas");
			
			listaTabla = datosBBDD.getTables(null, null, null, null);
			listaColumnas = datosBBDD.getColumns(null, null, "capacitacion", null);
			
			while (listaTabla.next()) {
				
				System.out.println(listaTabla.getString("TABLE_NAME"));
				
			}
			
			System.out.println("\n");
			
			while (listaColumnas.next()) {
				
				System.out.println(listaColumnas.getString("COLUMN_NAME"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
