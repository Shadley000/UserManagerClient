/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.shadley000.usermanagerclient;

import com.shadley000.usermanagerclient.UserManagerClient;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

/**
 *
 * @author shadl
 */
public class ClientTest {
     public static void main(String[] args) {
/*
        if(args.length!=2)
        {   System.out.println("Usage com.shadley000.usermanagerclient.UserManagerClient login password");
            
            return;
        }
        String login = args[0];
        String password = args[1];
        */
        String login = "shadley000";
        String password = "password1";                

        try {
            UserManagerClient userManagerClient = new UserManagerClient("http://localhost:51931/UserManager/webapi/users/");
            Set<Integer> permissionSet = userManagerClient.getPermissionsByLogin(login, password);
            System.out.println("User "+login+" has the following permissions");
            for(Integer i : permissionSet)
            {
                System.out.println("    "+i);
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
