package tareaprogramada3.datos1.structures.Graph;

import tareaprogramada3.datos1.structures.Graph.Vertice;
import tareaprogramada3.datos1.structures.Graph.Arista;
import java.util.List;
import tareaprogramada3.datos1.structures.Graph.Arista;
import tareaprogramada3.datos1.structures.Graph.Vertice;

/**
 * La clase grafo permite generar los linkeos entre los v�rtices y las aristas

 */

//UNE VERTICES Y ARISTAS
public class Grafo {
	private List<Vertice<Object>> vertices;
	private List<Arista> aristas;

	/**
	 * constructor del grafo
	 * 
	 * @param pVertices lista de vertices del grafo
	 * @param pAristas  lista de aristas del grafo
	 */
	public Grafo(List<Vertice<Object>> pVertices, List<Arista> pAristas) {
		this.vertices = pVertices;
		this.aristas = pAristas;
	}
	// GETTERS Y SETTERS

	public List<Vertice<Object>> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice<Object>> vertices) {
		this.vertices = vertices;
	}

	public List<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista> aristas) {
		this.aristas = aristas;
	}

	@Override
	/**
	 * método para obtener las variables en string
	 */
	public String toString() {
		String msj = "";
		msj += vertices.toString();
		msj += aristas.toString();
		return msj;
	}
}