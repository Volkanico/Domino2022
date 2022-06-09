package com.company;

import java.util.ArrayList;

public class Jugador {

    private String nom;
    private ArrayList<Ficha> fichasDelJugador = new ArrayList<>();

    public Jugador (String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Ficha> getFichasDelJugador() {
        return fichasDelJugador;
    }

    public void setFichasDelJugador(ArrayList<Ficha> fichasDelJugador) {
        this.fichasDelJugador = fichasDelJugador;
    }
}
