package com.mycompany.examen2grafosprim;
//CLASE COLA:SE DEFINE UNA COLA ESTATICA DE TIPO NODO
public class Cola {
    int tamaño, frente, atras, num;
    Nodo colita[];
    //CREA UNA COLA CON UN TAMAÑO DEFINIDO
    public Cola(int tamaño){
        colita = new Nodo[tamaño];
        frente = 0;
        atras = 0;
    }
    //METODO: VERIFICA SI LA COLA ESTA VACIA
    public boolean colaVacia(){
        return(frente == -1);
    }
    //METODO: VERIFICA SI LA COLA ESTA LLENA
    public boolean colaLlena(){
        return((atras)==tamaño);
    }
    //METODO: AGREGA UN NODO A LA COLA
    public void encolar(Nodo dato){
        colita[atras] = dato;
        atras++;
    }
    //METODO: SACA UN ELEMENTO DE LA COLA
    public Nodo desencolar(){
        atras--;
        return colita[atras];
    }
    //METODO: VE LOS ELEMENTOS EN LA COLA (APLICA PARA LOS ELEMENTOS -W- ADYACENTES A V
    public void verColaW(){
        for(int i=0; i<atras; i++){
            System.out.println("W:"+ colita[i]);
        }
    }
}