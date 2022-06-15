package com.company;

import java.util.Scanner;

public class InputOutput {
    Scanner sc = new Scanner(System.in);
    int decision;
    Tablero tablero = new Tablero();

    public void iniciarJuego() {
        tablero.initFichas();
        imprimirFichas();
        introduction();
        tablero.repartirTodasLasFichas();
        tablero.juego();
    }

    public void introduction() {
        System.out.println();
        System.out.println();
        System.out.println("¡Bienvenido a Domino!");
        System.out.println();

        System.out.println("""
                MODALIDADES:\s
                Juego Individual\s
                Juego Por Equipos""");

        decision = sc.nextInt();

        if (decision == 1) {
            decisionDeJugadores();
            imprimirJugadorsIndividuals();
        }
        if (decision == 2) {
            decisionDeJugadores();
            imprimirEquips();
        }
    }


    public void decisionDeJugadores() {
        System.out.println("Jugador 1 introduzca su nombre: ");
        tablero.anadirJugador1JuegoIndividual();
        System.out.println(tablero.jugador1.getNom());

        System.out.println("Jugador 2 introduzca su nombre: ");
        tablero.anadirJugador2JuegoIndividual();
        System.out.println(tablero.jugador2.getNom());

        System.out.println("¿Participan mas jugadores?");
        System.out.println("Pulse 1 para SI");
        System.out.println("Pulse 2 para NO");
        decision = sc.nextInt();
        if (decision == 2) {
            tablero.juego();
        }

        if (decision == 1) {

        }

        if (decision == 1) {
            System.out.println("Jugador 3 introduzca su nombre: ");
            tablero.anadirJugador3JuegoIndividual();
            System.out.println(tablero.jugador3.getNom());


            System.out.println("¿Participan mas jugadores?");
            System.out.println("Pulse 1 para SI");
            System.out.println("Pulse 2 para NO");
            decision = sc.nextInt();
            if (decision == 1) {

                System.out.println("Jugador 4 introduzca su nombre: ");
                tablero.anadirJugador4JuegoIndividual();
                System.out.println(tablero.jugador4.getNom());
            }
            if (decision == 2) {
                tablero.juego();
            }
        }
        if (decision == 2) {
            tablero.juego();
        }
    }

    public void imprimirEquips() {
        System.out.println("-----EQUIP 1-----");
        for (int i = 0; i < tablero.getEquip1().size(); i++) {
            System.out.println(tablero.getEquip1().get(i).getNom());
        }
        System.out.println("-----------------");
        System.out.println("-----EQUIP 2-----");
        for (int i = 0; i < tablero.getEquip2().size(); i++) {
            System.out.println(tablero.getEquip2().get(i).getNom());
        }
        System.out.println("-----------------");
    }

    public void imprimirJugadorsIndividuals() {
        System.out.println("-----JUGADORS INDIVIDUALS-----");
        for (int i = 0; i < tablero.getJugadorsQueJuguenIndividual().size(); i++) {
            System.out.println(tablero.getJugadorsQueJuguenIndividual().get(i).getNom());
        }
        System.out.println("------------------------------");
    }

    public void imprimirFichas() {
        for (int i = 0; i < tablero.getFichasTotales().size(); i++) {
            System.out.print(" [" + tablero.getFichasTotales().get(i).getNum1() + " | " + tablero.getFichasTotales().get(i).getNum2() + "] ");
        }
    }
}
