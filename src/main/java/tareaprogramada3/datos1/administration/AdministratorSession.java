/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.administration;

import tareaprogramada3.datos1.structures.Tree.BinarySearchTree;
import tareaprogramada3.datos1.structures.Graph.*;

public class AdministratorSession {

    private static final AdministratorSession instance = new AdministratorSession();

    public static AdministratorSession getInstance() {
        return instance;
    }

    BinarySearchTree<Clients> clients = new BinarySearchTree<>();

    public boolean insertClients(Clients newClient) {
        clients.insertarNodo(newClient);
        return true;
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
    // Luego se inicializa el grafo que actuara directamente sobre las listas del
    // controlador
    
    Grafo grafo = new Grafo(sites.getVertices(), sites.getAristas());
    //System.out.println(grafo.toString());

    // Por �ltimo se utliza el Dijkstra para obtener la ruta m�s corta de un punto a
    // otro
    
    
    Dijkstra shortestRoute = new Dijkstra(grafo);
    
    public void showBestRoute(){
        shortestRoute.ejecutarGrafo(shortestRoute.getVertices().get(0));
    
    }
    
    
    ///OBTIENE LAS DISTANCIAS A TODOS LOS VERTICES A PARTIR DEL GET(NUM) anterior
    public void showDistancesFromASite(){
        System.out.println(shortestRoute.getDistancias().toString());
    }

    ///OBTIENE EL CAMINO M�S CORTO A PARTIR DE get(0) a get(4) EN ESTE CASO , puede ser cualquiera
    public void shortestRouteFront2Points(){
        System.out.println(shortestRoute.obtenerListadoCamino(shortestRoute.getVertices().get(3))); //El get(3) puede cambiar
    }
		
    //Obtener la distancia entre dos v�rtices
    public void DistanceFrom2Points(){
        double distanciaMinima = shortestRoute.getDistancias().get(shortestRoute.getVertices().get(3));
        System.out.println(distanciaMinima);
    }
    
    
    

}
