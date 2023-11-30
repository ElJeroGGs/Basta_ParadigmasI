package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame implements ActionListener{

    JTextField Usuario;
    public Inicio() {
        // Configurar la ventana
        setTitle("Bienvenido al juego Basta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Crear el panel principal con GridLayout
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // Crear la etiqueta "Bienvenido al juego Basta"
        JLabel labelBienvenido = new JLabel("Bienvenido al juego Basta");
        labelBienvenido.setFont(new Font("Arial", Font.BOLD, 20));
        labelBienvenido.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelBienvenido);

        // Crear la etiqueta "Usuario"
        JLabel labelUsuario = new JLabel("Introduce tu usuario:");
        //Centrar la etiqueta
        labelUsuario.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelUsuario);

        // Crear el campo de texto para el usuario
        this.Usuario = new JTextField();
        panel.add(this.Usuario);

        // Crear el botón "Jugar"
        JButton botonJugar = new JButton("Jugar");
        botonJugar.addActionListener(this);
        panel.add(botonJugar);

        // Agregar el panel al contenido de la ventana
        getContentPane().add(panel);

        // Mostrar la ventana
        setVisible(true);

        //Ponerle margen a la ventana
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Inicio());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(Usuario.getText());
    
    }
}
