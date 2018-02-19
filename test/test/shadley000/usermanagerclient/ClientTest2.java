/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.shadley000.usermanagerclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author shadl
 */
public class ClientTest2 {

    public static void main(String arg[]) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String retVal = null;
        try {
            URL resetEndpoint = new URL("http://localhost:8080/v1/books");
            connection = (HttpURLConnection) resetEndpoint.openConnection();
            //Set request method to GET as required from the API
            connection.setRequestMethod("GET");

            // Read the response
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonSb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonSb.append(line);
            }
            retVal = jsonSb.toString();

            // print out the json response
            System.out.println(retVal);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
