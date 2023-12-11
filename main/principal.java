/*
INTEGRANTES
*
Alvarez Macedo Efren
Mercado Hernández José Eduardo
Espinoza Castañeda Yonathan
Espinosa Santana Angel David
*/
package main;

import controlador.ControlJuego;
import controlador.ControlNetFake;
import modelo.server;
import vista.FinalPartida;
import vista.Inicio;
import vista.JuegoBasta;

public class principal {
    public static void main(String[] args) {

        server servidor = new server();
        ControlNetFake ctrlComunicacion = new ControlNetFake();
        ControlJuego ctrlJuego = new ControlJuego();


        JuegoBasta basta = new JuegoBasta();
        Inicio inicial = new Inicio();

        ctrlComunicacion.setServidor(servidor);
        
        ctrlJuego.setCtrlComunicacion(ctrlComunicacion);
        ctrlJuego.setVJuego(basta);
        ctrlJuego.setVInicial(inicial);

        inicial.setControlador(ctrlJuego);
        basta.setControlador(ctrlJuego);

        ctrlJuego.inicia();
        
        //Crea la ventana de finalizacion de partida y la asocia al controlador
        FinalPartida FinPartida = new FinalPartida();
        ctrlJuego.setVFinalizacion(FinPartida);
    }
}
