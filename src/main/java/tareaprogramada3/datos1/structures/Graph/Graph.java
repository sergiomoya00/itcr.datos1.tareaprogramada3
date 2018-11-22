package tareaprogramada3.datos1.structures.Graph;

import java.util.*;
import tareaprogramada3.datos1.structuresInterface.GraphBehavior;

import tareaprogramada3.datos1.structuresInterface.StructuresInterface;

/**
 *
 * @author Milagro
 * @param <T>
 */
public class Graph<T> implements GraphBehavior<Comparable<T>> {

    public LinkedList<VertexNode> vertexes;  //List of vertex of the graph
    public LinkedList<VertexNode> edges;

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Comparable<T> element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable<T> remove(Comparable<T> element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable<T> search(Comparable<T> element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
