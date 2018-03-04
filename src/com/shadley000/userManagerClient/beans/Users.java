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
        this.password = json.getString("user_password");
        this.firstName = json.getString("first_name");
        this.lastName = json.getString("last_name");
        this.email = json.getString("email");
        this.confirmed = json.getBoolean("confirmed");
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
