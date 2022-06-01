package com.company;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Ficha> fichasTotales;



    public void initFichas() {
        for(int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++){
                fichasTotales.add(new Ficha(i,j));
            }
        }
    }


    public ArrayList<Ficha> getFichasTotales() {
        return fichasTotales;
    }

    public void setFichasTotales(ArrayList<Ficha> fichasTotales) {
        this.fichasTotales = fichasTotales;
    }
}
