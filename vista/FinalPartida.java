/*
INTEGRANTES
*
Alvarez Macedo Efren
Mercado Hernández José Eduardo
Espinoza Castañeda Yonathan
Espinosa Santana Angel David
*/
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
    private JLabel lblTextoPuntos;

    public FinalPartida( ) {
        super("Basta! - Final de partida");

        JPanel PanelPrincipal;

        lblUsuario = new JLabel("Predeterminado");
        this.lblTextoPuntos = new JLabel("Puntos en total");
        JLabel despedida = new JLabel("Gracias por jugar!");

        //Centramos los textos
        lblUsuario.setHorizontalAlignment(JLabel.CENTER);
        this.lblTextoPuntos.setHorizontalAlignment(JLabel.CENTER);
        despedida.setHorizontalAlignment(JLabel.CENTER);

        //Le damos formatos a los textos
        lblUsuario.setFont(new java.awt.Font("Arial", 1, 18));
        this.lblTextoPuntos.setFont(new java.awt.Font("Arial", 1, 18));
        despedida.setFont(new java.awt.Font("Arial", 1, 18));

        PanelPrincipal = new JPanel();
        PanelPrincipal.setBorder(new EmptyBorder(40, 70, 40, 70));
        PanelPrincipal.setLayout(new GridLayout(3,1));
        
        PanelPrincipal.add(lblUsuario);
        PanelPrincipal.add(this.lblTextoPuntos);
        PanelPrincipal.add(despedida);

        this.add(PanelPrincipal);

        this.setLocationRelativeTo(null);
        this.pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setPlayer(jugador player) {
        this.player = player;
        lblTextoPuntos.setText("Obtuviste "+player.getTotalPartida()+" puntos en total");
        this.lblUsuario.setText(player.getUsuario());
        this.pack();
    }

   

}
