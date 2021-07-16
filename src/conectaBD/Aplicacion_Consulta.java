package conectaBD;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox<String>();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox<String>();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
		botonConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ejecutaConsulta();
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		
		
		//Conexión con la base de datos.
		
		try {
			miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
			
			Statement miStatement = miconexion.createStatement();
			
			String consulta = "SELECT DISTINCTROW idtema_capacitacion FROM capacitacion";
			
			ResultSet resultado = miStatement.executeQuery(consulta);
			
			while(resultado.next()) {
				
				secciones.addItem(Integer.toString(resultado.getInt("idtema_capacitacion")));
			}
			
			resultado.close();
			
			consulta = "SELECT DISTINCTROW idtipo_capacitacion FROM capacitacion";
			
			resultado = miStatement.executeQuery(consulta);
			
			while(resultado.next()) {
				
				paises.addItem(Integer.toString(resultado.getInt("idtipo_capacitacion")));
			}
			
			resultado.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ejecutaConsulta () {
		
		ResultSet resultadoSet = null;
		
		try {
			
			resultado.setText("");
			
			String seccion = secciones.getSelectedItem().toString();
			
			String pais = paises.getSelectedItem().toString();
			
			if (!seccion.equals("Todos") && pais.equals("Todos")) {
				
				enviaConsultaSeccion = miconexion.prepareStatement(consultaSeccion);
				
				enviaConsultaSeccion.setString(1, seccion);
				
				resultadoSet = enviaConsultaSeccion.executeQuery();
				
			} else if (seccion.equals("Todos") && !pais.equals("Todos")) {
				
				enviaConsultaPais = miconexion.prepareStatement(consultaPais);
				
				enviaConsultaPais.setString(1, pais);
				
				resultadoSet = enviaConsultaPais.executeQuery();
				
			} else if (!seccion.equals("Todos") && !pais.equals("Todos")){
				
				enviaConsultaSeccionPais = miconexion.prepareStatement(consultaSeccionPais);
				
				enviaConsultaSeccionPais.setString(1, seccion);
				
				enviaConsultaSeccionPais.setString(2, pais);
				
				resultadoSet = enviaConsultaSeccionPais.executeQuery();
				
			}
			
			
			
			while(resultadoSet.next()) {
				
				resultado.append(resultadoSet.getDate("fecha").toString());
				
				resultado.append(", ");
				
				resultado.append(resultadoSet.getString("descripcion_capacitacion"));
				
				resultado.append("\n");
				
			}
			
		} catch (SQLException e) {
			
			
			
		}
		
		
	}
	
	private Connection miconexion;

	private PreparedStatement enviaConsultaSeccion;
	
	private PreparedStatement enviaConsultaPais;
	
	private PreparedStatement enviaConsultaSeccionPais;
	
	private final String consultaSeccion = "SELECT fecha, descripcion_capacitacion FROM capacitacion WHERE idtipo_capacitacion = ?";
	
	private final String consultaPais = "SELECT fecha, descripcion_capacitacion FROM capacitacion WHERE idtema_capacitacion = ?";
	
	private final String consultaSeccionPais = "SELECT fecha, descripcion_capacitacion FROM capacitacion WHERE idtipo_capacitacion = ? AND idtema_capacitacion = ?";
	
	private JComboBox<String> secciones;
	
	private JComboBox<String> paises;
	
	private JTextArea resultado;	
	

	
}


