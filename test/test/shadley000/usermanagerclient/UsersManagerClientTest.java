package test.shadley000.usermanagerclient;

import com.shadley000.TokenClient.TokenClient;
import com.shadley000.userManagerClient.UsersManagerClient;
import com.shadley000.userManagerClient.beans.Role;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsersManagerClientTest {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("USAGE: test.shadley000.usermanagerclient webserverURL user password");
            return;
        }
        String serverURL = args[0];
        String login = args[1];
        String password = args[2];
        
        TokenClient tokenClient = new TokenClient(serverURL+"/UserManager/webapi/token");

        String token;
        try {
            token = tokenClient.getToken(login, password);
            if (token != null) {
                System.out.println("Token recieved:" + token);
                String userId = tokenClient.getUserId(token);
                System.out.println("userId recieved:" + userId);
            } else {
                System.out.println("Unable to aquire token for " + login);
            }
     
            // simulate login from the browser
            {
                token = tokenClient.getToken(login, password);
                System.out.println("Token recieved:" + token);
                String userId = tokenClient.getUserId(token);
                System.out.println("userId recieved:" + userId);
            }

            // simulate a request from installations server
            {
                String userId = tokenClient.getUserId(token);
                UsersManagerClient client = new UsersManagerClient("Test",serverURL+"/UserManager/webapi/users", token);
                client.init();
                List<Role> rolelist = client.getRolesByUser(userId);
            
                //i now have my userID, token, role
            }
        } catch (IOException ex) {
            Logger.getLogger(UsersManagerClientTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
