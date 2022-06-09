package com.company;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Ficha> fichasTotales = new ArrayList<>();
    private ArrayList<Ficha> fichasDestapadasEnElTablero = new ArrayList<>();
    Jugador jugador1 = new Jugador("Jugador 1");
    Jugador jugador2 = new Jugador("Jugador 2");
    Jugador jugador3 = new Jugador("Jugador 3");
    Jugador jugador4 = new Jugador("Jugador 4");


    ArrayList<Jugador> equip1 = new ArrayList<>();
    ArrayList<Jugador> equip2 = new ArrayList<>();
    ArrayList<Jugador> jugadorsTotals = new ArrayList<>();

    public void guardarEquips () {
        jugadorsTotals.add(jugador1);
        jugadorsTotals.add(jugador2);
        jugadorsTotals.add(jugador3);
        jugadorsTotals.add(jugador4);
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





    public void repartirTodasLasFichas () {

        for (int x = 0; x < 28; x++){
            for (int i = 0; i < 7; i++) {
                int index = (int)(Math.random() * fichasTotales.size());
                jugador1.getFichasDelJugador().add(fichasTotales.get(index));
                fichasTotales.remove(index);
                jugador2.getFichasDelJugador().add(fichasTotales.get(index));
                fichasTotales.remove(index);
                jugador3.getFichasDelJugador().add(fichasTotales.get(index));
                fichasTotales.remove(index);
                jugador4.getFichasDelJugador().add(fichasTotales.get(index));
                fichasTotales.remove(index);
            }//PROVAM AMB ARRAY NORMAL
        }
    }










    public ArrayList<Ficha> getFichasTotales() {
        return fichasTotales;
    }

    public void setFichasTotales(ArrayList<Ficha> fichasTotales) {
        this.fichasTotales = fichasTotales;
    }

    public ArrayList<Jugador> getEquip1() {
        return equip1;
    }

    public ArrayList<Jugador> getEquip2() {
        return equip2;
    }

    public ArrayList<Jugador> getJugadorsTotals() {
        return jugadorsTotals;
    }

}
