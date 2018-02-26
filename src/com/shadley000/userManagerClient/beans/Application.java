/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.userManagerClient.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONObject;

/**
 *
 * @author shadl
 */
public class Application {
      long applicationId;
    String name;
    String description;

    public Application() {
    }
    
     public Application(JSONObject json) {
         applicationId = json.getLong("applicationId");
         name = json.getString("name");
         description = json.getString("description");
         
    }

    public Application(long applicationId, String name, String description) {
        this.applicationId = applicationId;
        this.name = name;
        this.description = description;
    }
    
     public Application(ResultSet rs) throws SQLException {
        this.applicationId = rs.getLong("application_id");
        this.name = rs.getString("nname");
        this.description = rs.getString("description");
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
