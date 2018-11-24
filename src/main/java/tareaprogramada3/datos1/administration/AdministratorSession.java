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
    
    	private static ControladorGrafo graphControl;
	private static Grafo graph;
	private static Dijkstra dijkstra;
        
        ControladorGrafo places = new ControladorGrafo();
        
        
        BinarySearchTree<Clients> clients = new BinarySearchTree<>();
        
        public boolean insertClients(Clients newClient){
            clients.insertarNodo(newClient);
            return true;
        }
        
        public boolean verifyClient (Clients searchTo){  //Search Node
            if (clients.buscarNodo(searchTo)){
                return true;
            }
            return false;
        }
        
        	//public X getNode(X toSearch) {
        
       // public Clients getClient (Clients clientToGet){
            
       // }
        
        public Clients deleteClients(Clients clientToDelete){
            if (verifyClient(clientToDelete)){
                clients.eliminarNodo(clientToDelete);
            }
            return null;
	}
       }
        
        
        
        
        
        //Además, se debe registrar el nombre del sitio, una descripción del lugar, las actividades que se
        //pueden realizar en este sitio y el precio de la estadía en este lugar por persona por día.


    
        
        
        
        
        
        
        
        

