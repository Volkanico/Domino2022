package com.company;

import java.util.Scanner;

public class InputOutput {
    Scanner sc = new Scanner(System.in);
    int decision;
    int modalidad;
    Tablero tablero = new Tablero();

    public void iniciarJuego() {
        tablero.initFichas();
        imprimirFichas();
        introduction();
        tablero.repartirTodasLasFichas();
        imprimirTodasLasFichasDeTodosLosJugadores();
        //tablero.juego();
    }

    public void introduction() {
        System.out.println();
        System.out.println("¡Bienvenido a Domino!");
        System.out.println();
        System.out.println("""
                MODALIDADES:\s
                Juego Individual\s
                Juego Por Equipos""");

        modalidad = sc.nextInt();

        if (modalidad == 1) {
            decisionDeJugadores();
            imprimirJugadorsIndividuals();
        }
        if (modalidad == 2) {
            decisionDeJugadores();
            imprimirEquips();
        }
    }


    public void decisionDeJugadores() {
        if (modalidad == 1) {
            modalidadIndividual();
            //imprimirFichasDeJugador();
        }
        if (modalidad == 2) {
            modalidadPorEquipos();
            //imprimirFichasDeJugador();
        }
    }


    public void modalidadIndividual() {
        System.out.println("MODALIDAD SELECCIONADA: INDIVIDUAL");
        System.out.println();
        anadirJugador1y2Minimos();
        PreguntaMasJugadores_ReinitCounter();

        if (decision == 1) {
            System.out.println("Jugador 3 introduzca su nombre: ");
            tablero.anadirJugador3();
            System.out.println(tablero.jugador3.getNom());
            PreguntaMasJugadores_ReinitCounter();
            if (decision == 1) {
                System.out.println("Jugador 4 introduzca su nombre: ");
                tablero.anadirJugador4();
                System.out.println(tablero.jugador4.getNom());
            }
            if (decision == 2) {
                //tablero.juego();
            }
        }
        if (decision == 2) {
            // tablero.juego();
        }
    }

    public void modalidadPorEquipos() {
        System.out.println("MODALIDAD SELECCIONADA: POR EQUIPOS");
        System.out.println();
        System.out.println("Miembros del EQUIPO 1");
        anadirJugador1y2Minimos();
        PreguntaMasJugadores_ReinitCounter();

        if (decision == 1) {
            System.out.println("Miembros del EQUIPO 2");
            System.out.println("Jugador 3 introduzca su nombre: ");
            tablero.anadirJugador3();
            System.out.println(tablero.jugador3.getNom());
            PreguntaMasJugadores_ReinitCounter();

            if (decision == 1) {

                System.out.println("Jugador 4 introduzca su nombre: ");
                tablero.anadirJugador4();
                System.out.println(tablero.jugador4.getNom());
                decision = 0;
            }
            if (decision == 2) {
                tablero.getEquip2().remove(tablero.getJugador4());
                //tablero.juego();
                decision = 0;
            }
        }
        if (decision == 2) {
            tablero.repartirEquipos2Jugadores();
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
        for (int i = 0; i < tablero.getJugadorsQueJuguen().size(); i++) {
            System.out.println(tablero.getJugadorsQueJuguen().get(i).getNom());
        }
        System.out.println("------------------------------");
    }

    public void imprimirFichas() {
        for (int i = 0; i < tablero.getFichasTotales().size(); i++) {
            System.out.print(" [" + tablero.getFichasTotales().get(i).getNum1() + " | " + tablero.getFichasTotales().get(i).getNum2() + "] ");
        }
    }

    public void imprimirFichasDelTablero() {
        for (int i = 0; i < tablero.getFichasDestapadasEnElTablero().size(); i++) {
            System.out.print(" [" + tablero.getFichasDestapadasEnElTablero().get(i).getNum1() + " | " + tablero.getFichasDestapadasEnElTablero().get(i).getNum2() + "] ");
        }
    }

    public void anadirJugador1y2Minimos() {
        System.out.println("Jugador 1 introduzca su nombre: ");
        tablero.anadirJugador1();
        System.out.println(tablero.jugador1.getNom());

        System.out.println("Jugador 2 introduzca su nombre: ");
        tablero.anadirJugador2();
        System.out.println(tablero.jugador2.getNom());
    }

    public void PreguntaMasJugadores_ReinitCounter() {
        System.out.println("¿Participan mas jugadores?");
        System.out.println("Pulse 1 para SI");
        System.out.println("Pulse 2 para NO");

        decision = sc.nextInt();
    }

    public void imprimirTodasLasFichasDeTodosLosJugadores () {
        imprimirFichasDeJugador1();
        imprimirFichasDeJugador2();
        imprimirFichasDeJugador3();
        imprimirFichasDeJugador4();
    }

    public void imprimirFichasDeJugador1() {
        System.out.println();
        System.out.println("Fichas de " + tablero.getJugador1().getNom());
        System.out.println("----1--------2--------3--------4--------5--------6--------7---");
        for (int i = 0; i < tablero.jugador1.getFichasDelJugador().size(); i++) {
            System.out.print(" [" + tablero.jugador1.getFichasDelJugador().get(i).getNum1() + " | " + tablero.jugador1.getFichasDelJugador().get(i).getNum2() + "] ");
        }
        System.out.println();
        System.out.println("______________________________________________________________");
    }
    public void imprimirFichasDeJugador2() {
        System.out.println("Fichas de " + tablero.getJugador2().getNom());
        System.out.println("----1--------2--------3--------4--------5--------6--------7---");
        for (int i = 0; i < tablero.jugador2.getFichasDelJugador().size(); i++) {
            System.out.print(" [" + tablero.jugador2.getFichasDelJugador().get(i).getNum1() + " | " + tablero.jugador2.getFichasDelJugador().get(i).getNum2() + "] ");

        }
        System.out.println();
        System.out.println("______________________________________________________________");
    }
    public void imprimirFichasDeJugador3() {
        System.out.println("----1--------2--------3--------4--------5--------6--------7---");
        System.out.println("Fichas de " + tablero.getJugador3().getNom());
        for (int i = 0; i < tablero.jugador3.getFichasDelJugador().size(); i++) {
            System.out.print(" [" + tablero.jugador3.getFichasDelJugador().get(i).getNum1() + " | " + tablero.jugador3.getFichasDelJugador().get(i).getNum2() + "] ");

        }
        System.out.println();
        System.out.println("______________________________________________________________");
    }
    public void imprimirFichasDeJugador4() {
        System.out.println("----1--------2--------3--------4--------5--------6--------7---");
        System.out.println("Fichas de " + tablero.getJugador4().getNom());
        for (int i = 0; i < tablero.jugador4.getFichasDelJugador().size(); i++) {
            System.out.print(" [" + tablero.jugador4.getFichasDelJugador().get(i).getNum1() + " | " + tablero.jugador4.getFichasDelJugador().get(i).getNum2() + "] ");
        }
        System.out.println();
        System.out.println("______________________________________________________________");
    }


}