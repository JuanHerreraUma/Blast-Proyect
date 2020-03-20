package blastproyect;
//Juan Antonio Herrera Conde
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.*;

public class ViewPanel extends JPanel {

	private JLabel labBaseDatos;
	private JComboBox <String> cbBaseDatos;
	private JLabel labDatosId;
	private JComboBox <String> cbDatosId;
	private JLabel labSelecciona;
	private JRadioButton rabProteinas;
	private JRadioButton rabNucleotidos;
	private JLabel labSecuencia;
	private JComboBox <String> cbSecuencia;
	private JLabel labPorcentaje;
	private JTextField texfPorcentaje;
	private JButton butBuscar;
	private JTextArea texaRes;
	private JScrollPane scpaRes;

	private JPanel p0;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel pRelleno1;
	private JPanel pRelleno2;
	private JPanel pRelleno3;
	private JPanel pRelleno4;
	
	private static Color ROJO_FONDO = new Color (203, 50, 52);
	private static Color GRIS = new Color (156, 156, 156);
	private static Color ROJO = new Color (108, 70, 117);
	private static Color VERDE = new Color (185, 250, 179);
	
	public ViewPanel() {
		
		p0 = new JPanel();
		p0.setLayout(new GridLayout( 2 , 2 ) ) ;
		
		labBaseDatos = new JLabel("Elija la base de datos:   ");
		labDatosId = new JLabel("Elija los identificadores:   ");
		
		cbDatosId = new JComboBox <String> ();
		cbBaseDatos = new JComboBox <String> ();
		
		cbBaseDatos.addItem("yeast.aa");
		cbDatosId.addItem("yeast.aa.indexs");
		
		p0.add(labBaseDatos);
		p0.add(cbBaseDatos);
		p0.add(labDatosId);
		p0.add(cbDatosId);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout( 1 , 2 ) ) ;
		
		labSelecciona = new JLabel("¿Que buscas?       ");
		
		rabProteinas = new JRadioButton("Proteinas");
		rabNucleotidos = new JRadioButton("Nucleotidos");
		
		rabProteinas.setSelected(true);
		rabNucleotidos.setSelected(false);
		
		ButtonGroup grupo = new ButtonGroup();
		
		grupo.add(rabProteinas);
		grupo.add(rabNucleotidos);
		
		p1.add(labSelecciona);
		p1.add(rabProteinas);
		p1.add(rabNucleotidos);
			
		p2 = new JPanel();
		p2.setLayout(new GridLayout( 2 , 1 ) ) ;
		
		labSecuencia = new JLabel("Introduce la secuencia de busqueda           ");
		
		cbSecuencia = new JComboBox <String>();
		cbSecuencia.setEditable(true);
		
		p2.add(labSecuencia);
		p2.add(cbSecuencia);
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout( 2 , 1 ) ) ;
		
		labPorcentaje = new JLabel("Introduce el porcentaje entre 0.0 y 1.0       " );
		
		texfPorcentaje = new JTextField ();
		
		p3.add(labPorcentaje);
		p3.add(texfPorcentaje);
		
		butBuscar = new JButton("Buscar");
				
		texaRes = new JTextArea(30, 70);
		texaRes.setEditable(false);
		scpaRes = new JScrollPane(texaRes);
		
		pRelleno1 = new JPanel();
		pRelleno1.setSize(20, 10);
		
		pRelleno2 = new JPanel();
		pRelleno2.setSize(20, 10);
		
		pRelleno3 = new JPanel();
		pRelleno3.setSize(20, 10);
		
		pRelleno4 = new JPanel();
		pRelleno4.setSize(20, 10);
		
		iniciaColoresFondo();
		
		this.add(p0);
		this.add(pRelleno1);
		this.add(p1);
		this.add(pRelleno2);
		this.add(p2);
		this.add(pRelleno3);
		this.add(p3);
		this.add(pRelleno4);
		this.add(butBuscar);
		this.add(scpaRes);
	}
	
	public void iniciaColoresFondo() {
		Component elementosAmarillos [] = {p0, p1, rabProteinas, rabNucleotidos, p2, p3};
		ponColor (elementosAmarillos, GRIS);
		
		Component elementosLilas [] = {pRelleno1, pRelleno2, pRelleno3, pRelleno4};
		ponColor (elementosLilas, ROJO_FONDO);	
		this.setBackground(ROJO_FONDO);
		
		texaRes.setBackground(ROJO);
	}
	
	private void ponColor (Component [] elementos, Color c) {
		for (Component e : elementos) {
			e.setBackground(c);
		}
	}
	
	public void reiniciaVentana() {
		cbSecuencia.setBackground(cbBaseDatos.getBackground());
		texfPorcentaje.setBackground(Color.WHITE);
		texaRes.setBackground(ROJO);
	}
	
	public void colorErrorSecuencia() {
		Component elementos [] = {texaRes, cbSecuencia};
		ponColor(elementos, Color.GRAY);
	}
	
	public void colorErrorPorcentaje() {
		Component elementos [] = {texaRes, texfPorcentaje};
		ponColor(elementos, Color.GRAY);
	}
	
	public void colorAciertoBusqueda() {
		texaRes.setBackground(VERDE);
	}
	
	public void colorErrorBusqueda() {
		texaRes.setBackground(Color.GRAY);
	}

	public JRadioButton getRbProteinas() {
		return rabProteinas;
	}

	public JRadioButton getRbNucleotidos() {
		return rabNucleotidos;
	}

	public JComboBox<String> getcSecuencia() {
		return cbSecuencia;
	}

	public JTextField getTfPorcentaje() {
		return texfPorcentaje;
	}

	public JButton getBuscar() {
		return butBuscar;
	}

	public JTextArea getTaRes() {
		return texaRes;
	}

	public JComboBox<String> getcBaseDatos() {
		return cbBaseDatos;
	}

	public JComboBox<String> getcDatosId() {
		return cbDatosId;
	}
	
	private static final long serialVersionUID = 1L;
}