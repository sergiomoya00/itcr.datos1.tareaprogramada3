/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.administration;

import tareaprogramada3.datos1.structures.Tree.BinarySearchTree;
import tareaprogramada3.datos1.structures.Graph.*;

/**
 *
 * @author
 */
public class AdministratorSession {

    BinarySearchTree<Clients> clients = new BinarySearchTree<>();

    public void insertClients(Clients newClient) {
        clients.insertarNodo(newClient);
    }

    public boolean verifyClient(Clients searchTo) {  //Search Node
        if (clients.buscarNodo(searchTo)) {
            return true;
        }
        return false;
    }

    public Clients getClient(Clients clientToGet) {
        return clients.getNode(clientToGet);
    }

    public Clients deleteClients(Clients clientToDelete) {
        if (verifyClient(clientToDelete)) {
            clients.eliminarNodo(clientToDelete);
        }
        return null;
    }
    //Además, se debe registrar el nombre del sitio, una descripción del lugar, las actividades que se
    //pueden realizar en este sitio y el precio de la estadía en este lugar por persona por día.

    ControladorGrafo sites = new ControladorGrafo();
    
    //Add a place to a vertex
    public void newVertexForPlaces(String name, Object node) {
        sites.nuevoVertice(name, node);
    }
    
    //Add an edge 
    public void addEdge(String name, int idA, int idB, double distance) {
        sites.nuevaArista(name, idA, idB, distance);
    }

    //Get the information from a place
    public void getPlaceInfo(String name) {
        sites.obtenerVerticePorID(name);

    }
    
    // Luego se inicializa el grafo que actuar� directamente sobre las listas del
    // controlador
    grafo = new Grafo(sites.getVertices(), sites.getAristas());
    //System.out.println(grafo.toString());

    
   
}