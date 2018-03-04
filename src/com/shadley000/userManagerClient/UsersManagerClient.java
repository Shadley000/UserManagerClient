package com.shadley000.userManagerClient;

import com.shadley000.restClient.NotFoundException;
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

    String baseUrl;
    long token;

    public UsersManagerClient(String serverUrl, long token) {
        this.baseUrl = serverUrl;
        this.token = token;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public Application getApplicationByID(Long id) throws NotFoundException, MalformedURLException, IOException {
        return getApplication(""+id);
    }
    public Application getApplication(String name) throws NotFoundException, MalformedURLException, IOException {
        URL url = new URL(baseUrl + "applications/" + name + "?token=" + token);
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new IOException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        String data = readAll(new BufferedReader(new InputStreamReader((conn.getInputStream()))));
        //System.out.println(data);
        JSONObject json = new JSONObject(data);
        conn.disconnect();

        return new Application(json);
    }

    public List<Role> getRolesByUser(long applicationId, long userId) throws NotFoundException, MalformedURLException, IOException {               
        URL url = new URL(baseUrl + "/" + userId + "/applications/" + applicationId + "/role?token=" + token);
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new IOException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        String data = readAll(new BufferedReader(new InputStreamReader((conn.getInputStream()))));
        //System.out.println(data);
        JSONArray json = new JSONArray(data);
        conn.disconnect();

        List<Role> roleList = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            roleList.add(new Role(json.getJSONObject(i)));
        }
        return roleList;
    }

}
