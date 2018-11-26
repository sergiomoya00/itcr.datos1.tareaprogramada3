/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.administration;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import tareaprogramada3.datos1.structures.Tree.BinarySearchTree;
import tareaprogramada3.datos1.structures.Graph.*;

public class AdministratorSession {

    private static final AdministratorSession instance = new AdministratorSession();

    public static AdministratorSession getInstance() {
        return instance;
    }

    BinarySearchTree<Clients> clients = new BinarySearchTree<>();

    public boolean insertClients(Clients newClient) {
        clients.insertNode(newClient);
        return true;
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

    //Obtener la distancia entre dos v�rtices
    public void DistanceFrom2Points() {
        double distanciaMinima = shortestRoute.getDistances().get(shortestRoute.getVertexNodes().get(3));
        System.out.println(distanciaMinima);
    }

    List<Place> places = new ArrayList<>();

    public void addPlace(Place newPlace) {
        this.places.add(newPlace);
    }

    /*
    public Collection<Place> search(Place newPlace) {
        List<Place> results = new ArrayList<>();

        boolean byName = newPlace.getName() != null && newPlace.getName().length() > 0;
        boolean byID = newPlace.getPlaceID()!= null && newPlace.getPlaceID().length() > 0;

        for (Place place : places) {
            boolean add = !(byName || byType);
            if (!add && byName && book.getName().contains(newBook.getName())) {
                add = true;
            }
            if (!add && byType && book.getTopic().contains(newBook.getTopic())) {
                add = true;
            }
            if (add) {
                results.add(book);
            }
        }

        return results;

    }
     */

    public Collection<Place> getPlaces() {
        return places;
    }

    public List<Place> getPlace() {
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
