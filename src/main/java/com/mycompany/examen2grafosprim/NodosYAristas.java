package com.mycompany.examen2grafosprim;

public class NodosYAristas {

    private Nodo IniLiga;
    private Nodo Sig;
    private Nodo Ant;

    public NodosYAristas() {
        IniLiga = null;
        Sig = null;
        Ant = null;
    }
    //METODO LISTA: AGREGA UN NODO AL FINAL DE LA LISTA
    public void InsertarFinal(char DatoM) {
        Nodo nuevo = new Nodo(DatoM);
        Nodo aux = IniLiga;
        if (IniLiga == null) {
            IniLiga = nuevo;
        } else {
            while (aux.Ant != null) {
                aux = aux.Ant;
            }
            aux.Ant = nuevo;
            nuevo.Ant = null;
        }
    }
    
    //METODO GRAFO/ARISTA: AGREGA UNA ARISTA A LA LISTA
    public void InsertaArista(char Dato, int Cont) {
        Nodo nuevo = new Nodo(Dato);
        Nodo aux = IniLiga;
        Nodo aux2 = IniLiga;
        int ContAux = 1;
        if (Cont == 1) {
            if (aux.Sig == null) {
                aux.Sig = nuevo;
                nuevo.Sig = null;
            } else {
                while (aux.Sig != null) {
                    aux = aux.Sig;
                }
                aux.Sig = nuevo;
                nuevo.Sig = null;
            }
        } else {
            while (ContAux != Cont) {
                aux = aux.Ant;
                ContAux += 1;
            }
            if (aux.Sig == null) {
                aux.Sig = nuevo;
                nuevo.Sig = null;
            } else {
                while (aux.Sig != null) {
                    aux = aux.Sig;
                }
                aux.Sig = nuevo;
                nuevo.Sig = null;
            }
        }
    }
    
    //MÉTODO LISTA: MUESTRA LOS ELEMENTOS DE LA LISTA
    public void MostrarLista(int Cont) {
        Nodo aux = IniLiga;
        int ContAux = 1;
        while (aux != null) {
            var aux2 = IniLiga;
            System.out.print("| " + aux + "|->");
            aux = aux.Ant;
            for (int i = 1; i < ContAux; i++) {
                aux2 = aux2.Ant;
            }
            while (aux2.Sig != null) {
                System.out.print("| " + aux2.Sig + "|");
                aux2 = aux2.Sig;
            }
            ContAux += 1;
            System.out.println("");
        }
    }
    
    //METODO AUXILIAR AL BPP: EQUIVALENTE A BORRAR MARCAS
    public void Opcion1(char Vertice) {
        Nodo aux = IniLiga;
        Nodo aux2 = IniLiga;
        boolean Marcas[];
        char Orden[];
        int ContP = 1;
        int Tam = 1;
        while (aux != null) {
            aux = aux.Ant;
            Tam += 1;
        }
        Marcas = new boolean[Tam];
        Orden = new char[Tam];
        for (int i = 0; i < Tam; i++) {
            Marcas[i] = false;
        }
        while (aux2.info != Vertice) {
            aux2 = aux2.Ant;
            ContP += 1;
        }
        Marcas[ContP] = true;
        int OrdenM = 0;
        AlgoritmoBPP(aux2, Marcas, ContP, Tam, OrdenM, Orden);
    }
    
    //MÉTODO BPP: REALIZA LA BUSQUEDA EN LO PROFUNDO DEL GRAFO
    public void AlgoritmoBPP(Nodo V, boolean[] Marca, int Cont, int Tam, int OrdenM, char[] Orden) {
        Orden[OrdenM] = V.info;
        OrdenM += 1;
        System.out.println("V:" + V.info);
        Nodo aux = IniLiga;
        char Vertice;
        V = V.Sig;
        Vertice = V.info;
        Cont = 1;
        while (aux.info != Vertice) {
            aux = aux.Ant;
            Cont += 1;
        }
        if (Marca[Cont] == false) {
            System.out.println("W:" + V.info);
            System.out.println("------");
            Marca[Cont] = true;
            AlgoritmoBPP(aux, Marca, Cont, Tam, OrdenM, Orden);
        } else {
            System.out.print("W:" + V.info);
            while (Marca[Cont] != false && V.Sig != null) {
                aux = IniLiga;
                V = V.Sig;
                Vertice = V.info;
                Cont = 1;
                while (aux.info != Vertice) {
                    aux = aux.Ant;
                    Cont += 1;
                }
                System.out.print("," + V.info);
            }
            if (Marca[Cont] != true) {
                System.out.println("\n------");
                Marca[Cont] = true;
                AlgoritmoBPP(aux, Marca, Cont, Tam, OrdenM, Orden);
            }
            aux = IniLiga;
            for (int i = 1; i < Tam; i++) {
                if (Marca[i] == false) {
                    System.out.println("\n---+---");
                    Marca[i] = true;
                    AlgoritmoBPP(aux, Marca, i, Tam, OrdenM, Orden);
                }
                aux = aux.Ant;
            }
        }
        if (OrdenM == Tam - 1) {
            MostrarGrafo(Orden, Tam);
        }
    }
    //METODO SIMILAR A Opcion1: REALIZA EL BORRADO DE MARCAS INICIAL EN EL ARREGLO Marcas
    public void opcion2(char Vertice){
        Nodo aux = IniLiga;
        Nodo aux2 = IniLiga;
        boolean Marcas[];
        char Orden[];
        int ContP = 1;
        int Tam = 1;
        while (aux != null) {
            aux = aux.Ant;
            Tam += 1;
        }
        Marcas = new boolean[Tam];
        Orden = new char[Tam];
        for (int i = 0; i < Tam; i++) {
            Marcas[i] = false;
        }
        while (aux2.info != Vertice) {
            aux2 = aux2.Ant;
            ContP += 1;
        }
        Marcas[ContP] = true;
        int OrdenM = 0;
        
        //CICLO QUE BUSCA EL VERTICE DADO EN LA LISTA
        
        /*VERIFICA SI EL ARREGLO MARCA EN LA POSICION DADA POR I
        NO ESTA VISITADO, DE SER ASI LLAMA AL METODO BPA*/

        BPA(aux2, Marcas, ContP, Tam, OrdenM, Orden);
        
        
    }
    
    public void BPA(Nodo V, boolean[] Marca, int Cont, int Tam, int OrdenM, char[] Orden){
        Cola cola = new Cola(50);
        Nodo x = IniLiga;
        Orden[OrdenM] = V.info;
        OrdenM += 1;
        System.out.println("V:" + V.info);
        Nodo aux = IniLiga;
        char Vertice;
        V = V.Sig;
        Vertice = V.info;
        Cont = 1;

        //SE PONE EN LA COLA EL VERTICE DADO
        
        //CICLO REPITE MIENTRAS HAYA ELEMENTOS EN LA COLA
        while(cola.colaVacia() == false){
            cola.encolar(V);
            cola.verColaW();
            //SE PONE ASIGNA EL VALOR A X EL VALOR QUE REGRESA DESENCOLAR
            x = cola.desencolar();
            //System.out.println("W:" + x);
            cola.verColaW();
            //SE ITERA EN LA LISTA
            /*while (aux.info != Vertice) {
            aux = aux.Ant;
            Cont += 1;
            }*/
            V = V.Sig;
            Vertice = V.info;
            Cont += 1;

            if (Marca[Cont] == false){
                Marca[Cont] = true;
                cola.encolar(V);
                //AQUI PASA AL NODO ADYACENTE Y ENCOLA EL VALOR, PARA ESTAR SEGUROS MUESTRA EL VALOR DE LA COLA
                cola.verColaW();
                V = V.Sig;
                Vertice = V.info;
                Cont += 1;
            }else{
                while(Marca[Cont] == true){
                   V = V.Sig.Sig;
                Vertice = V.info;
                Cont += 1;   
                }
              cola.verColaW();
            }
            
        }
            MostrarGrafo(Orden, Tam);
    }

    public void MostrarGrafo(char[] Orden, int Tam) {
        System.out.println("\nArbol de Expansión");
        for (int i = 0; i < Tam-1; i++) {
            System.out.println(Orden[i]);
        }
    }
}