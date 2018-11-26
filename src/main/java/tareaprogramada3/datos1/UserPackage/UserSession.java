/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.UserPackage;
import tareaprogramada3.datos1.administration.Clients;
import tareaprogramada3.datos1.structures.Graph.*;

public class UserSession implements Comparable<Clients> {
    
    private static final UserSession instance = new UserSession();
    
 
    public static UserSession getInstance() {
        return instance;
    }

    @Override
    public int compareTo(Clients o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
