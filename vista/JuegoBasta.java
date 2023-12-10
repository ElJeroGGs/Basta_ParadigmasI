package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import controlador.ControlJuego;
import modelo.jugador;
import modelo.resultados;

public class JuegoBasta extends JFrame implements ActionListener{
	
	JTextField txtAnimal, txtFF, txtPais, txtNombre, txtColor;
	JTextField PtsAnimal, ptsFF, ptsPais, ptsNombre, ptsColor, ptsTotal, Puntos;
	JTextField txtLetra;
	JButton btnVerLetra;
	JLabel lblUsuario;
	ControlJuego ctrlJuego;
	
	public JuegoBasta() {
		super("Basta!");
		
		JLabel lblTextoPts, lblvacia;
		JPanel panelPrincipal, panelTotal ,panelPalabras, panelEnviar;
		JLabel lblAnimal, lblFF, lblPais, lblNombre, lblColor, lblTotal, lblPuntosPartida;
		JButton btnEnviar;

		panelPrincipal = new JPanel(new GridLayout(5,1));
		
		panelPalabras = new JPanel(new GridLayout(5,4));
		panelTotal = new JPanel(new GridLayout(2,4));
		panelEnviar = new JPanel();
		
		lblUsuario = new JLabel();
		lblUsuario.setHorizontalAlignment(JLabel.CENTER);
		Font boldFontTitulo = new Font(lblUsuario.getFont().getFontName(), Font.BOLD, 25); 
        lblUsuario.setFont(boldFontTitulo);

		lblAnimal = new JLabel("Animal: ");
		lblFF = new JLabel("Flor o Fruto: ");
		lblPais = new JLabel("Pais: ");
		lblNombre = new JLabel("Nombre: ");
		lblColor = new JLabel("Color: ");
		lblTotal = new JLabel("Total Ronda: ");
		lblPuntosPartida = new JLabel("Puntos de la Partida: ");
		
		lblTextoPts = new JLabel("pts");
		
		lblvacia = new JLabel(" ");
		
		txtAnimal = new JTextField();
		txtFF = new JTextField();
		txtPais = new JTextField();
		txtNombre = new JTextField();
		txtColor = new JTextField();
		
		PtsAnimal = new JTextField("0");
		ptsFF = new JTextField("0");
		ptsPais = new JTextField("0");
		ptsNombre = new JTextField("0");
		ptsColor = new JTextField("0");
		ptsTotal = new JTextField("0");
		this.Puntos = new JTextField("0");

		//Centramos los textos de los puntos
		PtsAnimal.setHorizontalAlignment(JTextField.CENTER);
		ptsFF.setHorizontalAlignment(JTextField.CENTER);
		ptsPais.setHorizontalAlignment(JTextField.CENTER);
		ptsNombre.setHorizontalAlignment(JTextField.CENTER);
		ptsColor.setHorizontalAlignment(JTextField.CENTER);
		ptsTotal.setHorizontalAlignment(JTextField.CENTER);
		this.Puntos.setHorizontalAlignment(JTextField.CENTER);

		//Lo referente a la letra
		txtLetra = new JTextField();
		txtLetra.setHorizontalAlignment(JTextField.CENTER);
		txtLetra.setEditable(false);
		txtLetra.setFont(new Font(txtLetra.getFont().getFontName(), Font.BOLD, 25));

		btnEnviar = new JButton("Enviar");
		panelPrincipal.setBorder(new EmptyBorder(10,10,10,10));
		panelTotal.setBorder(new EmptyBorder(20,20,20,20));


		JPanel PanelLetra = new JPanel(new GridLayout(1,2));
		PanelLetra.setBorder(new EmptyBorder(40,10,40,10));
		
			lblTextoPts = new JLabel("pts");

			panelPalabras.add(lblAnimal); 
			panelPalabras.add(txtAnimal);
			panelPalabras.add(PtsAnimal);
			panelPalabras.add(lblTextoPts);
			
			lblTextoPts = new JLabel("pts");

			panelPalabras.add(lblFF); 
			panelPalabras.add(txtFF);
			panelPalabras.add(ptsFF);
			panelPalabras.add(lblTextoPts);

			lblTextoPts = new JLabel("pts");

			panelPalabras.add(lblPais);
			panelPalabras.add(txtPais);
			panelPalabras.add(ptsPais);
			panelPalabras.add(lblTextoPts);

			lblTextoPts = new JLabel("pts");

			panelPalabras.add(lblNombre);
			panelPalabras.add(txtNombre);
			panelPalabras.add(ptsNombre);
			panelPalabras.add(lblTextoPts);

			lblTextoPts = new JLabel("pts");

			panelPalabras.add(lblColor);
			panelPalabras.add(txtColor);
			panelPalabras.add(ptsColor);
			panelPalabras.add(lblTextoPts);

			lblTextoPts = new JLabel("pts");

			
			panelTotal.add(lblvacia);
			panelTotal.add(lblTotal);
			panelTotal.add(ptsTotal);
			panelTotal.add(lblTextoPts);
			lblvacia = new JLabel(" ");
			panelTotal.add(lblvacia);
			panelTotal.add(lblPuntosPartida);
			panelTotal.add(Puntos);
			lblTextoPts = new JLabel("pts");
			panelTotal.add(lblTextoPts);

			
		
			panelEnviar.add(btnEnviar);
            btnEnviar.addActionListener(this);
			btnEnviar.setActionCommand("Enviar");

			btnVerLetra = new JButton("Ver Letra");
			btnVerLetra.addActionListener(this);
			btnVerLetra.setActionCommand("VerLetra");

			PanelLetra.add(btnVerLetra);
			PanelLetra.add(txtLetra);

			PtsAnimal.setEditable(false);
			ptsFF.setEditable(false);
			ptsPais.setEditable(false);
			ptsNombre.setEditable(false);
			ptsColor.setEditable(false);
			ptsTotal.setEditable(false);
			Puntos.setEditable(false);



			panelPrincipal.add(lblUsuario);
			panelPrincipal.add(PanelLetra);
			panelPrincipal.add(panelPalabras);
			panelPrincipal.add(panelTotal);
			panelPrincipal.add(panelEnviar);
			
		this.setContentPane(panelPrincipal);
		this.pack();
		
        setLocationRelativeTo(null);
		
	}

	public void setJugador(String nombre){
		this.lblUsuario.setText(nombre);
	}

    @Override
    public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		
		if(comando.equals("Enviar")){
			txtAnimal.setText("");
			txtFF.setText("");
			txtPais.setText("");
			txtNombre.setText("");
			txtColor.setText("");
			ctrlJuego.ResultadosRonda();
		}
		else if(comando.equals("VerLetra")){
			String letra = ctrlJuego.verLetra();
			this.txtLetra.setText(letra);
		}
		
    }

	public void setControlador(ControlJuego ctrl) {
		this.ctrlJuego = ctrl;
	}
	
	public jugador getJugador() {
		jugador r = new jugador();
		r.setAnimal(this.txtAnimal.getText());
		r.setFlor_Fruto(this.txtFF.getText());
		r.setPais(this.txtPais.getText());
		r.setNombre(this.txtNombre.getText());
		r.setColor(this.txtColor.getText());
		r.setTotalPartida(Integer.parseInt(this.Puntos.getText()));
		return r;
	}

	public void setResultado(resultados data) {

		this.PtsAnimal.setText(String.valueOf(data.getAnimal()));
		this.ptsFF.setText(String.valueOf(data.getFlor_Fruto()));
		this.ptsPais.setText(String.valueOf(data.getPais()));
		this.ptsNombre.setText(String.valueOf(data.getNombre()));
		this.ptsColor.setText(String.valueOf(data.getColor()));
		this.ptsTotal.setText(String.valueOf(data.getTotalRonda()));
		this.Puntos.setText(String.valueOf(data.getTotalPartida()));
	}
}

