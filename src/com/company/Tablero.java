package com.company;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Ficha> fichasTotales = new ArrayList<>();
    Jugador jugador1 = new Jugador("Jugador 1");
    Jugador jugador2 = new Jugador("Jugador 2");
    Jugador jugador3 = new Jugador("Jugador 3");
    Jugador jugador4 = new Jugador("Jugador 4");

    ArrayList<Jugador> equip1 = new ArrayList<>();
    ArrayList<Jugador> equip2 = new ArrayList<>();

    public void guardarEquips () {
        equip1.add(jugador1);
        equip1.add(jugador2);
        equip2.add(jugador3);
        equip2.add(jugador4);
        System.out.println("-----EQUIP 1-----");
        for(int i = 0; i < equip1.size(); i++) {

            System.out.println(getEquip1().get(i).getNom());
        }
        System.out.println("-----------------");
        System.out.println("-----EQUIP 2-----");
        for(int i = 0; i < equip2.size(); i++) {
            System.out.println(getEquip2().get(i).getNom());
        }
        System.out.println("-----------------");
    }

    public void initFichas() {
        for(int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++){
                fichasTotales.add(new Ficha(i,j));
            }
        }
    }

    public void imprimirFichas () {
        for (int i = 0; i < fichasTotales.size(); i++) {
            System.out.print(" [" + fichasTotales.get(i).getNum1() + " | " + fichasTotales.get(i).getNum2() + "] ");
        }
    }

    public void iniciarJuego () {
        initFichas();
    }


    public ArrayList<Ficha> getFichasTotales() {
        return fichasTotales;
    }

    public void setFichasTotales(ArrayList<Ficha> fichasTotales) {
        this.fichasTotales = fichasTotales;
    }


    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Jugador getJugador3() {
        return jugador3;
    }

    public void setJugador3(Jugador jugador3) {
        this.jugador3 = jugador3;
    }

    public Jugador getJugador4() {
        return jugador4;
    }

    public void setJugador4(Jugador jugador4) {
        this.jugador4 = jugador4;
    }

    public ArrayList<Jugador> getEquip1() {
        return equip1;
    }

    public void setEquip1(ArrayList<Jugador> equip1) {
        this.equip1 = equip1;
    }

    public ArrayList<Jugador> getEquip2() {
        return equip2;
    }

    public void setEquip2(ArrayList<Jugador> equip2) {
        this.equip2 = equip2;
    }
}
