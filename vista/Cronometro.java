/*
INTEGRANTES
*
Alvarez Macedo Efren
Mercado Hernández José Eduardo
Espinoza Castañeda Yonathan
Espinosa Santana Angel David
*/
package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;

public class Cronometro extends JPanel{
    private int Tiempo;
    private JLabel lblTiempo;
    private Timer timer;
    private JuegoBasta vJuego;
    private JLabel lblTxt;

    public Cronometro(int Tiempo){

        lblTxt = new JLabel("Tiempo restante:");
        lblTxt.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridLayout(2,1));
        this.Tiempo = Tiempo;
        String tiempoString = String.valueOf("00:"+Tiempo);
        lblTiempo = new JLabel(tiempoString);
        
        // Establecer estilo de fuente
        Font font = new Font("Arial", Font.BOLD, 36);
        lblTiempo.setFont(font);
        
        this.add(lblTxt);
        this.add(lblTiempo);
        lblTiempo.setHorizontalAlignment(JLabel.CENTER);
        lblTiempo.setVerticalAlignment(JLabel.CENTER);
        Comienza();

    }

    public void Actualiza(){
        this.Tiempo--;
        String tiempoString = String.format("%02d", this.Tiempo);
        lblTiempo.setText("00:" + tiempoString);
    }

    public void Comienza() {

        timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Actualiza();
                if (Tiempo == 0) {
                    ((Timer) e.getSource()).stop();
                }
            }


        });

    }

    public void Stop(){
            timer.stop();
        
    }

    

    public void Start(){
        timer.start();
    }

    public void Reset(int Tiempo) {
        timer.stop();
        this.Tiempo = Tiempo;
        Actualiza();
        timer.start();
    }

    public int getTime() {
        return this.Tiempo;
    }
}

