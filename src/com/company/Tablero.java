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
    ArrayList<Jugador> jugadorsQueJuguen = new ArrayList<>();

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
        getJugadorsQueJuguen().add(jugador1);
        getEquip1().add(jugador1);
        getJugador1().setNom(nameReader.nextLine());
    }
    public void anadirJugador2() {
        getJugadorsQueJuguen().add(jugador2);
        getEquip1().add(jugador2);
        getJugador2().setNom(nameReader.nextLine());
    }
    public void anadirJugador3() {
        getJugadorsQueJuguen().add(jugador3);
        getEquip2().add(jugador3);
        getJugador3().setNom(nameReader.nextLine());
    }
    public void anadirJugador4() {
        getJugadorsQueJuguen().add(jugador4);
        getEquip2().add(jugador4);
        getJugador4().setNom(nameReader.nextLine());
    }

    public void repartirTodasLasFichas() {

            for (int x = 0; x < getFichasTotales().size(); x++) {
                for (int i = 0; i < 7; i++) {

                    int index = (int) (Math.random() * getFichasTotales().size());
                    jugador1.getFichasDelJugador().add(getFichasTotales().get(index));
                    fichasTotales.remove(index);
                    index = (int) (Math.random() * getFichasTotales().size());
                    jugador2.getFichasDelJugador().add(getFichasTotales().get(index));
                    fichasTotales.remove(index);
                    index = (int) (Math.random() * getFichasTotales().size());
                    jugador3.getFichasDelJugador().add(getFichasTotales().get(index));
                    fichasTotales.remove(index);
                    index = (int) (Math.random() * getFichasTotales().size());
                    jugador4.getFichasDelJugador().add(getFichasTotales().get(index));
                    fichasTotales.remove(index);
                }
                //PROVAM AMB ARRAY NORMAL
            }

    }

    public void repartirEquipos2Jugadores () {
        getEquip2().add(getJugador2());
        getEquip1().remove(getJugador2());
        getEquip2().remove(getJugador3());
        getEquip2().remove(getJugador4());


    }

    //-------------------------------------------- SETTERS -------------------------------------------------------------

    public void setJugadorsQueJuguen(ArrayList<Jugador> jugadorsQueJuguen) {
        this.jugadorsQueJuguen = jugadorsQueJuguen;
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

    public ArrayList<Jugador> getJugadorsQueJuguen() {
        return jugadorsQueJuguen;
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
