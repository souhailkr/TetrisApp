package com.example.tetrisapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("login")
    @Expose
    private String loginName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + loginName + '\'' +
                '}';
    }
}
