package com.mycompany.examen2grafosprim;

import java.io.*;

public class ArchivoMetodos {
    NodosYAristas NODO = new NodosYAristas();
    public boolean exists(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        boolean existe = false;
        try {
            return (archivo.exists());
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return existe;
    }
}
