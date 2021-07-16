package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import modelo.CargaMenus;
import vista.Marco_Aplicacion_MVC;

public class ControladorCargaMenus extends WindowAdapter{

	private CargaMenus obj = new CargaMenus();
	private Marco_Aplicacion_MVC elmarco;
	
	
	public ControladorCargaMenus( Marco_Aplicacion_MVC elmarco) {
		
		this.elmarco = elmarco;		
	}
	
	@Override
	public void windowOpened(WindowEvent evento) {
		obj.ejecutaConsulta();
		
		try {			
			while (obj.resultadoCapacitacion.next()) {
			
				elmarco.secciones.addItem(Integer.toString(obj.resultadoCapacitacion.getInt("idtipo_capacitacion")));
				
			}
			
			
			while(obj.resultadoCapacitacion2.next()) {
				elmarco.paises.addItem(Integer.toString(obj.resultadoCapacitacion2.getInt("idtema_capacitacion")));
			}
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}	
}
