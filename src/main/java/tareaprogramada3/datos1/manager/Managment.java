/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.manager;
import tareaprogramada3.datos1.administration.*;

public class Managment {
    
    private static final AdministratorSession instance = new AdministratorSession();
    public static AdministratorSession getInstance() {
        return instance;
    }
}
