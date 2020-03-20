package blastproyect;
//Juan Antonio Herrera Conde

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import blast.BlastController;

public class Controller implements ActionListener {

	private ViewPanel tvp;
	
	public Controller(ViewPanel tvp) {
		this.tvp = tvp;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		tvp.reiniciaVentana();
		boolean esCorrecto = true;
		
		String secuencia = "";
		try {
			secuencia = tvp.getcSecuencia().getSelectedItem().toString().toUpperCase();
		}
		catch (NullPointerException npe) {
			mostrarError("      Especifica la secuencia a buscar. ");
			tvp.colorErrorSecuencia();
			esCorrecto = false;
		}		
		if (esCorrecto & secuencia.equals("")) {
			mostrarError("      Especifica la secuencia a buscar. ");
			tvp.colorErrorSecuencia();
			esCorrecto = false;
		}
		else if (! buscada(secuencia)) {
			tvp.getcSecuencia().addItem(secuencia);
		}
		
		String p = null;
		float porcentaje = -1;
		try {
			p = tvp.getTfPorcentaje().getText();
			porcentaje = Float.parseFloat(p);
		}
		catch (NumberFormatException nfe) {
			if (p.equals("")) {
				mostrarError("      Especifica el porcentaje. ");
			}
			else {
				mostrarError("      Formato del porcentaje inadecuado.");
			}
			tvp.colorErrorPorcentaje();
			esCorrecto = false;
		}

		if (porcentaje != -1 & (porcentaje < 0 || porcentaje > 1)) {
			mostrarError("      Porcentaje fuera del rango.");
			tvp.colorErrorPorcentaje();
			esCorrecto = false;
		}
		
		BlastController bCnt = new BlastController();
		String Res = "";
		
		if (tvp.getRbProteinas().isSelected() & esCorrecto) {
			try{
				Res = bCnt.blastQuery('p', tvp.getcBaseDatos().getSelectedItem().toString(), 
						tvp.getcDatosId().getSelectedItem().toString(), porcentaje, secuencia);
				tvp.colorAciertoBusqueda();
			} 
			catch(Exception exc){
				mostrarError( "Error en la llamada: " + exc.toString());
				tvp.colorErrorBusqueda();
			}
		}
		else if (tvp.getRbNucleotidos().isSelected()) {
			Res = "La busqueda de nucleotidos no ha sido implementada todavia. ";
		}
		tvp.getTaRes().setText(Res);
	}
	
	private void mostrarError (String s) {
		JDialog d = new JDialog ();
		d.add(new JLabel (s));
		d.setSize(250, 100);
		d.setVisible(true);
	}

	private boolean buscada(String s) {
		boolean res = false;
		for (int i = 0; i < tvp.getcSecuencia().getItemCount(); i++) {
			if (tvp.getcSecuencia().getItemAt(i).equals(s)){
				res = true;
			}
		}
		return res;
	}
}
