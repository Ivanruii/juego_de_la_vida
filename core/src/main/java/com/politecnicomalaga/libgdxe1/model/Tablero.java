package com.politecnicomalaga.libgdxe1.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Tablero {
    //Atributos
    private int sizeX;
    private int sizeY;
    private static final int CELL_SIZE = 10;
    private Celula[][] tablero;

    //Metodos

    public Tablero(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void inicializarTablero() {
        tablero = new Celula[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (Math.random() < 0.2) { // 20% de células vivas
                    tablero[i][j] = new Celula(i * CELL_SIZE, j * CELL_SIZE,true);
                }
            }
        }
    }

    public void pintarCelulas(ShapeRenderer shapeRenderer) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (tablero[i][j] != null) {
                    tablero[i][j].draw(shapeRenderer);
                }
            }
        }
    }

    public void actualizar() {
        Celula[][] newGrid = new Celula[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                int vecinos = contarVecinos(i, j);
                if (tablero[i][j] != null) {
                    if (vecinos == 2 || vecinos == 3) {
                        newGrid[i][j] = new Celula(i * CELL_SIZE, j * CELL_SIZE,true);
                    }
                } else {
                    if (vecinos == 3) {
                        newGrid[i][j] = new Celula(i * CELL_SIZE, j * CELL_SIZE, true);
                    }
                }
            }
        }
        tablero = newGrid;
    }

    private int contarVecinos(int x, int y) {
        int vecinos = 0;
        int[][] direcciones = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        /*direcciones = new int[8][2];
        int valor = -2;
        for (int i = 0; i < 9; i++) {
            //Los valores almacenados siempre estan entre el -1 y el 1
            if(i%3 == 0) {
                valor++;
            }

        }
        */


        for (int[] d : direcciones) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < sizeX && ny >= 0 && ny < sizeY && tablero[nx][ny] != null) {
                vecinos++;
            }
        }
        return vecinos;
    }
}
