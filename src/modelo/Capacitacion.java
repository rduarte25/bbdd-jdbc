package modelo;

import java.util.Date;

public class Capacitacion {

	
	
	private Date fecha;
	private int idtipo_capacitacion;
	private String descripcion_capacitacion;
	private int idtema_capacitacion;
	
	public Capacitacion () {
		
		this.fecha = new Date();
		this.idtipo_capacitacion = 0;
		this.descripcion_capacitacion = "";
		this.idtema_capacitacion = 0;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdtipo_capacitacion() {
		return idtipo_capacitacion;
	}

	public void setIdtipo_capacitacion(int idtipo_capacitacion) {
		this.idtipo_capacitacion = idtipo_capacitacion;
	}

	public String getDescripcion_capacitacion() {
		return descripcion_capacitacion;
	}

	public void setDescripcion_capacitacion(String descripcion_capacitacion) {
		this.descripcion_capacitacion = descripcion_capacitacion;
	}

	public int getIdtema_capacitacion() {
		return idtema_capacitacion;
	}

	public void setIdtema_capacitacion(int idtema_capacitacion) {
		this.idtema_capacitacion = idtema_capacitacion;
	}

}
