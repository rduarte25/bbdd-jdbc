package aplicacionfinal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AplicacionUniversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoBBDD miMarco = new MarcoBBDD();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);
		
	}

}

class MarcoBBDD extends JFrame {
	
	public MarcoBBDD() {
		
		setBounds(100, 300, 500, 500);
		
		LaminaBBDD miLamina = new LaminaBBDD();
		
		add(miLamina);
		
	}
	
}

class LaminaBBDD extends JPanel {
	
	private JComboBox<String> comboTablas;
	
	private JTextArea areaInformacion;
	
	private Connection miConexion;
	
	private FileReader entrada;
	
	public LaminaBBDD () {
		
		setLayout(new BorderLayout());
		
		comboTablas = new JComboBox<String>();
		
		areaInformacion = new JTextArea();
		
		add(areaInformacion, BorderLayout.CENTER);
		
		conectarBBDD();
		
		obtenerTablas();
		
		comboTablas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println((String) comboTablas.getSelectedItem());
				
				String nombreTabla = (String) comboTablas.getSelectedItem();
				
				mostrarInfoTabla(nombreTabla);
				
			}
			
		});
		
		add(comboTablas, BorderLayout.NORTH);
		
		
		
	}
	
	public void conectarBBDD () {
		
		miConexion = null;
		
		String datos[] = new String[3];
		
		
		
		try {
			
			entrada = new FileReader("/home/user/Desktop/config.txt");
			
			
		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(this, "El fichero config.txt no se encuentra en la ruta: /home/user/Desktop/");
			
			JFileChooser chooser = new JFileChooser();
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
			
			chooser.setFileFilter(filter);
			
			int returnVal = chooser.showOpenDialog(this);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				
				try {
					entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}			
			
		}
		
		try {
			
			BufferedReader miBuffer = new BufferedReader(entrada); 
			
			for (int i = 0; i <= 2; i++) {
				
				datos[i] = miBuffer.readLine();
				
			}
			
			//miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sgsst-v0.11", "root", "");
		
			miConexion = DriverManager.getConnection(datos[0], datos[1], datos[2]);
			
			
			entrada.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void obtenerTablas () {
		
		ResultSet resultadoConsultaTablas = null;
		
		try {
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			resultadoConsultaTablas = datosBBDD.getTables(null, null, null, null);
			
			while (resultadoConsultaTablas.next()) {
				
				comboTablas.addItem(resultadoConsultaTablas.getString("TABLE_NAME"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void mostrarInfoTabla (String nombreTabla) {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		String consultaCampos = "SELECT * FROM " + nombreTabla;
		
		try {
			
			areaInformacion.setText("");
			
			Statement consultaCamposS = miConexion.createStatement();
			
			ResultSet resultadoConsultaCampos = consultaCamposS.executeQuery(consultaCampos);
			
			ResultSetMetaData resultadoConsultaMetaDatos = resultadoConsultaCampos.getMetaData();
			
			for (int i = 1; i <= resultadoConsultaMetaDatos.getColumnCount(); i++) {
				
				campos.add(resultadoConsultaMetaDatos.getColumnLabel(i));
				
			}
			
			while (resultadoConsultaCampos.next()) {
				
				for (String nombreCampo: campos) {
					
					areaInformacion.append(resultadoConsultaCampos.getString(nombreCampo) + " ");
					
					
				}
				
				areaInformacion.append("\n");
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
