package com.shadley000.userManagerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;


public class UserManagerClient {

    String baseUrl;

    public UserManagerClient(String serverUrl) {
        this.baseUrl = serverUrl;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public Set<Integer> getPermissionsByLogin(String login, String password) throws MalformedURLException, IOException {
        URL url = new URL(baseUrl + "auth/"+login+"?password="+password);
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        String data = readAll(new BufferedReader(new InputStreamReader((conn.getInputStream()))));
        //System.out.println(data);
        JSONArray json = new JSONArray(data);
        conn.disconnect();
        
        Set<Integer> permissionSet = new HashSet<>();
        
        for(int i=0;i<json.length();i++)
        {   Integer permissionId = json.getInt(i);
            permissionSet.add(permissionId);
        }
        return permissionSet;
    }

}
