package tareaprogramada3.datos1.structures.Graph;

import java.util.*;

/**
 * Interface que contiene los métodos de ejecución para cualquier grafo
 * 
 *
 * @param <Generic>
 *            Este genérico permite utilizar cualquier objeto, de modo que este
 *            objeto sea parte del nodo del grafo
 */

//MÉTODOS PREDETERMINADOS DE TODOS LOS GRAFOS
public interface GraphBehavior<Generic> {
	
        public void runGraph(Generic Graph);

	public LinkedList<Generic> getListedRoute(Generic T_Destiny);
}