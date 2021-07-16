package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargaMenus {

	public CargaMenus (){
		
		miConexion = new Conexion();
		
	}
	
	public void ejecutaConsulta () {
		
		Capacitacion miCapacitacion = null;
		
		Connection accesoBBDD = miConexion.conexion();
		
		try {
			
			Statement capacitacion = accesoBBDD.createStatement();
			
			Statement capacitacion2 = accesoBBDD.createStatement();
			
			resultadoCapacitacion = capacitacion.executeQuery("SELECT DISTINCTROW idtipo_capacitacion FROM capacitacion");
			
			resultadoCapacitacion2 = capacitacion2.executeQuery("SELECT DISTINCTROW idtema_capacitacion FROM capacitacion");
			
				
			miCapacitacion = new Capacitacion();
				
				
			//miCapacitacion.setIdtipo_capacitacion(resultadoCapacitacion.getInt("idtipo_capacitacion"));
			
			//System.out.println(miCapacitacion.getIdtipo_capacitacion());
				
			//miCapacitacion.setIdtema_capacitacion(resultadoCapacitacion2.getInt("idtema_capacitacion"));
			
			
			//resultadoCapacitacion.close();
			
			//resultadoCapacitacion2.close();
			
			//accesoBBDD.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	Conexion miConexion;
	
	public ResultSet resultadoCapacitacion;
	
	public ResultSet resultadoCapacitacion2;
}
