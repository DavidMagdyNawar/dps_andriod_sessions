package com.dps.model;

public class SoftwareEngineer {
    String name;
    String title;
    String image;

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(String name, String title, String image) {

        this.name = name;
        this.title = title;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
