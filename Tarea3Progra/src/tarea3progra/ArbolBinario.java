/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3progra;

/**
 *
 * @author HP
 */
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // método para insertar un nodo en el arbol
    public void agregarNodo(int d, String nom) {
        NodoArbol nuevo = new NodoArbol(d, nom);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while (true) {
                padre = auxiliar;
                if (d < auxiliar.dato) {
                    auxiliar = auxiliar.hijoIzquierdo;
                    if (auxiliar == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    //Metodo arbol vacio
    public boolean Vacio() {
        return raiz == null;
    }

    //Metodo recorrido InOrden
    public void Inorden(NodoArbol r) {
        if (r != null) {
            Inorden(r.hijoIzquierdo);
            System.out.print(r.dato + ", ");
            Inorden(r.hijoDerecho);
        }
    }

    // Metodo PreOrden
    public void Preorden(NodoArbol r) {
        if (r != null) {
            System.out.print(r.dato + ", ");
            Preorden(r.hijoIzquierdo);
            Preorden(r.hijoDerecho);
        }
    }
    //Metodo PostORden

    public void Postorden(NodoArbol r) {
        if (r != null) {
            Postorden(r.hijoIzquierdo);
            Postorden(r.hijoDerecho);
            System.out.print(r.dato + ", ");
        }
    }

    // Metodo de Eliminar
    public boolean eliminar(int d) {
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzq = true;
        while (auxiliar.dato != d) {
            padre = auxiliar;
            if (d < auxiliar.dato) {
                esHijoIzq = true;
                auxiliar = auxiliar.hijoIzquierdo;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.hijoDerecho;
            }
            if (auxiliar == null) {
                return false;
            }
        }// Fin del while
        if (auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoIzquierdo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
            } else {
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
        } else if (auxiliar.hijoIzquierdo == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoDerecho;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = auxiliar.hijoDerecho;
            } else {
                padre.hijoDerecho = auxiliar.hijoDerecho;
            }
        } else {
            NodoArbol reemplazo = obtenerNodo(auxiliar);
            if (auxiliar ==raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = reemplazo;
            } else {
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
        }
        return true;
    }
    //Metodo devolver el nodo reemplazo
    public NodoArbol obtenerNodo(NodoArbol nodoReem){
        NodoArbol reempadre=nodoReem;
        NodoArbol reemplazo=nodoReem;
        NodoArbol auxiliar=nodoReem.hijoDerecho;
        while(auxiliar!=null){
            reempadre=reemplazo;
            reemplazo=auxiliar;
            auxiliar=auxiliar.hijoIzquierdo;
        }
        if(reemplazo!=nodoReem.hijoDerecho){
            reempadre.hijoDerecho=reemplazo.hijoDerecho;
            reemplazo.hijoDerecho=nodoReem.hijoDerecho;
            
        }
        System.out.println("El Nodo reemplazo es: " + reemplazo);
        return reemplazo;
    }
    //Metodo Busqueda
    public NodoArbol buscarNodo(int d){
        NodoArbol aux=raiz;
        while(aux.dato!=d){
            if(d<aux.dato){
                aux=aux.hijoIzquierdo;
            }else {
                aux=aux.hijoDerecho;
            }
            if(aux==null){
                return null;
            }
        }
        return aux;
    }
}
