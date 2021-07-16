package principal;

import javax.swing.JFrame;

import vista.Marco_Aplicacion_MVC;

public class Ejecuta_Modelo_Vista_Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marco_Aplicacion_MVC miMarco = new Marco_Aplicacion_MVC();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);
		
	}

}
