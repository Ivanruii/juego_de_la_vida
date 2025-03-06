package com.politecnicomalaga.libgdxe1.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Controles {
    //Atributos
    private Cuadrado[] botones;
    private Texture imagenPausa;
    private Texture imagenPlay;
    private Texture imagenReset;

    //Metodos

    public Controles() {
        botones = new Cuadrado[2];
        this.imagenPausa = new Texture("Pausa.jpg");
        this.imagenPlay = new Texture("Play.jpg");
        this.imagenReset = new Texture("Reset.jpg");
    }

    public Texture getImagenPausa() {
        return imagenPausa;
    }

    public Texture getImagenPlay() {
        return imagenPlay;
    }

    public Texture getImagenReset() {
        return imagenReset;
    }

    public void pintarControles(int posicionX, int posicionY, SpriteBatch batch) {
        botones[0] = new Cuadrado(posicionX,posicionY);
        botones[1] = new Cuadrado(posicionX+botones[0].getiPosX(),posicionY);
        botones[0].ponerImagen(imagenPausa,batch);
        botones[1].ponerImagen(imagenReset,batch);
    }
}
