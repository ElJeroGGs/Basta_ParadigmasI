package vista;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.jugador;

public class FinalPartida extends JFrame {

    private jugador player;
    private JLabel lblUsuario;
    private JLabel lblPuntos;

    public FinalPartida( ) {
        super("Basta! - Final de partida");

        JPanel PanelPrincipal;

        lblUsuario = new JLabel("Predeterminado");
        JLabel lblTextoPts;
        lblPuntos = new JLabel("¨Predefinido");
        lblTextoPts = new JLabel("Puntos en total");
        JLabel despedida = new JLabel("Gracias por jugar!");

        //Centramos los textos
        lblUsuario.setHorizontalAlignment(JLabel.CENTER);
        lblPuntos.setHorizontalAlignment(JLabel.CENTER);
        lblTextoPts.setHorizontalAlignment(JLabel.CENTER);
        despedida.setHorizontalAlignment(JLabel.CENTER);

        //Le damos formatos a los textos
        lblUsuario.setFont(new java.awt.Font("Arial", 1, 18));
        lblPuntos.setFont(new java.awt.Font("Arial", 1, 18));
        lblTextoPts.setFont(new java.awt.Font("Arial", 1, 18));
        despedida.setFont(new java.awt.Font("Arial", 1, 18));

        PanelPrincipal = new JPanel();
        PanelPrincipal.setBorder(new EmptyBorder(40, 70, 40, 70));
        PanelPrincipal.setLayout(new GridLayout(4,1));
        
        PanelPrincipal.add(lblUsuario);
        PanelPrincipal.add(lblPuntos);
        PanelPrincipal.add(lblTextoPts);
        PanelPrincipal.add(despedida);

        this.add(PanelPrincipal);

        this.setLocationRelativeTo(null);
        this.pack();

    }

    public void setPlayer(jugador player) {
        this.player = player;
        this.lblPuntos.setText(String.valueOf(player.getTotalPartida()));
        this.lblUsuario.setText(player.getUsuario());
    }

   

}
