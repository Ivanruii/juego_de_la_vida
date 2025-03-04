package com.politecnicomalaga.libgdxe1.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class Cuadrado {
    private int iPosX;
    private int iPosY;
    private static int iLado = 10;
    private String sColor;

    public Cuadrado(int iPosX, int iPosY, String sColor) {
        this.iPosX = iPosX;
        this.iPosY = iPosY;
        this.sColor = sColor;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        if (sColor.equalsIgnoreCase("Viva")) {
            shapeRenderer.setColor(Color.WHITE);
        } else {
            shapeRenderer.setColor(Color.BLACK);
        }
        shapeRenderer.rect(iPosX, iPosY, iLado, iLado);
    }

    public int getiPosX() {
        return iPosX;
    }

    public void setiPosX(int iPosX) {
        this.iPosX = iPosX;
    }

    public int getiPosY() {
        return iPosY;
    }

    public void setiPosY(int iPosY) {
        this.iPosY = iPosY;
    }

    public static int getiLado() {
        return iLado;
    }

    public static void setiLado(int iLado) {
        Cuadrado.iLado = iLado;
    }

    public String getsColor() {
        return sColor;
    }

    public void setsColor(String sColor) {
        this.sColor = sColor;
    }
}
