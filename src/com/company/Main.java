package com.company;

public class Main {

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        InputOutput inputOutput = new InputOutput();

        tablero.initFichas();
        tablero.imprimirFichas();
        inputOutput.introduction();


    }
}
