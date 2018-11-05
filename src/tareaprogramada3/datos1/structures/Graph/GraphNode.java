/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.structures.Graph;

public class GraphNode<T> {
    public int vertex;      //  Keeps the data of the vertex
    public T weight;      // Keeps the weight of the edge

        //Constructor of GraphNode
    public GraphNode(){
        this.vertex = 0;
        this.weight = null;
    }
   
    //Constructor of the GraphNode using the data of vertex end the weight of edge 
    public GraphNode(int v, T w){
        this.vertex = v;
        this.weight = w;
    }

    public String toStringGraphNode() {
        return "GraphNode{" + "vertex=" + vertex + ", weight=" + weight + '}';
    }
}//fin class Nodo
