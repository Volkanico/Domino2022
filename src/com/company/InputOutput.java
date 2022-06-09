package com.company;

import java.util.Scanner;

public class InputOutput {
    Scanner sc = new Scanner(System.in);
    int decision;
    Tablero tablero = new Tablero();

    public void iniciarJuego() {
        tablero.initFichas();
        tablero.imprimirFichas();
        introduction();
        tablero.repartirTodasLasFichas();
        tablero.juego();
    }

    public void introduction() {
        System.out.println();
        System.out.println();
        System.out.println("¡Bienvenido a Domino!");
        System.out.println();

        System.out.println("¿Desea jugar individualmente o por equipos?");
        System.out.println();
        System.out.println("Pulse 1 para individual");
        System.out.println("Pulse 2 para equipos");

        decision = sc.nextInt();

        if (decision == 1) {
            decisionDeJugadores();
        }
        if (decision == 2) {
            decisionDeJugadores();
            tablero.guardarEquips();
        }
    }

    public void decisionDeJugadores() {
        System.out.println("Jugador 1 introduzca su nombre: ");
        tablero.jugador1.setNom(sc.nextLine());
        tablero.jugador1.setNom(sc.nextLine());
        System.out.println(tablero.jugador1.getNom());
        tablero.jugadorsQueJuguen.add(tablero.jugador1);

        System.out.println("Jugador 2 introduzca su nombre: ");
        tablero.jugador2.setNom(sc.nextLine());
        System.out.println(tablero.jugador2.getNom());
        tablero.jugadorsQueJuguen.add(tablero.jugador2);

        System.out.println("¿Participan mas jugadores?");
        System.out.println("Pulse 1 para SI");
        System.out.println("Pulse 2 para NO");
        decision = sc.nextInt();

        if (decision == 1) {
            System.out.println("Jugador 3 introduzca su nombre: ");
            tablero.jugador3.setNom(sc.nextLine());
            tablero.jugador3.setNom(sc.nextLine());
            System.out.println(tablero.jugador3.getNom());
            tablero.jugadorsQueJuguen.add(tablero.jugador3);

            System.out.println("¿Participan mas jugadores?");
            System.out.println("Pulse 1 para SI");
            System.out.println("Pulse 2 para NO");
            decision = sc.nextInt();
            if (decision == 1) {

                System.out.println("Jugador 4 introduzca su nombre: ");
                tablero.jugador4.setNom(sc.nextLine());
                tablero.jugador4.setNom(sc.nextLine());
                System.out.println(tablero.jugador4.getNom());
                tablero.jugadorsQueJuguen.add(tablero.jugador4);
            }
            if (decision == 2) {
                tablero.juego();
            }
        }
        if (decision == 2) {
            tablero.juego();
        }
    }


}
