package tareaprogramada3.datos1.structures.Graph;

import java.util.*;

/**
 * Interface que contiene los métodos de ejecución para cualquier grafo
 * 
 *
 * @param <objeoGenerico>
 *            Este genérico permite utilizar cualquier objeto, de modo que este
 *            objeto sea parte del nodo del grafo
 */

//MÉTODOS PREDETERMINADOS DE TODOS LOS GRAFOS
public interface ComportamientoGrafo<objeoGenerico> {
	
        public void ejecutarGrafo(objeoGenerico Grafo);

	public LinkedList<objeoGenerico> obtenerListadoCamino(objeoGenerico pDestino);
}