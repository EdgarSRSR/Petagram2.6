package com.solrom.edgar.petagram26;

import android.content.res.Resources;

/**
 * Created by administrador on 08/05/17.
 */

public class Mascota {

    private String nombre;
    private int numLikes;
    private int foto;
    private int colorFondo;


    public Mascota (String nombre, int numLikes, int foto, int colorFondo){
        this.nombre = nombre;
        this.numLikes = numLikes;
        this.foto = foto;
        this.colorFondo = colorFondo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLinkes(int numLinkes) {
        this.numLikes = numLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(int colorFondo) {
        this.colorFondo = colorFondo;
    }
}
