package com.politecnicomalaga.libgdxe1.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Celula extends Cuadrado {

    //Atributos
    private boolean viva;

    //Metodos

    public Celula(int iPosX, int iPosY, boolean viva) {
        super(iPosX, iPosY);
        this.viva = viva;
    }

    public boolean isViva() {
        return viva;
    }

    public void setViva(boolean viva) {
        this.viva = viva;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        if (this.viva) {
            shapeRenderer.setColor(Color.WHITE);
        } else {
            shapeRenderer.setColor(Color.BLACK);
        }
        shapeRenderer.rect(super.getiPosX(), super.getiPosY(), super.getiLado(), super.getiLado());
    }
}
