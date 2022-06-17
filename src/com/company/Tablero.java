package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Tablero {
    Scanner nameReader = new Scanner(System.in);

    int ganado1perdido2;


    Jugador jugador1 = new Jugador("Jugador 1");
    Jugador jugador2 = new Jugador("Jugador 2");
    Jugador jugador3 = new Jugador("Jugador 3");
    Jugador jugador4 = new Jugador("Jugador 4");

    ArrayList<Jugador> equip1 = new ArrayList<>();
    ArrayList<Jugador> equip2 = new ArrayList<>();
    ArrayList<Jugador> totsElsJugadors = new ArrayList<>();

    private ArrayList<Ficha> fichasTotales = new ArrayList<>();
    private ArrayList<Ficha> fichasDestapadasEnElTablero = new ArrayList<>();

    public void initFichas() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                fichasTotales.add(new Ficha(i, j));
            }
        }

    }

    public void anadirJugador1() {
        getTotsElsJugadors().add(jugador1);
        getEquip1().add(jugador1);
        getJugador1().setNom(nameReader.nextLine());
    }

    public void anadirJugador2() {
        getTotsElsJugadors().add(jugador2);
        getEquip1().add(jugador2);
        getJugador2().setNom(nameReader.nextLine());
    }

    public void anadirJugador3() {
        getTotsElsJugadors().add(jugador3);
        getEquip2().add(jugador3);
        getJugador3().setNom(nameReader.nextLine());
    }

    public void anadirJugador4() {
        getTotsElsJugadors().add(jugador4);
        getEquip2().add(jugador4);
        getJugador4().setNom(nameReader.nextLine());
    }

    public void repartirTodasLasFichasInternacionalSinRobo() {

        for (int i = 0; i < getFichasTotales().size(); i++) {
            for (int x = 0; x < getTotsElsJugadors().size(); x++) {

                int index = (int) (Math.random() * getFichasTotales().size());
                getTotsElsJugadors().get(x).getFichasDelJugador().add(getFichasTotales().get(index));
                getFichasTotales().remove(index);
            }
            i = 0;
        }
    }

    public void repartirTodasLasFichasInternacionalConRobo() {
        int counterFichasMaximasIniciales = getTotsElsJugadors().size() - 1;


                for (int l = 0; l < getTotsElsJugadors().size(); l++) {
                    for (int x = 0; x < 7; x++) {
                    int index = (int) (Math.random() * getFichasTotales().size());
                    getTotsElsJugadors().get(l).getFichasDelJugador().add(getFichasTotales().get(index));
                    getFichasTotales().remove(index);

                }
            }


    }

    public void pedirFicha (Jugador jugador) {
        int index = (int) (Math.random() * getFichasTotales().size());
        jugador.getFichasDelJugador().add(getFichasTotales().get(index));
        getFichasTotales().remove(index);
    }

    public void repartirEquipos2Jugadores() {
        getEquip2().add(getJugador2());
        getEquip1().remove(getJugador2());
        getEquip2().remove(getJugador3());
        getEquip2().remove(getJugador4());
    }


    public void comprobacionDeFicha (int index, Jugador jugador) {
        int index0deFichasDestapadasDeTablero = 0;
        if (getFichasDestapadasEnElTablero().size() == 0) { // PARA CUANDO NO HAY FICHA EN EL TABLERO
            getFichasDestapadasEnElTablero().add(jugador.getFichasDelJugador().get(index));
            jugador.getFichasDelJugador().remove(index);
        } else if ( // PARA LOS IGUALES
                jugador.getFichasDelJugador().get(index).getNum1() == getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum1() &&
                        jugador.getFichasDelJugador().get(index).getNum2() == getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum2()) {
            getFichasDestapadasEnElTablero().add(jugador.getFichasDelJugador().get(index));
            jugador.getFichasDelJugador().remove(index);
        }
        else if ( // PRINCIPIO DE ARRAYLIST
                jugador.getFichasDelJugador().get(index).getNum1() == getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum1() ||
                        jugador.getFichasDelJugador().get(index).getNum2() == getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum2() ||
                        jugador.getFichasDelJugador().get(index).getNum1() == getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum2() ||
                        jugador.getFichasDelJugador().get(index).getNum2() == getFichasDestapadasEnElTablero().get(index0deFichasDestapadasDeTablero).getNum1()) {
            getFichasDestapadasEnElTablero().add(0, jugador.getFichasDelJugador().get(index));
            jugador.getFichasDelJugador().remove(index);


        } else if ( //FINAL DE ARRAYILIST
                jugador.getFichasDelJugador().get(index).getNum1() == getFichasDestapadasEnElTablero().get(getFichasDestapadasEnElTablero().size() - 1).getNum1() ||
                        jugador.getFichasDelJugador().get(index).getNum2() == getFichasDestapadasEnElTablero().get(getFichasDestapadasEnElTablero().size() - 1).getNum2() ||
                        jugador.getFichasDelJugador().get(index).getNum1() == getFichasDestapadasEnElTablero().get(getFichasDestapadasEnElTablero().size() - 1).getNum2() ||
                        jugador.getFichasDelJugador().get(index).getNum2() == getFichasDestapadasEnElTablero().get(getFichasDestapadasEnElTablero().size() - 1).getNum1()) {
            getFichasDestapadasEnElTablero().add(jugador.getFichasDelJugador().get(index));
            jugador.getFichasDelJugador().remove(index);


        } else {
            index = 0;
            System.out.println("X---Ficha no valida---X");
        }
    }

    public void eventoGanado (Jugador jugador) {
        if (jugador.getFichasDelJugador().size() == 0) {
            System.out.println("¡¡¡" + jugador.getNom() + " has ganado!!!");
            System.exit(0);
        }
    }


    //-------------------------------------------- SETTERS -------------------------------------------------------------

    public void setTotsElsJugadors(ArrayList<Jugador> totsElsJugadors) {
        this.totsElsJugadors = totsElsJugadors;
    }

    public void setFichasTotales(ArrayList<Ficha> fichasTotales) {
        this.fichasTotales = fichasTotales;
    }

    public void setFichasDestapadasEnElTablero(ArrayList<Ficha> fichasDestapadasEnElTablero) {
        this.fichasDestapadasEnElTablero = fichasDestapadasEnElTablero;
    }

    public void setEquip1(ArrayList<Jugador> equip1) {
        this.equip1 = equip1;
    }

    public void setEquip2(ArrayList<Jugador> equip2) {
        this.equip2 = equip2;
    }


    public void setGanado1perdido2(int ganado1perdido2) {
        this.ganado1perdido2 = ganado1perdido2;
    }


    //-------------------------------------------- GETTERS -------------------------------------------------------------


    public int getGanado1perdido2() {
        return ganado1perdido2;
    }

    public ArrayList<Ficha> getFichasDestapadasEnElTablero() {
        return fichasDestapadasEnElTablero;
    }

    public ArrayList<Jugador> getEquip1() {
        return equip1;
    }

    public ArrayList<Jugador> getEquip2() {
        return equip2;
    }

    public ArrayList<Jugador> getTotsElsJugadors() {
        return totsElsJugadors;
    }

    public ArrayList<Ficha> getFichasTotales() {
        return fichasTotales;
    }


    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Jugador getJugador3() {
        return jugador3;
    }

    public Jugador getJugador4() {
        return jugador4;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void setJugador3(Jugador jugador3) {
        this.jugador3 = jugador3;
    }

    public void setJugador4(Jugador jugador4) {
        this.jugador4 = jugador4;
    }


}
