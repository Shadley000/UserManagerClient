/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.shadley000.usermanagerclient;


import com.shadley000.TokenClient.TokenClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadl
 */
public class TokenTest {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("USAGE: test.shadley000.usermanagerclient DBUrl user password");
            return;
        }
        String serverURL = args[0];
        String login = args[1];
        String password = args[2];

        TokenClient tokenClient = new TokenClient(serverURL);

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

        } catch (IOException ex) {
            Logger.getLogger(TokenTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
