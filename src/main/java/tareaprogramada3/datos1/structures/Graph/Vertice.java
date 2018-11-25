package tareaprogramada3.datos1.structures.Graph;

/**
 * Los v�rtices del Dijkstra son sus nodos de información, por lo que estos
 * pueden generar dependencia con otros objetos que se deseen ubicar al grafo.
 *
 * @param <Place>
 */
public class Vertice<Place> {
	private String id_vertice;
	private Place nodoInterno;

	// CONSTRUCTOR
	public Vertice(String pId, Place pNodoInterno) {
		this.id_vertice = pId;
		this.nodoInterno = pNodoInterno;
	}
	// GETTERS Y SETTERS

	public String getId() {
		return id_vertice;
	}

	public void setId(String id) {
		this.id_vertice = id;
	}

	public Place getNodoInterno() {
		return nodoInterno;
	}

	public void setNodoInterno(Place nodoInterno) {
		this.nodoInterno = nodoInterno;
	}

	@Override
        /**
         * método para obtener variables en string
         */
	public String toString() {
		String msj = "";
		msj += "V�rtice: ID:" + id_vertice + " ";
		msj += nodoInterno.toString();
		return msj;
	}
}