/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3progra;

/**
 *
 * @author HP
 */
public class NodoArbol {
    int dato;
    String nombre;
    NodoArbol hijoIzquierdo, hijoDerecho;
    public NodoArbol(int d, String nom){
        this.dato=d;
        this.nombre=nom;
        this.hijoDerecho=null;
        this.hijoIzquierdo=null;
              
    }
    public String toString(){
        return nombre + "Su dato es: " + dato;
    }
}
