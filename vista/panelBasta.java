package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class panelBasta extends JFrame {
	
	JTextField txtAnimal, txtFF, txtPais, txtNombre, txtColor;
	JTextField PtsAnimal, ptsFF, ptsPais, ptsNombre, ptsColor, ptsTotal, Puntos;
	
	public panelBasta() {
		super("Basta!");
		
		JLabel lblTextoPts1, lblTextoPts2, lblTextoPts3, lblTextoPts4, lblTextoPts5, lblTextoPts6,lblvacia, lblvacia2;
		JPanel panelPrincipal, panelTotal ,panelPalabras, panelEnviar;
		JLabel lblAnimal, lblFF, lblPais, lblNombre, lblColor, lblTotal, lblPuntos;
		JButton btnEnviar;
		
		panelPrincipal = new JPanel(new GridLayout(3,1));
		
		panelPalabras = new JPanel(new GridLayout(5,4));
		panelTotal = new JPanel(new GridLayout(1,4));
		panelEnviar = new JPanel();
		
		
		lblAnimal = new JLabel("Animal: ");
		lblFF = new JLabel("Flor o Fruto: ");
		lblPais = new JLabel("Pais: ");
		lblNombre = new JLabel("Nombre: ");
		lblColor = new JLabel("Color: ");
		lblTotal = new JLabel("Total: ");
		lblPuntos = new JLabel("Puntos: ");
		
		lblTextoPts1 = new JLabel("pts");
		lblTextoPts2 = new JLabel("pts");
		lblTextoPts3 = new JLabel("pts");
		lblTextoPts4 = new JLabel("pts");
		lblTextoPts5 = new JLabel("pts");
		lblTextoPts5 = new JLabel("pts");
		lblTextoPts6 = new JLabel("pts");
		
		lblvacia = new JLabel(" ");
		lblvacia2 = new JLabel(" ");
		
		txtAnimal = new JTextField();
		txtFF = new JTextField();
		txtPais = new JTextField();
		txtNombre = new JTextField();
		txtColor = new JTextField();
		
		PtsAnimal = new JTextField();
		ptsFF = new JTextField();
		ptsPais = new JTextField();
		ptsNombre = new JTextField();
		ptsColor = new JTextField();
		ptsTotal = new JTextField();
		Puntos = new JTextField();
		
		btnEnviar = new JButton("Enviar");
		panelPrincipal.setBorder(new EmptyBorder(10,10,10,10));
		panelTotal.setBorder(new EmptyBorder(20,20,20,20));
		
		panelPrincipal.add(panelPalabras);
		
			panelPalabras.add(lblAnimal); 
			panelPalabras.add(txtAnimal);
			panelPalabras.add(PtsAnimal);
			panelPalabras.add(lblTextoPts1);
			
			panelPalabras.add(lblFF); 
			panelPalabras.add(txtFF);
			panelPalabras.add(ptsFF);
			panelPalabras.add(lblTextoPts2);
			
			panelPalabras.add(lblPais);
			panelPalabras.add(txtPais);
			panelPalabras.add(ptsPais);
			panelPalabras.add(lblTextoPts3);
			
			panelPalabras.add(lblNombre);
			panelPalabras.add(txtNombre);
			panelPalabras.add(ptsNombre);
			panelPalabras.add(lblTextoPts4);
			
			panelPalabras.add(lblColor);
			panelPalabras.add(txtColor);
			panelPalabras.add(ptsColor);
			panelPalabras.add(lblTextoPts5);
		
		panelPrincipal.add(panelTotal);
			
			panelTotal.add(lblvacia);
			panelTotal.add(lblTotal);
			panelTotal.add(ptsTotal);
			panelTotal.add(lblTextoPts6);

		
		panelPrincipal.add(panelEnviar);
		
			panelEnviar.add(btnEnviar);
			
		this.getContentPane().add(panelPrincipal);
		this.pack();
		
		
	}
	
}

