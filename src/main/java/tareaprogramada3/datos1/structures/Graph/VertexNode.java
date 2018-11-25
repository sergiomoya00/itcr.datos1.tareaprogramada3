package tareaprogramada3.datos1.structures.Graph;

/**
 * Los v�rtices del Dijkstra son sus nodos de información, por lo que estos
 * pueden generar dependencia con otros objetos que se deseen ubicar al grafo.
 *
 * @param <Place>
 */
public class VertexNode<Place> {
	private String VertexNodeId;
	private Place InternalNode;

	// CONSTRUCTOR
	public VertexNode(String T_id, Place T_internalNode) {
		this.VertexNodeId = T_id;
		this.InternalNode = T_internalNode;
	}
	// GETTERS Y SETTERS

	public String getVertexNodeId() {
		return VertexNodeId;
	}

	public void setVertexNodeId(String id) {
		this.VertexNodeId = id;
	}

	public Place getInternalNode() {
		return InternalNode;
	}

	public void setInternalNode(Place InternalNode) {
		this.InternalNode = InternalNode;
	}

	@Override
        /**
         * método para obtener variables en string
         */
	public String toString() {
		String message = "";
		
                message += "V�rtice: ID:" + VertexNodeId + " ";
		message += InternalNode.toString();
		
                return message;
	}
}