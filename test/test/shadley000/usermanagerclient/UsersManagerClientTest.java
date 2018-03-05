/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.shadley000.usermanagerclient;

import com.shadley000.userManagerClient.UsersManagerClient;
import com.shadley000.userManagerClient.beans.Role;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadl
 */
public class UsersManagerClientTest {

    public static void main(String args[]) {

        UsersManagerClient client;
        if (args.length != 3) {
            System.out.println("USAGE: test.shadley000.usermanagerclient.UsersManagerClientTest url user password");
            return;
        } else {
            String url = args[0];
            String user = args[1];
            String password = args[2];
            client = new UsersManagerClient(url, user, password);
            
            try {
                client.init();
            } catch (IOException ex) {
                Logger.getLogger(UsersManagerClientTest.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

        }
        try {
            
            String testUser = "guest";
            String testPassword = "password";

            String testToken = client.getToken(testUser, testPassword);

            String userId = client.getUserId(testToken);

            List<Role> roles = client.getRolesByUser(userId);

        } catch (IOException ex) {
            Logger.getLogger(UsersManagerClientTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
