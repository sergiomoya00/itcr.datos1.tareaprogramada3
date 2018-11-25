package tareaprogramada3.datos1.structures.Graph;

import tareaprogramada3.datos1.administration.*;

/**
 * Esta clase posee el comportamiento que tendrá el Dijkstra en el momento de
 * ser ejecutado
 */
public class Edge {

    private String EdgeId;
    private VertexNode<Place> start;
    private VertexNode<Place> end;
    private double size;

    /**
     * constructor
     *
     * @param T_EdgeId id de la arista
     * @param T_Start punto de partida (vértice)
     * @param T_End punto de llegada (vértice)
     * @param T_Size peso de la relación
     */
    public Edge(String T_EdgeId, VertexNode<Place> T_Start, VertexNode<Place> T_End, double T_Size) {
        this.EdgeId = T_EdgeId;
        this.start = T_Start;
        this.end = T_End;
        this.size = T_Size;
    }

    /**
     * get para arista
     *
     * @return arista
     */

    public String getEdgeId() {
        return EdgeId;
    }

    /**
     * set para id de arista
     *
     * @param EdgeId id de arista nuevo
     */
    public void setEdgeId(String EdgeId) {
        this.EdgeId = EdgeId;
    }

    /**
     * get del punto de partida
     *
     * @return punto de partida (vértice)
     */
    public VertexNode<Place> getStart() {
        return start;
    }

    /**
     * set del punto de partida
     *
     * @param start nuevo vértice
     */
    public void setStart(VertexNode<Place> start) {
        this.start = start;
    }

    /**
     * get del punto de llegada
     *
     * @return punto de llegada(vértice)
     */
    public VertexNode<Place> getEnd() {
        return end;
    }

    /**
     * set del punto de llegada
     *
     * @param end punto nuevo de llegada (vértice)
     */
    public void setEnd(VertexNode<Place> end) {
        this.end = end;
    }

    /**
     * get del peso de la arista
     *
     * @return peso
     */
    public double getSize() {
        return size;
    }

    /**
     * set de la size de la arista
     *
     * @param size peso nuevo de la arista
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * método para obtener un string con todas la variables
     *
     * @return string con variables de la instancia
     */
    public String toString() {
        String message = "";
        
        message += "ID: " + EdgeId + "\n";
        message += "Start: \n";
        message += start.toString();
        message += end.toString();
        message += "Size: " + size;

        return message;
    }

}
