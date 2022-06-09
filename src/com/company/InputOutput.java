package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {
    Scanner sc = new Scanner(System.in);

    int decision;

    String numJugadorParsed;
    String nomJugador;

    Tablero tablero = new Tablero();



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
        decision = sc.nextInt();
        if (decision == 1) {
            decisionDeJugadores();
            tablero.guardarEquips();
        }
        if (decision == 2) {
            decisionDeJugadores();
        }
    }

    public void guardarEquips () {
        tablero.equip1.add(tablero.getJugador1());
        tablero.equip1.add(tablero.jugador2);
        tablero.equip2.add(tablero.jugador3);
        tablero.equip2.add(tablero.jugador4);
        for(int i = 0; i < tablero.equip1.size(); i++) {
            System.out.println(tablero.getEquip1().get(i).getNom());
        }
        for(int i = 0; i < tablero.equip2.size(); i++) {
            System.out.print(tablero.getEquip2());
        }
    }

        public void decisionDeJugadores () {
            System.out.println("Jugador 1 introduzca su nombre: ");
            tablero.jugador1.setNom(sc.nextLine());
            tablero.jugador1.setNom(sc.nextLine());
            System.out.println(tablero.jugador1.getNom());

            System.out.println("Jugador 2 introduzca su nombre: ");
            tablero.jugador2.setNom(sc.nextLine());
            System.out.println(tablero.jugador2.getNom());

            System.out.println("¿Participan mas jugadores?");
            System.out.println("Pulse 1 para SI");
            System.out.println("Pulse 2 para NO");
            decision = sc.nextInt();
            if (decision == 1) {
                System.out.println("Jugador 3 introduzca su nombre: ");
                tablero.jugador3.setNom(sc.nextLine());
                tablero.jugador3.setNom(sc.nextLine());
                System.out.println(tablero.jugador3.getNom());

                System.out.println("¿Participan mas jugadores?");
                System.out.println("Pulse 1 para SI");
                System.out.println("Pulse 2 para NO");
                decision = sc.nextInt();
                if (decision == 1) {

                    System.out.println("Jugador 4 introduzca su nombre: ");
                    tablero.jugador4.setNom(sc.nextLine());
                    tablero.jugador4.setNom(sc.nextLine());
                    System.out.println(tablero.jugador4.getNom());
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
