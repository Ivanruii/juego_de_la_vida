package com.politecnicomalaga.libgdxe1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.libgdxe1.model.Cuadrado;

public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private Cuadrado[][] grid;
    private static int GRID_SIZE_X;
    private static int GRID_SIZE_Y;
    private static final int CELL_SIZE = 10;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        GRID_SIZE_X = Gdx.graphics.getWidth() / CELL_SIZE;
        GRID_SIZE_Y = Gdx.graphics.getHeight() / CELL_SIZE;

        inicializarGrid();
    }

    private void inicializarGrid() {
        grid = new Cuadrado[GRID_SIZE_X][GRID_SIZE_Y];
        for (int i = 0; i < GRID_SIZE_X; i++) {
            for (int j = 0; j < GRID_SIZE_Y; j++) {
                if (Math.random() < 0.2) { // 20% de células vivas
                    grid[i][j] = new Cuadrado(i * CELL_SIZE, j * CELL_SIZE, "Viva");
                }
            }
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (int i = 0; i < GRID_SIZE_X; i++) {
            for (int j = 0; j < GRID_SIZE_Y; j++) {
                if (grid[i][j] != null) {
                    grid[i][j].draw(shapeRenderer);
                }
            }
        }

        shapeRenderer.end();
        update();

        // Pulsar la tecla "R" del teclado para reiniciar
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            inicializarGrid();
        }
    }

    private void update() {
        Cuadrado[][] newGrid = new Cuadrado[GRID_SIZE_X][GRID_SIZE_Y];

        for (int i = 0; i < GRID_SIZE_X; i++) {
            for (int j = 0; j < GRID_SIZE_Y; j++) {
                int vecinos = contarVecinos(i, j);
                if (grid[i][j] != null) {
                    if (vecinos == 2 || vecinos == 3) {
                        newGrid[i][j] = new Cuadrado(i * CELL_SIZE, j * CELL_SIZE, "Viva");
                    }
                } else {
                    if (vecinos == 3) {
                        newGrid[i][j] = new Cuadrado(i * CELL_SIZE, j * CELL_SIZE, "Viva");
                    }
                }
            }
        }
        grid = newGrid;
    }

    private int contarVecinos(int x, int y) {
        int vecinos = 0;
        int[][] direcciones = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] d : direcciones) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < GRID_SIZE_X && ny >= 0 && ny < GRID_SIZE_Y && grid[nx][ny] != null) {
                vecinos++;
            }
        }
        return vecinos;
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
