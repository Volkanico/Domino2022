package com.company;

import java.util.ArrayList;

public class Tablero {

    ArrayList<Ficha> fichasTotales;



    public void initFichas() {
        for(int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++){
                fichasTotales.add(new Ficha(i,j));
            }
        }
    }




}
