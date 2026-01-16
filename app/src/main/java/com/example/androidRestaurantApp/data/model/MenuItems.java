package com.example.androidRestaurantApp.data.model;

public class MenuItems {

    private int id;

    private String name;

    private String description;

    private double price;

    private String imageLink;

    // empty constructor (needed for Retrofit/Gson sometimes)
    public MenuItems() {

    }

    // constructor for fallback menu items + quick testing
    public MenuItems(String name, double price) {

        this.name = name;
        this.price = price;

    }

    // getters
    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public double getPrice() {

        return price;
    }

    public String getImageLink() {

        return imageLink;
    }

    // setters
    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public void setImageLink(String imageLink) {

        this.imageLink = imageLink;
    }

    //these are parameters for data for Menuitems.

}
