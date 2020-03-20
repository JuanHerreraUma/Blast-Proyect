package blastproyect;
//Juan Antonio Herrera Conde

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import blastproyect.Controller;
import blastproyect.ViewPanel;

public class Principal {
	public static void main(String[] args){
		Runnable rr = new Runnable(){
			public void run ( ) {
					
				JFrame frame = new JFrame ("Ventana");
					
				ViewPanel vp = new ViewPanel();
				Controller controller = new Controller(vp);
					
				vp.getBuscar().addActionListener(controller);
					
				frame.getContentPane().add(vp);		
				frame.pack();
				frame.setExtendedState(Frame.MAXIMIZED_BOTH);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);			
				}
		};
		SwingUtilities.invokeLater(rr);
	}
}

