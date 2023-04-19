package com.mycompany.examen2grafosprim;

public class Nodo {

    public char info;
    public Nodo Sig;
    public Nodo Ant;

    public Nodo(char info) {
        this.info = info;
        Sig = null;
        Ant = null;
    }

    @Override
    public String toString() {
        return this.info + " ";
    }
}
