package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {
    Scanner sc = new Scanner(System.in);

    int decision;
    String numJugadorParsed;
    String nomJugador;

    Jugador jugador1 = new Jugador("Jugador 1");
    Jugador jugador2 = new Jugador("Jugador 2");
    Jugador jugador3 = new Jugador("Jugador 3");
    Jugador jugador4 = new Jugador("Jugador 4");


    Jugador[] jugadorsDisponibles;
    Jugador[] jugadorsQueJuguen;

    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();

    public void guardarJugadors () {
        for (int i = 0; i < jugadors.size(); i++) {

           // numJugadorParsed = String.valueOf(numJugador);
            nomJugador = "Jugador" + numJugadorParsed;


            //jugadors.add();
        }
    }

    public void introduction () {
        System.out.println("¡Bienvenido a Domino!");

        System.out.println("¿Desea jugar individualmente o por equipos?");
        System.out.println("Pulse 1 para individual");
        System.out.println("Pulse 2 para equipos");
        if (decision == 1) {
            decisionDeJugadores();
        }
        if (decision == 2) {
            decisionDeJugadores();
        }



    }



        public void decisionDeJugadores () {
            System.out.println("Jugador 1 introduzca su nombre: ");
            jugador1.setNom(sc.nextLine());
            System.out.println(jugador1.getNom());

            System.out.println("Jugador 2 introduzca su nombre: ");
            jugador2.setNom(sc.nextLine());
            System.out.println(jugador2.getNom());

            System.out.println("¿Participan mas jugadores?");
            System.out.println("Pulse 1 para SI");
            System.out.println("Pulse 2 para NO");
            decision = sc.nextInt();
            if (decision == 1) {
                System.out.println("Jugador 3 introduzca su nombre: ");
                jugador3.setNom(sc.nextLine());
                System.out.println(jugador3.getNom());

                System.out.println("¿Participan mas jugadores?");
                System.out.println("Pulse 1 para SI");
                System.out.println("Pulse 2 para NO");
                decision = sc.nextInt();
                if (decision == 1) {

                    System.out.println("Jugador 4 introduzca su nombre: ");
                    jugador4.setNom(sc.nextLine());
                    System.out.println(jugador4.getNom());
                }
                if (decision == 2) {
                    //Siguiente metodo
                }
            }

            if (decision == 2) {
                //Siguiente metodo
            }
        }

}
