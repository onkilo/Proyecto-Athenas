package util;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JTextField;

public class Comunes {
	
	public void habTextField(JTextField obj, boolean estado){
		if(estado){
			obj.setBackground(SystemColor.control);
			obj.setEditable(false);
		}else{
			obj.setBackground(Color.WHITE);
			obj.setEditable(true);
		}
	}
}
