package com.politecnicomalaga.libgdxe1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.libgdxe1.model.Controles;
import com.politecnicomalaga.libgdxe1.model.Cuadrado;
import com.politecnicomalaga.libgdxe1.model.Tablero;

public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;
    private Tablero tablero;
    private Controles menuControles;
    private static int GRID_SIZE_X;
    private static int GRID_SIZE_Y;
    private static final int CELL_SIZE = 10;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        GRID_SIZE_X = Gdx.graphics.getWidth() / CELL_SIZE;
        GRID_SIZE_Y = Gdx.graphics.getHeight() / CELL_SIZE;
        menuControles = new Controles();
        tablero = new Tablero(GRID_SIZE_X,GRID_SIZE_Y);
        tablero.inicializarTablero();
    }


    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        batch.begin();
        tablero.pintarCelulas(shapeRenderer);
        menuControles.pintarControles(GRID_SIZE_X,0,batch);


        shapeRenderer.end();
        batch.end();
        tablero.actualizar();

        // Pulsar la tecla "R" del teclado para reiniciar
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            tablero.inicializarTablero();
        }
    }




    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
