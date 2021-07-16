package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.ControladorBotonConsulta;
import controlador.ControladorCargaMenus;

public class Marco_Aplicacion_MVC extends JFrame {
	
	public Marco_Aplicacion_MVC(){
			
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
			
			add(botonConsulta, BorderLayout.SOUTH);
			
			botonConsulta.addActionListener(new ControladorBotonConsulta(this));
			
			addWindowListener(new ControladorCargaMenus(this));
			
	}
	
	public JComboBox<String> secciones;
	
	public JComboBox<String> paises;
	
	public JTextArea resultado;
	
}
