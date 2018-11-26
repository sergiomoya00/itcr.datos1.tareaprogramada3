package tareaprogramada3.datos1.structures.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tareaprogramada3.datos1.administration.Place;


/**
 * clase para controlar el grafo
 */
public class GraphLeader {
    
        
	private List<VertexNode<Place>> vertexes;
	private List<Edge> edges;
	private LinkedList<VertexNode<Place>> stroke;

	/**
	 * Al generar el contructor se inicializan y se crean objetos de las 3 listas
	 * necesarias.
	 */
	public GraphLeader() {
		this.vertexes = new ArrayList<VertexNode<Place>>();
		this.edges = new ArrayList<Edge>();
		this.stroke = new LinkedList<VertexNode<Place>>();
	}

	/**
	 * método para obtener el stroke del grafo
	 * 
	 * @return stroke con camino
	 */
        
        public LinkedList<VertexNode<Place>> getStroke() {
		return stroke;
	}

	/**
	 * método para ingresar nuevo stroke
	 * 
	 * @param stroke stroke por ingresar
	 */
	public void setStroke(LinkedList<VertexNode<Place>> stroke) {
		this.stroke = stroke;
	}

	/**
	 * método para obtener vertexes
	 * 
	 * @return vertexes del grafo
	 */
	public List<VertexNode<Place>> getVertexNodes() {
		return vertexes;
	}

	/**
	 * método para configurar vertexes
	 * 
	 * @param vertexes vertexes nuevas para el grafo
	 */
	public void setVertexNodes(List<VertexNode<Place>> vertexes) {
		this.vertexes = vertexes;
	}

	/**
	 * método para obtener edges
	 * 
	 * @return edges
	 */
	public List<Edge> getEdges() {
		return edges;
	}

	/**
	 * MÉtodo para ingresar edges al grafo
	 * 
	 * @param edges nuevas edges
	 */
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	/**
	 * Permite generar relaciones entre los v�rtices (que deben ser existentes) y
	 * las edges
	 * 
	 * @param EdgeId           ID que se le dará a las edges
	 * @param VertexListA_Id ID del vértice del cuál se parte
	 * @param VertexListB_Id ID del vértice de llegada
	 * @param journeyDistance   La distancia que hay entre el Vértice de partida
	 *                            y el v�rtice de llegada
	 */
	
        // CREA UNA NUEVA ARISTA
        public void newEdge(String EdgeId, int VertexListA_Id, int VertexListB_Id, double journeyDistance) {
               
		Edge edge = new Edge(EdgeId, vertexes.get(VertexListA_Id), vertexes.get(VertexListB_Id), journeyDistance);
		edges.add(edge);
	}

	/**
	 * Permite generar nuevos vértices para ser utilizados dentro del grafo
	 * 
	 * @param vertexId  ID del vértice que se desea cear
	 * @param externalNode Objeto externo que se desea insertar dentro del vértice
	 */
        
        //CREA NUEVO VÉRTICE
	public void newVertexNode(String vertexId, Place externalNode) {
		VertexNode<Place> vertex = new VertexNode<Place>(vertexId, externalNode);
		vertexes.add(vertex);
	}

	/**
	 * método para obtener el id según el string de un vértice
	 * 
	 * @param vertexId id del vértice buscado
	 * @return vértice con el valor buscado
	 */
        
        //PARA OBTENER UN VÉRTICE POR ID
	public VertexNode<Place> getVertexNodeByUsing_Id(String vertexId) {
		VertexNode<Place> newVertex = null;
		for (VertexNode<Place> nestedVertex : vertexes) {
			if (nestedVertex.getVertexNodeId().equals(vertexId)) {
				newVertex = nestedVertex;
				return newVertex;
			}
		}
		return null;
	}
}