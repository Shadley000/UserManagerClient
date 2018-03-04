/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.TokenClient;

import com.shadley000.restClient.RestClient;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
    
    public String getToken(String login,String password) throws MalformedURLException, IOException 
    {   return new RestClient().get(new URL(serverURL+"/users/"+login+"?password="+password));
         
    }
    
    public String getUserId(String token) throws MalformedURLException, IOException 
    { return new RestClient().get(new URL(serverURL+"/userIDs/" + token));                   
    }
    
}
