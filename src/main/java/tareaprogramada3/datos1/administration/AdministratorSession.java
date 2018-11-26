/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.administration;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import tareaprogramada3.datos1.structures.Tree.BinarySearchTree;
import tareaprogramada3.datos1.structures.Graph.*;
import tareaprogramada3.datos1.structures.Graph.Dijkstra;

public class AdministratorSession {

    private static final AdministratorSession instance = new AdministratorSession();

    public static AdministratorSession getInstance() {
        return instance;
    }

    BinarySearchTree<Clients> clients = new BinarySearchTree<>();

    public void insertClients(Clients newClient) {
        clients.insertNode(newClient);
    }

    public boolean verifyClient(Clients searchTo) {  //Search Node
        if (clients.searchNode(searchTo)) {
            return true;
        }
        return false;
    }

    public Clients getClient(Clients clientToGet) {
        return clients.getNode(clientToGet);
    }

    public Clients deleteClients(Clients clientToDelete) {
        if (verifyClient(clientToDelete)) {
            clients.deleteNode(clientToDelete);
        }
        return null;
    }

    GraphLeader sites = new GraphLeader();

    //Add a place to a vertex
    public void newVertexForPlaces(String name, Place node) {
        sites.newVertexNode(name, node);
    }

    //Add an edge 
    public void addEdge(String name, int id_A, int id_B, long distance) {
        sites.newEdge(name, id_A, id_B, distance);
    }

    //Get the information from a place
    public VertexNode<Place> getPlaceInfo(String name) {
        return sites.getVertexNodeByUsing_Id(name);
    }
    // Luego se inicializa el grafo que actuara directamente sobre las listas del
    // controlador

    Graph graphForSites = new Graph(sites.getVertexNodes(), sites.getEdges());
    //System.out.println(grafo.toString());

    // Por �ltimo se utliza el Dijkstra para obtener la ruta m�s corta de un punto a
    // otro
    Dijkstra shortestRoute = new Dijkstra(graphForSites);

    public void showBestRoute() {
        shortestRoute.runGraph(shortestRoute.getVertexNodes().get(0));

    }

    ///OBTIENE LAS DISTANCIAS A TODOS LOS VERTICES A PARTIR DEL GET(NUM) anterior
    public void showDistancesFromASite() {
        System.out.println(shortestRoute.getDistances().toString());
    }

    ///OBTIENE EL CAMINO M�S CORTO A PARTIR DE get(0) a get(4) EN ESTE CASO , puede ser cualquiera
    public void shortestRouteFront2Points() {
        System.out.println(shortestRoute.getListedRoute(shortestRoute.getVertexNodes().get(3))); //El get(3) puede cambiar
    }
    double distanciaMinima = shortestRoute.getDistances().get(shortestRoute.getVertexNodes().get(3));

    //Obtener la distancia entre dos v�rtices
    public void DistanceFrom2Points() {
        double distanciaMinima = shortestRoute.getDistances().get(shortestRoute.getVertexNodes().get(3));
        System.out.println(distanciaMinima);
    }

    private static GraphLeader sitesForClient;
    private static Graph graphSitesForClient;
    private static Dijkstra dijkstraSubgraph;

//Añadir un lugar al subgrafo
    public void addPlaceSubgraph(String name, Place node) {
        sitesForClient.newVertexNode(name, node);
    }

    ///OBTIENE LAS DISTANCIAS A TODOS LOS VERTICES A PARTIR DEL GET(NUM) anterior
    public void showDistancesFromASiteSubgraph() {
        graphSitesForClient = new Graph(sitesForClient.getVertexNodes(), sitesForClient.getEdges());
        dijkstraSubgraph = new Dijkstra(graphSitesForClient);
        System.out.println(shortestRoute.getDistances().toString());
    }

    //Add an edge 
    public void addEdgeSubgraph(String name, int id_A, int id_B, long distance) {
        sitesForClient.newEdge(name, id_A, id_B, distance);
    }

    public void runSubgraph(VertexNode<Place> site) {
        graphSitesForClient = new Graph(sitesForClient.getVertexNodes(), sitesForClient.getEdges());
        dijkstraSubgraph = new Dijkstra(graphSitesForClient);
        dijkstraSubgraph.runGraph(site);
    }

    public LinkedList<VertexNode<Place>> getListedRouteSubgraph(VertexNode<Place> T_Destiny) {
        graphSitesForClient = new Graph(sitesForClient.getVertexNodes(), sitesForClient.getEdges());
        dijkstraSubgraph = new Dijkstra(graphSitesForClient);
        return dijkstraSubgraph.getListedRoute(T_Destiny);
    }

    ///OBTIENE LAS DISTANCIAS A TODOS LOS VERTICES A PARTIR DEL GET(NUM) anterior
    public void getDistancesFrom1Point() {
        graphSitesForClient = new Graph(sitesForClient.getVertexNodes(), sitesForClient.getEdges());
        dijkstraSubgraph = new Dijkstra(graphSitesForClient);
        System.out.println(dijkstraSubgraph.getDistances().toString());
    }

    ///OBTIENE EL CAMINO M�S CORTO A PARTIR DE get(0) a get(4) EN ESTE CASO , puede ser cualquiera
    public void getListedRouteFromSpecificPoints() {
        graphSitesForClient = new Graph(sitesForClient.getVertexNodes(), sitesForClient.getEdges());
        dijkstraSubgraph = new Dijkstra(graphSitesForClient);
        System.out.println(dijkstraSubgraph.getListedRoute(dijkstraSubgraph.getVertexNodes().get(3)));
    }

    //Obtener la distancia entre dos v�rtices
    //limit es hasta donde va a agarrar la distancia
    public void getDistanceBetween2Points(int limit) {
        graphSitesForClient = new Graph(sitesForClient.getVertexNodes(), sitesForClient.getEdges());
        dijkstraSubgraph = new Dijkstra(graphSitesForClient);
        double distanciaMinima = dijkstraSubgraph.getDistances().get(dijkstraSubgraph.getVertexNodes().get(limit));
        System.out.println(distanciaMinima);
    }

    List<Place> places = new ArrayList<>();

    public void addPlace(Place newPlace) {
        this.places.add(newPlace);
    }

    public List<Place> getPlace() {
        return places;
    }

    public Collection<Place> getPlaces() {
        return places;
    }

    List<Route> routes = new ArrayList<>();

    public void addRoute(Route newRoute) {
        this.routes.add(newRoute);
    }

    public Collection<Route> getRoutes() {
        return routes;
    }

    public List<Route> getRoute() {
        return routes;
    }

}
