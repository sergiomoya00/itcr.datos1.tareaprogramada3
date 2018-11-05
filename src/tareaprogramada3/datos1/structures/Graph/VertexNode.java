
package tareaprogramada3.datos1.structures.Graph;
import java.util.*;

public class VertexNode {
    
    public int vertex;            //Keeps the data of vertex
    public boolean visited;       //Indicates if the vertex is being visisted 
    public LinkedList <GraphNode> edge;  //Keeps the edge list of vertex

    public VertexNode(){
        this.vertex = 0;
        this.visited = false;
        this.edge  = new LinkedList<GraphNode>();
    } 
    
    public VertexNode(int v){
            this.vertex = v;
            this.visited = false;
            this.edge  = new LinkedList<GraphNode>();
    }

    public String toStringVertexNode() {
        return "VertexNode{" + "vertex=" + vertex + ", visited=" + visited + ", edge=" + edge + '}';
    }
    
    

}