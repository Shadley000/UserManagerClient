/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.shadley000.usermanagerclient;

import com.shadley000.restClient.RestClient;
import com.shadley000.userManagerClient.NoConnectionException;
import com.shadley000.userManagerClient.NotFoundException;
import com.shadley000.userManagerClient.TokenClient;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadl
 */
public class TokenTest {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main1(String[] args) {
       
        String serverURL = "http://localhost:51931/UserManager/webapi/token";
        String login = "shadley000";
        String password = "password1";
        try {
            RestClient restClient = new RestClient();
            URL url1 = new URL(serverURL+"/users/"+login+"?password="+password);
            String response1 = restClient.get(url1);
            try {
                Long token = new Long(response1);
                System.out.println("Token recieved:" + token);

                URL url2 = new URL(serverURL+"/userIDs/" + token);
                String response2 = restClient.get(url2);
                Long userId = new Long(response2);
                System.out.println("userId recieved:" + userId);
            } catch (NumberFormatException ex) {
                System.out.println("Token failed:" + response1);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public static void main(String[] args) {
       
        String serverURL = "http://localhost:51931/UserManager/webapi/token";
        String login = "shadley000";
        String password = "password1";
        
        TokenClient tokenClient = new TokenClient(serverURL);
        
        
        long token;
        try {
            token = tokenClient.getToken(login, password);
            System.out.println("Token recieved:" + token);
            long userId = tokenClient.getUserId(token);
            System.out.println("userId recieved:" + userId);
        } catch (NoConnectionException ex) {
            Logger.getLogger(TokenTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(TokenTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
     }
     
}
