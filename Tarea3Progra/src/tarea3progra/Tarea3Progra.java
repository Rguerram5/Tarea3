package tarea3progra;

import javax.swing.JOptionPane;

public class Tarea3Progra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0, elemento;
        String nombre;
        ArbolBinario arbolito = new ArbolBinario();
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un Nodo\n"
                        + "2. Recorrido InOrden\n"
                        + "3. Recorrido PreOrden\n"
                        + "4. Recorrido PostOrden\n"
                        + "5. Buscar Arbol\n"
                        + "6. Eliminar Nodo\n"
                        + "7. Salir\n"
                        + "Elige una opcion...", "Arboles Binarios",
                        JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del Nodo", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,
                                "Ingresa el nombre del Nodo...", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE);
                        arbolito.agregarNodo(elemento, nombre);
                        break;
                    case 2:
                        if (!arbolito.Vacio()) {
                            System.out.println();
                            arbolito.Inorden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol está vacío  ", "Cuidado!", JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!arbolito.Vacio()) {
                            System.out.println();
                            arbolito.Preorden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol está vacío  ", "Cuidado!", JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 4:
                        if (!arbolito.Vacio()) {
                            System.out.println();
                            arbolito.Postorden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol está vacío  ", "Cuidado!", JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 5:
                        if (!arbolito.Vacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el numero del Nodo a Buscar", "Buscando", JOptionPane.QUESTION_MESSAGE));
                            arbolito.buscarNodo(elemento);
                            if (arbolito.buscarNodo(elemento) == null) {
                                JOptionPane.showMessageDialog(null, "Nodo no Encontrado  ", "Nodo sin encontrar!", JOptionPane.QUESTION_MESSAGE);
                            } else {
                                System.out.println("El nodo encontrado es: " + elemento);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol está vacío  ", "Cuidado!", JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 6:
                        if (!arbolito.Vacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el numero del Nodo a eliminar", "Eliminando", JOptionPane.QUESTION_MESSAGE));
                            arbolito.buscarNodo(elemento);
                            if (arbolito.eliminar(elemento) == false) {
                                JOptionPane.showMessageDialog(null, "Nodo no Encontrado  ", "Nodo sin encontrar!", JOptionPane.QUESTION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Nodo Eliminado  ", "Nodo se ha eliminado", JOptionPane.QUESTION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol está vacío  ", "Cuidado!", JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicación Finalizada ", "Fin", JOptionPane.QUESTION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta ", "Cuidado!", JOptionPane.QUESTION_MESSAGE);
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }
        } while (opcion != 7);

    }

}
