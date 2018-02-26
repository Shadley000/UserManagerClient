package test.shadley000.usermanagerclient;

import com.shadley000.TokenClient.TokenClient;
import com.shadley000.restClient.NoConnectionException;
import com.shadley000.restClient.NotFoundException;
import com.shadley000.userManagerClient.UsersManagerClient;
import com.shadley000.userManagerClient.beans.Application;
import com.shadley000.userManagerClient.beans.Role;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersManagerClientTest {

    public static void main(String[] args) {

        try {
            TokenClient tokenClient = new TokenClient("http://localhost:51931/UserManager/webapi/token");

            // simulate login from the browser
            Long token = null; {
                token = tokenClient.getToken("shadley000", "password1");
                System.out.println("Token recieved:" + token);
                long userId = tokenClient.getUserId(token);
                System.out.println("userId recieved:" + userId);
            }

            // simulate a request from installations server
            if (token != null) {
                long userId = tokenClient.getUserId(token);
                UsersManagerClient client = new UsersManagerClient("http://localhost:51931/UserManager/webapi/users", token);

                Application application = client.getApplication("A6 Alarm Manager");
                List<Role> rolelist = client.getRolesByUser(application.getApplicationId(), userId);
            
                //i now have my userID, token, role

            }
        } catch (NoConnectionException ex) {
            Logger.getLogger(TokenTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(TokenTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UsersManagerClientTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
