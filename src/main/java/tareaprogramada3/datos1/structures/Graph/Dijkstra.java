package tareaprogramada3.datos1.structures.Graph;
import tareaprogramada3.datos1.administration.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Esta clase posee el comportamiento que tendrá el Dijkstra en el momento de
 * ser ejecutado
 * */
public class Dijkstra implements GraphBehavior<VertexNode<Place>> {
	private List<VertexNode<Place>> vertexNodes; // Listado de vertexNodes
	private List<Edge> edges; // Listado de edges
	private Set<VertexNode<Place>> visitedVertex; // Corresponde a vértices ya contados en un trayecto
	private Set<VertexNode<Place>> noVisitedVertex; // Corresponde a los vértices no contados en el trayecto
	private Map<VertexNode<Place>, VertexNode<Place>> neighbors; // Vértices neighbors del trayecto
	private Map<VertexNode<Place>, Double> distances; // Guarda la distancia de un vertex hacia todos los demás

	/**
	 * CONSTRUCTOR ComportamientoDijkstra Este constructor únicamente requiere de un
	 * graph para poder utilizarse Genera el comportamiento para dicho graph
	 * 
	 * @param Graph que se usará para el comportamiento 
	 */
        
	public Dijkstra(Graph graph) {
		this.vertexNodes = new ArrayList<VertexNode<Place>>(graph.getVertexNodes());
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}

	// GETTERS AND SETTERS
	public List<VertexNode<Place>> getVertexNodes() {
		return vertexNodes;
	}

	public void setVertexNodes(List<VertexNode<Place>> vertexNodes) {
		this.vertexNodes = vertexNodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Set<VertexNode<Place>> getVisitedVertexNode() {
		return visitedVertex;
	}

	public void setVisitedVertexNode(Set<VertexNode<Place>> visitedVertex) {
		this.visitedVertex = visitedVertex;
	}

	public Set<VertexNode<Place>> getnoVisitedVertexNode() {
		return noVisitedVertex;
	}

	public void setnoVisitedVertexNode(Set<VertexNode<Place>> noVisitedVertex) {
		this.noVisitedVertex = noVisitedVertex;
	}

	public Map<VertexNode<Place>, VertexNode<Place>> getPredecesores() {
		return neighbors;
	}

	public void setPredecesores(Map<VertexNode<Place>, VertexNode<Place>> neighbors) {
		this.neighbors = neighbors;
	}

	public Map<VertexNode<Place>, Double> getDistances() {
		return distances;
	}

	public void setDistancias(Map<VertexNode<Place>, Double> distances) {
		this.distances = distances;
	}

	/**
	 * Permite averiguar si un vertex se encuentra ya contado dentro del stroke
	 * 
	 * @param vertex
	 *            nodo que se desea comparar
	 * @return True si se encuentra dentro de los nodos controlados
	 */
	private boolean isVisited(VertexNode<Place> vertex) {
		return visitedVertex.contains(vertex);
	}

	/**
	 * Obtiene la distancia de los destinos dentro del trayecto
	 * 
	 * @param T_Destiny
	 *            Nodo hacia el cual se desea ir
	 * @return La distancia entre v�rtices de la edge
	 */
        
        
        //RETORNA CAMINO MÁS CORTO
	private double getShortestDistance(VertexNode<Place> T_Destiny) {
		Double dist = distances.get(T_Destiny);
		if (dist == null)
			return Double.MAX_VALUE;
		return dist;
	}

	/**
	 * Permite obtener la distancia más corta de un vertex a otro
	 * 
	 * @param vertexNodes
	 *            este set permite generar un listado de los diferentes nodos
	 *            mapeados para configurar la salida más corta
	 * @return Los v�rtices por los cuales es más corto el camino
	 */
	private VertexNode<Place> getMinimium(Set<VertexNode<Place>> vertexNodes) {
		VertexNode<Place> minimium = null;
		for (VertexNode<Place> vertex : vertexNodes) {
			if (minimium == null)
				minimium = vertex;
			else {
				if (getShortestDistance(vertex) < getShortestDistance(minimium))
					minimium = vertex;
			}
		}
		return minimium;
	}

	/**
	 * Permite obtener los neighbors de un stroke desde un punto a otro del graph
	 * 
	 * @param T_VertexNode
	 *            Que funcionará como centroide para obtener sus neighbors
	 * @return Listado de vértices que conforman un camino en común
	 */
	private List<VertexNode<Place>> getNeighbors(VertexNode<Place> T_VertexNode) {
		List<VertexNode<Place>> neighbors = new ArrayList<VertexNode<Place>>();
		for (Edge edge : edges) {
			if (edge.getStart().equals(T_VertexNode) && !isVisited(edge.getEnd()))
				neighbors.add(edge.getEnd());
		}
		return neighbors;
	}

	/**
	 * Obtiene la distancia entre 2 vertexNodes de ubicaciones distintas
	 * 
	 * @param partida
	 *            Vértice del cuál se parte
	 * @param llegada
	 *            Vértice de destino
	 * @return La distancia para ser guardada dentro de las distances como una
	 *         longitud
	 */
	private double getDistance(VertexNode<Place> partida, VertexNode<Place> llegada) {
		for (Edge edge : edges) {
			if (edge.getStart().equals(partida) && edge.getEnd().equals(llegada))
				return edge.getSize();
		}
		throw new RuntimeException("Not possible to get the distance, vertexes are not linked");
	}

	/**
	 * Permite generar la distancia más corta entre 2 vertexNodes. Esta distancia está
	 * dada por medio del conjunto de infotmaición de los métodos anteriores
	 * 
	 * @param T_VertexNode
	 *            Vértice del cual se desea obtener una distancia mínima
	 */
	private void getMinimiumDistance(VertexNode<Place> T_VertexNode) {
		List<VertexNode<Place>> vertexNeighbors = getNeighbors(T_VertexNode);
		for (VertexNode<Place> destinyVertex : vertexNeighbors) {
			if (getShortestDistance(destinyVertex) > getShortestDistance(T_VertexNode) + getDistance(T_VertexNode, destinyVertex)) {
				distances.put(destinyVertex,
						getShortestDistance(T_VertexNode) + getDistance(T_VertexNode, destinyVertex));
				neighbors.put(destinyVertex, T_VertexNode);
				noVisitedVertex.add(destinyVertex);
			}
		}
	}

	/**
	 * Este método permite generar un mapeo general a partir de un nodo centroide.
	 * Este centroide será el nodo de partida y todos los demás nodos serán los de
	 * llegada. De manera automática se podran obtener las diferentes distances
	 * hacia cada uno de los nodos.
	 * 
	 * Este métodos se debe ejecutar antes que getListedRoute().
	 */
	public void runGraph(VertexNode<Place> T_VertexNode) {
		visitedVertex = new HashSet<VertexNode<Place>>();
		noVisitedVertex = new HashSet<VertexNode<Place>>();
		distances = new HashMap<VertexNode<Place>, Double>();
		neighbors = new HashMap<VertexNode<Place>, VertexNode<Place>>();
		distances.put(T_VertexNode, 0.0);
		noVisitedVertex.add(T_VertexNode);
		while (noVisitedVertex.size() > 0) {
			VertexNode<Place> vertex = getMinimium(noVisitedVertex);
			visitedVertex.add(vertex);
			noVisitedVertex.remove(vertex);
			getMinimiumDistance(vertex);
		}
	}

	/**
	 * Permite generar un listado de nodos mediante los cuales se llegará al destino
	 * mediante una distancia más corta.
	 * 
	 * Este método debe ejecutarse desupués de runGraph();
	 * 
	 * @param T_Destiny
	 *            Corresponde al vértice destino al cuál se desea llegar a partir de
	 *            uno conocido
	 */
	public LinkedList<VertexNode<Place>> getListedRoute(VertexNode<Place> T_Destiny) {
		LinkedList<VertexNode<Place>> DijkstraRoute = new LinkedList<VertexNode<Place>>();
		VertexNode<Place> stroke = T_Destiny;
		if (neighbors.get(stroke) == null)
			return null;
		DijkstraRoute.add(stroke);
		while (neighbors.get(stroke) != null) {
			stroke = neighbors.get(stroke);
			DijkstraRoute.add(stroke);
		}                
                Collections.reverse(DijkstraRoute);
		return DijkstraRoute;
	}
}
