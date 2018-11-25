package tareaprogramada3.datos1.structures.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tareaprogramada3.datos1.administration.Place;


/**
 * clase para controlar el grafo
 */
public class ControladorGrafo {
    
        
	private List<Vertice<Place>> vertices;
	private List<Arista> aristas;
	private LinkedList<Vertice<Place>> trazo;

	/**
	 * Al generar el contructor se inicializan y se crean objetos de las 3 listas
	 * necesarias.
	 */
	public ControladorGrafo() {
		this.vertices = new ArrayList<Vertice<Place>>();
		this.aristas = new ArrayList<Arista>();
		this.trazo = new LinkedList<Vertice<Place>>();
	}

	/**
	 * método para obtener el trazo del grafo
	 * 
	 * @return trazo con camino
	 */
        
        public LinkedList<Vertice<Place>> getTrazo() {
		return trazo;
	}

	/**
	 * método para ingresar nuevo trazo
	 * 
	 * @param trazo trazo por ingresar
	 */
	public void setTrazo(LinkedList<Vertice<Place>> trazo) {
		this.trazo = trazo;
	}

	/**
	 * método para obtener vertices
	 * 
	 * @return vertices del grafo
	 */
	public List<Vertice<Place>> getVertices() {
		return vertices;
	}

	/**
	 * método para configurar vertices
	 * 
	 * @param vertices vertices nuevas para el grafo
	 */
	public void setVertices(List<Vertice<Place>> vertices) {
		this.vertices = vertices;
	}

	/**
	 * método para obtener aristas
	 * 
	 * @return aristas
	 */
	public List<Arista> getAristas() {
		return aristas;
	}

	/**
	 * MÉtodo para ingresar aristas al grafo
	 * 
	 * @param aristas nuevas aristas
	 */
	public void setAristas(List<Arista> aristas) {
		this.aristas = aristas;
	}

	/**
	 * Permite generar relaciones entre los v�rtices (que deben ser existentes) y
	 * las aristas
	 * 
	 * @param id_arista           ID que se le dará a las aristas
	 * @param id_lista_vertices_A ID del vértice del cuál se parte
	 * @param id_lista_vertices_B ID del vértice de llegada
	 * @param distanciaTrayecto   La distancia que hay entre el Vértice de partida
	 *                            y el v�rtice de llegada
	 */
	
        // CREA UNA NUEVA ARISTA
        public void nuevaArista(String id_arista, int id_lista_vertices_A, int id_lista_vertices_B, double distanciaTrayecto) {
               
		Arista arista = new Arista(id_arista, vertices.get(id_lista_vertices_A), vertices.get(id_lista_vertices_B), distanciaTrayecto);
		aristas.add(arista);
	}

	/**
	 * Permite generar nuevos vértices para ser utilizados dentro del grafo
	 * 
	 * @param id_vertice  ID del vértice que se desea cear
	 * @param nodoExterno Objeto externo que se desea insertar dentro del vértice
	 */
        
        //CREA NUEVO VÉRTICE
	public void nuevoVertice(String id_vertice, Place nodoExterno) {
		Vertice<Place> vertice = new Vertice<Place>(id_vertice, nodoExterno);
		vertices.add(vertice);
	}

	/**
	 * método para obtener el id según el string de un vértice
	 * 
	 * @param id_vertice id del vértice buscado
	 * @return vértice con el valor buscado
	 */
        
        //PARA OBTENER UN VÉRTICE POR ID
	public Vertice<Place> obtenerVerticePorID(String id_vertice) {
		Vertice<Place> verticeNuevo = null;
		for (Vertice<Place> verticeAnidado : vertices) {
			if (verticeAnidado.getId().equals(id_vertice)) {
				verticeNuevo = verticeAnidado;
				return verticeNuevo;
			}
		}
		return null;
	}
}