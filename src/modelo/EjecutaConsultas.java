package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjecutaConsultas {
	
	private Conexion miConexion;
	
	private ResultSet resultadoConsulta;
	
	private PreparedStatement consultaPreparada1;
	
	private final String SQL1 = "SELECT fecha, descripcion_capacitacion FROM capacitacion WHERE idtipo_capacitacion = ?";
	
	private PreparedStatement consultaPreparada2;
	
	private final String SQL2 = "SELECT fecha, descripcion_capacitacion FROM capacitacion WHERE idtema_capacitacion = ?";
	
	private PreparedStatement consultaPreparada3;
	
	private final String SQL3 = "SELECT fecha, descripcion_capacitacion FROM capacitacion WHERE idtipo_capacitacion = ? AND idtema_capacitacion = ?";

	
	public EjecutaConsultas () {
		
		miConexion = new Conexion();
		
	}
	
	public ResultSet filtraBBDD(String idtipo_capacitacion, String idtema_capacitacion ) {
		
		Connection conecta = miConexion.conexion();
		
		resultadoConsulta = null;
		
		try {		
			if (!idtipo_capacitacion.equals("Todos") && idtema_capacitacion.equals("Todos")) {
				
				consultaPreparada1 = conecta.prepareStatement(SQL1);
				
				consultaPreparada1.setString(1, idtipo_capacitacion);
				
				resultadoConsulta = consultaPreparada1.executeQuery();
				
				return resultadoConsulta;
				
				
				
			} else if (idtipo_capacitacion.equals("Todos") && !idtema_capacitacion.equals("Todos")) {
				
				consultaPreparada2 = conecta.prepareStatement(SQL2);
				
				consultaPreparada2.setString(1, idtema_capacitacion);
				
				resultadoConsulta = consultaPreparada2.executeQuery();
				
				return resultadoConsulta;
				
			} else if (!idtipo_capacitacion.equals("Todos") && !idtema_capacitacion.equals("Todos")) {
				
				consultaPreparada3 = conecta.prepareStatement(SQL3);
				
				consultaPreparada3.setString(1, idtipo_capacitacion);
				
				consultaPreparada3.setString(2, idtema_capacitacion);
				
				resultadoConsulta = consultaPreparada3.executeQuery();
				
				return resultadoConsulta;
				
			}
		
		
		} catch (SQLException e) {
			
		}
		
		return resultadoConsulta;
		
	}
	
	
	//private String pruebas;
}
