/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.userManagerClient.beans;

import org.json.JSONObject;

/**
 *
 * @author shadl
 */
public class Application {

    String applicationId;
    String name;
    String description;

    public Application() {
    }

    public Application(JSONObject json) {
        applicationId = json.getString("applicationId");
        name = json.getString("name");
        description = json.getString("description");

    }

    public Application(String applicationId, String name, String description) {
        this.applicationId = applicationId;
        this.name = name;
        this.description = description;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
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
