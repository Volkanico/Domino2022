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

        turnos();
    }

    public void introduction() {
        System.out.println();
        System.out.println("¡Bienvenido a Domino!");
        System.out.println();
        System.out.println("""
                MODALIDADES:\s
                1 Juego Individual\s
                2 Juego Por Equipos \s
                Elige una opcion""");

        modalidad = sc.nextInt();

        if (modalidad == 1 || modalidad == 2) {
            decisionDeJugadores();
        }

    }

    public void empezarElJuegoConMenosJugadoresQue4 () {
        if (modalidad == 1) {
            imprimirJugadorsIndividuals();
        }
        if (modalidad == 2) {
            imprimirEquips();
        }
    }

    public void decisionDeJugadores() {
        if (modalidad == 1) {
            modalidadIndividual();

        }
        if (modalidad == 2) {
            modalidadPorEquipos();

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
        imprimirJugadorsIndividuals();
    }

    public void modalidadPorEquipos() {
        System.out.println("MODALIDAD SELECCIONADA: POR EQUIPOS");
        System.out.println();
        System.out.println("Miembros del EQUIPO 1");
        anadirJugador1y2Minimos();
        PreguntaMasJugadores_ReinitCounter();
        System.out.println("Miembros del EQUIPO 2");
        opcioMesJugadors();
        imprimirEquips();
    }

    public void turnos() {
        int limitEmpate = 100;

        for (int i = 0; i < limitEmpate; i++) {
            for (int x = 0; x < tablero.getJugadorsQueJuguen().size(); x++) {
                imprimirFichasDeJugador();
                System.out.print("Turno de: " + tablero.getJugadorsQueJuguen().get(x).getNom() + ".   ");
                tirarFicha(tablero.getJugadorsQueJuguen().get(x));
                imprimirFichasDelTablero();
                eventoGanado(tablero.getJugadorsQueJuguen().get(x));
                }
        }
    }



    public Jugador tirarFicha(Jugador jugador) {
        /*ENS FALTA POSAR LA FICHA QUE ENTRA A L'INDEX 0 DE L'ARRAYLIST O AL FINAL DE L'ARRAYLIST, ESTA FET L'IF DEL QUE ENTRA A L'INDEX 0 DE L'ARRAYLIST*/
        int option;
        System.out.println("Quieres tirar ficha o pasar? 1 Para tirar ficha. 2 Para pasar");
        option = sc.nextInt();
        if (option == 1) {
            ponerFichaEnTablero(jugador);
        }
        if (option == 2) {
            return jugador;
        } if ( option != 1 & option != 2){
            System.out.println("Opcion no valida");
            tirarFicha(jugador);
        }
        option = 0;
        return jugador;

    }


    public void ponerFichaEnTablero (Jugador jugador) {

        System.out.println("Pulsa el numero de tu ficha, en el caso de que no tengas");

        index = sc.nextInt() - 1;

        if (jugador.getFichasDelJugador().get(index) != null) {
            comprobacionDeFicha(index,jugador);
        } if (jugador.getFichasDelJugador().get(index) == null){
            System.out.println("No tienes ficha en esa casilla");
            tirarFicha(jugador);
        }
    }


    public void eventoGanado (Jugador jugador) {
        if (jugador.getFichasDelJugador().size() == 0) {
            System.out.println("¡¡¡" + jugador.getNom() + " has ganado!!!");
            System.exit(0);
        }
    }

    public void comprobacionDeFicha (int index, Jugador jugador) {
        int index0deFichasDestapadasDeTablero = 0;
        if (tablero.getFichasDestapadasEnElTablero().size() == 0) { // PARA CUANDO NO HAY FICHA EN EL TABLERO
            tablero.getFichasDestapadasEnElTablero().add(jugador.getFichasDelJugador().get(index));
            jugador.getFichasDelJugador().remove(index);
        } else if ( // PARA LOS IGUALES
                jugador.getFichasDelJugador().get(index).getNum1() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum1() &&
                        jugador.getFichasDelJugador().get(index).getNum2() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum2()) {
            tablero.getFichasDestapadasEnElTablero().add(jugador.getFichasDelJugador().get(index));
            jugador.getFichasDelJugador().remove(index);
        }
        else if ( // PRINCIPIO DE ARRAYLIST
                jugador.getFichasDelJugador().get(index).getNum1() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum1() ||
                        jugador.getFichasDelJugador().get(index).getNum2() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum2() ||
                        jugador.getFichasDelJugador().get(index).getNum1() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum2() ||
                        jugador.getFichasDelJugador().get(index).getNum2() == tablero.getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum1()) {
            tablero.getFichasDestapadasEnElTablero().add(0, jugador.getFichasDelJugador().get(index));
            jugador.getFichasDelJugador().remove(index);


        } else if ( //FINAL DE ARRAYILIST
                jugador.getFichasDelJugador().get(index).getNum1() == tablero.getFichasDestapadasEnElTablero().get(tablero.getFichasDestapadasEnElTablero().size() - 1).getNum1() ||
                        jugador.getFichasDelJugador().get(index).getNum2() == tablero.getFichasDestapadasEnElTablero().get(tablero.getFichasDestapadasEnElTablero().size() - 1).getNum2() ||
                        jugador.getFichasDelJugador().get(index).getNum1() == tablero.getFichasDestapadasEnElTablero().get(tablero.getFichasDestapadasEnElTablero().size() - 1).getNum2() ||
                        jugador.getFichasDelJugador().get(index).getNum2() == tablero.getFichasDestapadasEnElTablero().get(tablero.getFichasDestapadasEnElTablero().size() - 1).getNum1()) {
            tablero.getFichasDestapadasEnElTablero().add(jugador.getFichasDelJugador().get(index));
            jugador.getFichasDelJugador().remove(index);


        } else {
            index = 0;
            System.out.println("No tienes ficha para tirar");
            tirarFicha(jugador);
        }
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
                empezarElJuegoConMenosJugadoresQue4();
                turnos();
            } else {
                System.out.println("Ups! Opcion erronea");
                modalidadIndividual();
            }

        }
        if (decision == 2) {
            tablero.repartirEquipos2Jugadores();
            tablero.repartirTodasLasFichas();
            empezarElJuegoConMenosJugadoresQue4();
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
        System.out.println();
        System.out.println("--------------- TABLERO ---------------------");
        for (int i = 0; i < tablero.getFichasDestapadasEnElTablero().size(); i++) {
            System.out.println(" [" + tablero.getFichasDestapadasEnElTablero().get(i).getNum1() + " | " + tablero.getFichasDestapadasEnElTablero().get(i).getNum2() + "] ");
        }
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    //----------------------------- IMPRIMIR FICHAS DE JUGADORES -----------------------------------------------------------------


    public void imprimirFichasDeJugador() {
        for (int x = 0; x < tablero.getJugadorsQueJuguen().size(); x++) {
            System.out.println();
            System.out.println("Fichas de " + tablero.getJugadorsQueJuguen().get(x).getNom());
            enumeracionDeFichas(x);
            }
    }

    public void enumeracionDeFichas (int index) {
        int counter = 0;
        for (int i = 0; i < tablero.getJugadorsQueJuguen().get(index).getFichasDelJugador().size(); i++){
            counter++;
             System.out.print("----"  + counter + "----");
        }
        System.out.println();
        for (int i = 0; i < tablero.getJugadorsQueJuguen().get(index).getFichasDelJugador().size(); i++){
            System.out.print(" [" + tablero.getJugadorsQueJuguen().get(index).getFichasDelJugador().get(i).getNum1() + " | " + tablero.getJugadorsQueJuguen().get(index).getFichasDelJugador().get(i).getNum2() + "] ");
        }
        System.out.println("   Al jugador: " + tablero.getJugadorsQueJuguen().get(index).getNom() + " le quedan " + tablero.getJugadorsQueJuguen().get(index).getFichasDelJugador().size() + " fichas");
        System.out.println();
        System.out.println("_____________________________________________________________________________________________________________________");


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