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
public class Users {
    long usersId;
    String login;
    String password;
    String firstName;
    String lastName;
    String email;
    boolean confirmed;

    public Users() {
    }
    
    public Users(JSONObject json) {
         this.usersId = json.getLong("usersId");
        this.login = json.getString("login");
        this.password = json.getString("password");
        this.firstName = json.getString("firstName");
        this.lastName = json.getString("lastName");
        this.email = json.getString("email");
        this.confirmed = json.getBoolean("confirmed");
    }

    public Users(ResultSet rs) throws SQLException {
        this.usersId = rs.getLong("users_id");
        this.login = rs.getString("login");
        this.password = rs.getString("password");
        this.firstName = rs.getString("firstName");
        this.lastName = rs.getString("lastName");
        this.email = rs.getString("email");
        this.confirmed = rs.getBoolean("confirmed");
        
    }
    public Users(long usersId, String login, String password, String firstName, String lastName, String email, boolean confirmed) {
        this.usersId = usersId;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.confirmed = confirmed;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
    
    
}
