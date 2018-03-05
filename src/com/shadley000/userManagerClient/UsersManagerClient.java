package com.shadley000.userManagerClient;

import com.shadley000.userManagerClient.beans.Application;
import com.shadley000.userManagerClient.beans.Role;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class UsersManagerClient {

    String applicationName;
    String applicationId;
    String userManagerUrl;
    String token;
    String user;
    String password;

    public UsersManagerClient(String userManagerUrl, String user, String password) {
        this.userManagerUrl = userManagerUrl;
        this.user = user;
        this.password = password;      
    }

    public void init() throws IOException {
        token = getToken(token, password);
        applicationId = getApplication(user).getApplicationId();
    }
    
    public String getToken(String login,String password) throws MalformedURLException, IOException 
    {   return get(new URL(userManagerUrl+"token/users/"+login+"?password="+password));         
    }
    
    public String getUserId(String token) throws MalformedURLException, IOException 
    {   return get(new URL(userManagerUrl+"token/userIDs/" + token));                   
    }

    public List<Role> getRolesByUser(String userId) throws MalformedURLException, IOException {
        String urlStr = userManagerUrl + "users/" + userId + "/applications/" + applicationId + "/role?token=";

        JSONArray json = new JSONArray(getWithTokenReset(urlStr));
        List<Role> roleList = new ArrayList<>();
        for (int i = 0; i < json.length(); i++) {
            roleList.add(new Role(json.getJSONObject(i)));
        }
        return roleList;
    }

    private Application getApplication(String name) throws MalformedURLException, IOException {
        String urlStr = userManagerUrl + "applications/" + name + "?token=";
        return new Application(new JSONObject(getWithTokenReset(urlStr)));
    }
    
    private String getWithTokenReset(String urlStr) throws MalformedURLException, IOException {
        URL url = new URL(urlStr + token);

        for (int i = 0; i < 3; i++) {
            try {
                return get(url);
            } catch (IOException e) {
                token = getToken(token, password);
                url = new URL(urlStr + token);
            }
        }
        throw new IOException("unable to get data from urlStr after 3 attempts");
    }

    private String get(URL url) throws MalformedURLException, IOException {
        System.out.println(url);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() == 200) {
            Reader rd = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String data = sb.toString();
            conn.disconnect();
            return data;
        } else if (conn.getResponseCode() == 403) {
            throw new IOException("Failed : Security Exception");
        } else {
            throw new IOException("Failed : HTTP error code : " + conn.getResponseCode());
        }

    }

}
