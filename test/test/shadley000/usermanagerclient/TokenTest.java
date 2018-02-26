/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.shadley000.usermanagerclient;

import com.shadley000.restClient.NoConnectionException;
import com.shadley000.restClient.NotFoundException;
import com.shadley000.TokenClient.TokenClient;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadl
 */
public class TokenTest {

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
