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
public class Role {

    long roleId;
    long applicationId;
    String roleTypeName;
    String name;
    String ud1;

    public Role() {
    }

    public Role(JSONObject json) {
        this.roleId = json.getLong("roleId");
        this.applicationId = json.getLong("applicationId");
        this.roleTypeName = json.getString("roleTypeName");
        this.name = json.getString("name");
        this.ud1 = json.getString("ud1");
    }

    public Role(long roleId, long applicationId, String roleTypeName, String name, String ud1) {
        this.roleId = roleId;
        this.applicationId = applicationId;
        this.roleTypeName = roleTypeName;
        this.name = name;
        this.ud1 = ud1;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public String getRole_type_name() {
        return roleTypeName;
    }

    public void setRoleTypeName(String roleTypeName) {
        this.roleTypeName = roleTypeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUd1() {
        return ud1;
    }

    public void setUd1(String ud1) {
        this.ud1 = ud1;
    }

}
