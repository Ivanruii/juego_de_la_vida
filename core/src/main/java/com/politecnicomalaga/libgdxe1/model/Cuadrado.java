package com.politecnicomalaga.libgdxe1.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

import org.w3c.dom.Text;

public class Cuadrado {
    private int iPosX;
    private int iPosY;
    private static int iLado = 10;

    public Cuadrado(int iPosX, int iPosY) {
        this.iPosX = iPosX;
        this.iPosY = iPosY;
    }


    public int getiPosX() {
        return iPosX;
    }


    public int getiPosY() {
        return iPosY;
    }


    public int getiLado() {
        return iLado;
    }

    public void ponerImagen(Texture img, SpriteBatch batch) {
        batch.draw(img,iPosX,iPosY,75,50);
    }
}
