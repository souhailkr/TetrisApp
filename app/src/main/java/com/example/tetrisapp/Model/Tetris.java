package com.example.tetrisapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Tetris {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("full_name")
    @Expose
    private String full_name;

    @SerializedName("has_wiki")
    @Expose
    private boolean has_wiki;

    @SerializedName("size")
    @Expose
    private int size;

    @SerializedName("owner")
    @Expose
    Owner owner;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("created_at")
    @Expose
    private Date created_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public boolean isHas_wiki() {
        return has_wiki;
    }

    public void setHas_wiki(boolean has_wiki) {
        this.has_wiki = has_wiki;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Tetris{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", has_wiki=" + has_wiki +
                ", size=" + size +
                ", owner=" + owner +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
