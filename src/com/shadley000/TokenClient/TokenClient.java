/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.TokenClient;

import com.shadley000.restClient.RestClient;
import com.shadley000.restClient.NoConnectionException;
import com.shadley000.restClient.NotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadl
 */
public class TokenClient {
    
    String serverURL;
    public TokenClient(String serverURL)
    {
        this.serverURL = serverURL;
        
    }
    
    public long getToken(String login,String password) throws NoConnectionException, NotFoundException
    {   RestClient restClient = new RestClient();
        URL url1;
        try {
            url1 = new URL(serverURL+"/users/"+login+"?password="+password);
        
            String response1 = restClient.get(url1);
            try {
                Long token = new Long(response1);
                return token;               
            } catch (NumberFormatException ex) {
                throw new NotFoundException();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(TokenClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new NoConnectionException();
        } catch (IOException ex) {
            Logger.getLogger(TokenClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new NoConnectionException();
        }
        
    }
    
    public long getUserId(long token) throws NoConnectionException, NotFoundException
    {
        RestClient restClient = new RestClient();
        URL url1;
        try {
            url1 = new URL(serverURL+"/userIDs/" + token);
        
            String response1 = restClient.get(url1);
            try {
                Long userId = new Long(response1);
                return userId;               
            } catch (NumberFormatException ex) {
                throw new NotFoundException();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(TokenClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new NoConnectionException();
        } catch (IOException ex) {
            Logger.getLogger(TokenClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new NoConnectionException();
        }
    }
    
}
