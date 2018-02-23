package com.shadley000.restClient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RestClient {

    
    public RestClient() {
       
    }

    public String get(URL url) throws MalformedURLException, IOException {
        //System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        Reader rd = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        
        conn.disconnect();
        return sb.toString();
    }

}
