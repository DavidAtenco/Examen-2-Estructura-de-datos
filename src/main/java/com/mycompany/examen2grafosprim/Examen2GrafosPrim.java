package com.mycompany.examen2grafosprim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saxin
 */
public class Examen2GrafosPrim {

    public static void main(String[] args) throws IOException {
        var OperAr = new ArchivoMetodos();
        Scanner Txt = new Scanner(System.in);
        int OP=0;
        System.out.println("Practica 8 'Grafos'");

        do {
            int Cont = 0, c;
            String Archivo;
            char Vertice;
            Menu();
            System.out.print("Elige una opcion: ");
            
            OP = Txt.nextInt();
            var NODO = new NodosYAristas();
            Txt.nextLine();
            switch (OP) {
                case 1:
                    System.out.println("***Algoritmo BPP***");
                    System.out.println("Dame el nombre de archivo a abrir");
                    Archivo = Txt.nextLine();                  
                    if (!OperAr.exists(Archivo)) {
                        System.out.println("ERROR!, El archivo no existe o esta mal escrito");
                    } else {
                        System.out.println("Se ha extraido la informacion del archivo: " + Archivo);
                        try {
                            FileReader FR = new FileReader(Archivo);
                            while ((c = FR.read()) != -1) {
                                if (c == '*') {
                                    c = FR.read();
                                    NODO.InsertarFinal((char) c);
                                    Cont += 1;
                                } else {
                                    if (c == '-') {
                                        c = FR.read();
                                        NODO.InsertaArista((char) c, Cont);
                                    }
                                }
                            }
                            FR.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ArchivoMetodos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("El grafo es el siguiente:");
                        NODO.MostrarLista(Cont);
                        System.out.println("");
                        System.out.print("Dame el vertice inicial para comenzar el recorrido: ");
                        Vertice = Txt.next().charAt(0);
                        NODO.Opcion1(Vertice);
                    }
                    break;
                case 2:
                    System.out.println("Algoritmo BPA");
                    System.out.println("Dame el nombre de archivo a abrir");
                    Archivo = Txt.nextLine();
                    if (!OperAr.exists(Archivo)) {
                        System.out.println("ERROR!, El archivo no existe o esta mal escrito");
                    } else {
                        System.out.println("Se ha extraido la informacion del archivo: " + Archivo);
                        try {
                            FileReader FR = new FileReader(Archivo);
                            while ((c = FR.read()) != -1) {
                                if (c == '*') {
                                    c = FR.read();
                                    NODO.InsertarFinal((char) c);
                                    Cont += 1;
                                } else {
                                    if (c == '-') {
                                        c = FR.read();
                                        NODO.InsertaArista((char) c, Cont);
                                    }
                                }
                            }
                            FR.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ArchivoMetodos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("El grafo es el siguiente:");
                        NODO.MostrarLista(Cont);
                        System.out.println("");
                        System.out.print("Dame el vertice inicial para comenzar el recorrido: ");
                        Vertice = Txt.next().charAt(0);
                        NODO.opcion2(Vertice);
                    }
                    break;
            }
        } while (OP != 3);
        System.out.println("Saliendo del programa...");
    }

    public static void Menu() {
        System.out.println("----!!MENU PRINCIPAL!!----\n"
                        +"1.Recorrer un grafo en: Búsqueda primero en profundidad (bpp())\n"
                        +"2.Recorrer un grafo en: Búsqueda primero en anchura o amplitud (bpa())\n"
                        +"3.Salir del programa");
    }
}
