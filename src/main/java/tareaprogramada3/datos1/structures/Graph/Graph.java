package tareaprogramada3.datos1.structures.Graph;

import java.util.List;
import tareaprogramada3.datos1.administration.*;

/**
 * La clase grafo permite generar los linkeos entre los v�rtices y las Edges

 */

//UNE VERTICES Y ARISTAS
public class Graph {
	private List<VertexNode<Place>> vertexNodes;
	private List<Edge> Edges;

	/**
	 * constructor del grafo
	 * 
	 * @param T_VertexNodes lista de vertexNodes del grafo
	 * @param T_Edge  lista de Edges del grafo
	 */
	public Graph(List<VertexNode<Place>> T_VertexNodes, List<Edge> T_Edge) {
		this.vertexNodes = T_VertexNodes;
		this.Edges = T_Edge;
	}
	// GETTERS Y SETTERS

	public List<VertexNode<Place>> getVertexNodes() {
		return vertexNodes;
	}

	public void setVertexNodes(List<VertexNode<Place>> vertexNodes) {
		this.vertexNodes = vertexNodes;
	}

	public List<Edge> getEdges() {
		return Edges;
	}

	public void setEdges(List<Edge> Edges) {
		this.Edges = Edges;
	}

	@Override
	/**
	 * método para obtener las variables en string
	 */
	public String toString() {
		String message = "";
		message += vertexNodes.toString();
		message += Edges.toString();
		return message;
	}
}