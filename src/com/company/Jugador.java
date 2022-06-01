package com.company;

public class Jugador {

    private String nom;

    private Ficha[] fichasDelJugador;


    public Jugador (String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ficha[] getFichasDelJugador() {
        return fichasDelJugador;
    }

    public void setFichasDelJugador(Ficha[] fichasDelJugador) {
        this.fichasDelJugador = fichasDelJugador;
    }


}
