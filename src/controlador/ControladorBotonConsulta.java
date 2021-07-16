package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.EjecutaConsultas;
import vista.Marco_Aplicacion_MVC;

public class ControladorBotonConsulta implements ActionListener {

	private Marco_Aplicacion_MVC elmarco;
	
	EjecutaConsultas obj = new EjecutaConsultas();
	
	public ControladorBotonConsulta (Marco_Aplicacion_MVC elmarco) {
		
		this.elmarco = elmarco;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		
		String seleccion_tipo_capacitacion = (String) elmarco.secciones.getSelectedItem();
		
		
		String seleccion_tema_capacitacion = (String) elmarco.paises.getSelectedItem();
		
		resultadoConsulta = obj.filtraBBDD(seleccion_tipo_capacitacion, seleccion_tema_capacitacion);
		
		
		
		try {
			elmarco.resultado.setText("");
			while(resultadoConsulta.next()) {
							
				elmarco.resultado.append(resultadoConsulta.getDate("fecha").toString());
				elmarco.resultado.append(", ");
				elmarco.resultado.append(resultadoConsulta.getString("descripcion_capacitacion"));
				elmarco.resultado.append("\n");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private ResultSet resultadoConsulta;
	
}
