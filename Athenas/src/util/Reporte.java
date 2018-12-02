package util;

import java.util.Map;

import conexion.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import presentacion.FrmPrincipal;

public class Reporte {
	
	public static void CreaReporte(String reporte){
		JasperPrint jp;
		try {
			JasperReport jr = (JasperReport) JRLoader.loadObject(Reporte.class.getResource(reporte));
			jp = JasperFillManager.fillReport(jr, null, Conexion.Conectar());
			JasperViewer jv = new JasperViewer(jp, false);
			jv.setTitle("");
			jv.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void CreaReporte(String reporte, Map<String, Object> param){
		JasperPrint jp;
		try {
			JasperReport jr = (JasperReport) JRLoader.loadObject(Reporte.class.getResource(reporte));
			jp = JasperFillManager.fillReport(jr, param, Conexion.Conectar());
			JasperViewer jv = new JasperViewer(jp, false);
			jv.setTitle("");
			jv.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

}
