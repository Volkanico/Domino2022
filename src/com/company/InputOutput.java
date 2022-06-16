package com.company;

import java.util.Scanner;

public class InputOutput {
    Scanner sc = new Scanner(System.in);
    int decision;
    int modalidad;
    int index = 0;
    Tablero tablero = new Tablero();

    public void iniciarJuego() {
        tablero.initFichas();
        imprimirFichas();
        introduction();
        tablero.repartirTodasLasFichas();
        imprimirTodasLasFichasDeTodosLosJugadores();
        turnos();
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
        } else {
            System.out.println("Ups! Opcion erronea");
            decisionDeJugadores();
        }
    }

    public void modalidadIndividual() {
        System.out.println("MODALIDAD SELECCIONADA: INDIVIDUAL");
        System.out.println();
        anadirJugador1y2Minimos();
        PreguntaMasJugadores_ReinitCounter();
        opcioMesJugadors();
    }

    public void modalidadPorEquipos() {
        System.out.println("MODALIDAD SELECCIONADA: POR EQUIPOS");
        System.out.println();
        System.out.println("Miembros del EQUIPO 1");
        anadirJugador1y2Minimos();
        PreguntaMasJugadores_ReinitCounter();
        System.out.println("Miembros del EQUIPO 2");
        opcioMesJugadors();
    }

    public void turnos() {
        int limitEmpate = 100;

        for (int i = 0; i < limitEmpate; i++) {
            for (int x = 0; x < tablero.getJugadorsQueJuguen().size(); x++) {
                System.out.println("Turno de: " + tablero.getJugadorsQueJuguen().get(x).getNom());
                tirarFicha(tablero.getJugadorsQueJuguen().get(x));
                imprimirFichasDelTablero();
            }
        }
    }

    public Jugador tirarFicha(Jugador jugador) {
        /*ENS FALTA POSAR LA FICHA QUE ENTRA A L'INDEX 0 DE L'ARRAYLIST O AL FINAL DE L'ARRAYLIST, ESTA FET L'IF DEL QUE ENTRA A L'INDEX 0 DE L'ARRAYLIST*/
        int index0deFichasDestapadasDeTablero = 0;
        index = sc.nextInt();

        if (index == 1 || index == 2 || index == 3 || index == 4 ||
                index == 5 || index == 6 || index == 7) {
            if (tablero.getFichasDestapadasEnElTablero().size() == 0) {
                tablero.getFichasDestapadasEnElTablero().add(jugador.getFichasDelJugador().get(index));
            }

            if (
                    jugador.getFichasDelJugador().get(index).getNum1() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum1() ||
                    jugador.getFichasDelJugador().get(index).getNum2() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum2() ||
                    jugador.getFichasDelJugador().get(index).getNum1() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum2() ||
                    jugador.getFichasDelJugador().get(index).getNum2() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum1()) {
                tablero.getFichasDestapadasEnElTablero().add(0, jugador.getFichasDelJugador().get(index));
                jugador.getFichasDelJugador().remove(index);


            }
            if (tablero.getFichasDestapadasEnElTablero().size() == 1 || tablero.getFichasDestapadasEnElTablero().size() == 0 ||
                    jugador.getFichasDelJugador().get(index).getNum1() == tablero.getFichasDestapadasEnElTablero().get(tablero.getFichasDestapadasEnElTablero().size() - 1).getNum1() ||
                    jugador.getFichasDelJugador().get(index).getNum2() == tablero.getFichasDestapadasEnElTablero().get(tablero.getFichasDestapadasEnElTablero().size() - 1).getNum2() ||
                    jugador.getFichasDelJugador().get(index).getNum1() == tablero.getFichasDestapadasEnElTablero().get(tablero.getFichasDestapadasEnElTablero().size() - 1).getNum2() ||
                    jugador.getFichasDelJugador().get(index).getNum2() == tablero.getFichasDestapadasEnElTablero().get(tablero.getFichasDestapadasEnElTablero().size() - 1).getNum1()) {
                tablero.getFichasDestapadasEnElTablero().lastIndexOf(jugador.getFichasDelJugador().get(index));
                jugador.getFichasDelJugador().remove(index);


            } else {
                index = 0;
                System.out.println("No tienes ficha para tirar");
            }
        } else {
            System.out.println("No tienes ficha en esa casilla");
        }
        index = 0;
        return jugador;

    }

    //----------------------------- METODOS DE SOPORTE (REFACTORING) -------------------------------------------------------------

    public void opcioMesJugadors() {
        if (decision == 1) {
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
                tablero.repartirTodasLasFichas();
                decision = 0;
                imprimirTodasLasFichasDeTodosLosJugadores();
                turnos();
            } else {
                System.out.println("Ups! Opcion erronea");
                modalidadPorEquipos();
            }

        }
        if (decision == 2) {
            tablero.repartirEquipos2Jugadores();
            tablero.repartirTodasLasFichas();
            imprimirTodasLasFichasDeTodosLosJugadores();
            turnos();
        } else {
            System.out.println("Ups! Opcion erronea");
            modalidadPorEquipos();
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


    //----------------------------- IMPRIMIR FICHAS TOTALES Y DE TABLERO ---------------------------------------------------------
    public void imprimirFichas() {
        for (int i = 0; i < tablero.getFichasTotales().size(); i++) {
            System.out.print(" [" + tablero.getFichasTotales().get(i).getNum1() + " | " + tablero.getFichasTotales().get(i).getNum2() + "] ");
        }
    }

    public void imprimirFichasDelTablero() {
        for (int i = 0; i < tablero.getFichasDestapadasEnElTablero().size(); i++) {
            System.out.println(" [" + tablero.getFichasDestapadasEnElTablero().get(i).getNum1() + " | " + tablero.getFichasDestapadasEnElTablero().get(i).getNum2() + "] ");
        }
    }

    //----------------------------- IMPRIMIR FICHAS DE JUGADORES -----------------------------------------------------------------

    public void imprimirTodasLasFichasDeTodosLosJugadores() {
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

    //----------------------------- IMPRIMIR EQUIPOS O JUGADORES INDIVIDUALES ----------------------------------------------------


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


}