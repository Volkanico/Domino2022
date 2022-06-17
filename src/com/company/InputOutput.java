package com.company;

import java.util.Scanner;

public class InputOutput {
    Scanner sc = new Scanner(System.in);
    int decision;
    int decisionJugadores;
    int modalidad;
    int index = 0;
    int tipoDeDomino;
    Tablero tablero = new Tablero();


    public void elegirDomino () {
        System.out.println("Bienvenido a Dominos de Volkan");
        System.out.println("""
                Elija una de las opciones:\s
                1. Domino Internacional Sin Robo\s
                2. Domino Internacional Con Robo\s""");
        tipoDeDomino = sc.nextInt();
        opcionDeDominos();

    }

    public void opcionDeDominos () {

        if (tipoDeDomino == 1) {
            iniciarJuegoInternacionalSinRobo();
        }
        if (tipoDeDomino == 2) {
            iniciarJuegoInternacionalConRobo();
        }
        else {
            System.out.println("Opcion no valida");
            opcionDeDominos();
        }
    }

    public void iniciarJuegoInternacionalSinRobo() {
        tablero.initFichas();
        imprimirFichas();
        introduction();
        tablero.repartirTodasLasFichasInternacionalSinRobo();
        turnosInternacionalSinRobo();
    }
    public void iniciarJuegoInternacionalConRobo() {
        tablero.initFichas();
        imprimirFichas();
        introduction();
        tablero.repartirTodasLasFichasInternacionalConRobo();
        turnosInternacionalConRobo();
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

        }
        if (modalidad != 1 && modalidad != 2) {
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

    public void turnosInternacionalSinRobo() {
        int limitEmpate = 100;

        for (int i = 0; i < limitEmpate; i++) {
            for (int x = 0; x < tablero.getTotsElsJugadors().size(); x++) {
                imprimirFichasDeJugador();
                System.out.print("Turno de: " + tablero.getTotsElsJugadors().get(x).getNom() + ".   ");
                tirarFichaInternacionalSinRobo(tablero.getTotsElsJugadors().get(x));
                imprimirFichasDelTablero();
                tablero.eventoGanado(tablero.getTotsElsJugadors().get(x));
                }
        }
    }

    public void turnosInternacionalConRobo() {
        int limitEmpate = 100;

        for (int i = 0; i < limitEmpate; i++) {
            for (int x = 0; x < tablero.getTotsElsJugadors().size(); x++) {
                imprimirFichasDeJugador();
                System.out.print("Turno de: " + tablero.getTotsElsJugadors().get(x).getNom() + ".   ");
                tirarFichaInternacionalConRobo(tablero.getTotsElsJugadors().get(x));
                imprimirFichasDelTablero();
                tablero.eventoGanado(tablero.getTotsElsJugadors().get(x));
            }
        }
    }

    public Jugador tirarFichaInternacionalSinRobo(Jugador jugador) {
        /*ENS FALTA POSAR LA FICHA QUE ENTRA A L'INDEX 0 DE L'ARRAYLIST O AL FINAL DE L'ARRAYLIST, ESTA FET L'IF DEL QUE ENTRA A L'INDEX 0 DE L'ARRAYLIST*/
        int option;
        System.out.println("Quieres tirar ficha o pasar? 1 Para tirar ficha. 2 Para pasar");
        option = sc.nextInt();
        if (option == 1) {
            ponerFichaEnTablero(jugador);
        }
        if (option == 2) {
            return jugador;
        } if (option != 1){
            System.out.println("Opcion no valida");
            tirarFichaInternacionalSinRobo(jugador);
        }
        option = 0;
        return jugador;

    }


    public Jugador tirarFichaInternacionalConRobo(Jugador jugador) {
        /*ENS FALTA POSAR LA FICHA QUE ENTRA A L'INDEX 0 DE L'ARRAYLIST O AL FINAL DE L'ARRAYLIST, ESTA FET L'IF DEL QUE ENTRA A L'INDEX 0 DE L'ARRAYLIST*/
        int option = 0;
        System.out.println("Quieres tirar ficha o pasar? 1 Para tirar ficha. 2 Para pasar. 3 Pedir ficha");
        option = sc.nextInt();
        if (option == 1) {
            ponerFichaEnTablero(jugador);
        }
        if (option == 2) {
            return jugador;
        }
        if (option == 3) {
            tablero.pedirFicha(jugador);
            imprimirFichasDeJugador();
        }
        if (option != 1 && option != 3){
            System.out.println("Opcion no valida");
            tirarFichaInternacionalConRobo(jugador);
        }
        option = 0;
        return jugador;

    }

    public void ponerFichaEnTablero (Jugador jugador) {

        System.out.println("Pulsa el numero de tu ficha, en el caso de que no tengas");

        index = sc.nextInt() - 1;

        if (jugador.getFichasDelJugador().get(index) == null){
            System.out.println("No tienes ficha en esa casilla");
            tirarFichaDependiendoDelDomino(jugador);
        } else {
            tablero.comprobacionDeFicha(index,jugador);
        }

        index = 0;
    }

    //----------------------------- METODOS DE SOPORTE (REFACTORING) -------------------------------------------------------------

    public void opcioMesJugadors() {
        if (decision == 1) {
            System.out.println("Jugador 3 introduzca su nombre: ");
            tablero.anadirJugador3();
            System.out.println(tablero.jugador3.getNom());
            PreguntaMasJugadores_ReinitCounter();
            decisionJugadores = sc.nextInt();
            if (decisionJugadores == 1) {

                System.out.println("Jugador 4 introduzca su nombre: ");
                tablero.anadirJugador4();
                System.out.println(tablero.jugador4.getNom());
                decisionJugadores = 0;
            }
            if (decisionJugadores == 2) {
                tablero.getEquip2().remove(tablero.getJugador4());
                repartirFichasDependiendoDelTipoDeDomino();
                decisionJugadores = 0;
                empezarElJuegoConMenosJugadoresQue4();


            } else {
                System.out.println("Ups! Opcion erronea");
                modalidadIndividual();
            }
        }
        if (decision == 2) {
            tablero.repartirEquipos2Jugadores();
            repartirFichasDependiendoDelTipoDeDomino();
            empezarElJuegoConMenosJugadoresQue4();


        } else {
            System.out.println("Ups! Opcion erronea");
            modalidadPorEquipos();
        }

    }

    public void repartirFichasDependiendoDelTipoDeDomino () {
        if (tipoDeDomino == 1) {
            tablero.repartirTodasLasFichasInternacionalSinRobo();
        }
        if (tipoDeDomino == 2) {
            tablero.repartirTodasLasFichasInternacionalConRobo();
        }
    }
    public void tirarFichaDependiendoDelDomino (Jugador jugador) {
        if (tipoDeDomino == 1) {
            tirarFichaInternacionalSinRobo(jugador);
        }
        if (tipoDeDomino == 2) {
            tirarFichaInternacionalConRobo(jugador);
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
        for (int x = 0; x < tablero.getTotsElsJugadors().size(); x++) {
            System.out.println();
            System.out.println("Fichas de " + tablero.getTotsElsJugadors().get(x).getNom());
            enumeracionDeFichas(x);
            }
    }

    public void enumeracionDeFichas (int index) {
        int counter = 0;
        for (int i = 0; i < tablero.getTotsElsJugadors().get(index).getFichasDelJugador().size(); i++){
            counter++;
             System.out.print("----"  + counter + "----");
        }
        System.out.println();
        for (int i = 0; i < tablero.getTotsElsJugadors().get(index).getFichasDelJugador().size(); i++){
            System.out.print(" [" + tablero.getTotsElsJugadors().get(index).getFichasDelJugador().get(i).getNum1() + " | " + tablero.getTotsElsJugadors().get(index).getFichasDelJugador().get(i).getNum2() + "] ");
        }
        System.out.println("   Al jugador: " + tablero.getTotsElsJugadors().get(index).getNom() + " le quedan " + tablero.getTotsElsJugadors().get(index).getFichasDelJugador().size() + " fichas");
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
        for (int i = 0; i < tablero.getTotsElsJugadors().size(); i++) {
            System.out.println(tablero.getTotsElsJugadors().get(i).getNom());
        }
        System.out.println("------------------------------");
    }


}