package util;

import java.awt.Color;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JTextField;

public class Comunes {
	
	public void habTextField(JTextField obj, boolean estado){
		if(!estado){
			obj.setBackground(SystemColor.control);
			obj.setEditable(false);
		}else{
			obj.setBackground(Color.WHITE);
			obj.setEditable(true);
		}
	}
	
	public String formatDouble(double num){
		//Cambiar despues
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.US);
		NumberFormat formatoDouble = new DecimalFormat("#0.00", simbolos);
		
		return formatoDouble.format(num);
	}
	
	public boolean ValidaTexto(String texto){
		boolean coincide = false;
		
		coincide = texto.matches("[a-zA-Z\\s]+");
		
		return coincide;
	}
	
	public boolean ValidaEntero(String texto){
		boolean coincide = false;
		
		coincide = texto.matches("[\\d]+");
		
		return coincide;
	}
	
	public boolean ValidaDouble(String texto){
		boolean coincide = false;
		
		coincide = texto.matches("[\\d]+([\\.,]{1}[\\d]+)?");
		
		return coincide;
	}
	
	public boolean ValidaEmail(String texto){
		boolean coincide = false;
		
		coincide = texto.matches("^[a-zA-Z0-9\\._-]+@[a-zA-Z0-9\\._-]+\\.[a-zA-Z0-9_-]+$");
		
		return coincide;
	}
}
