package com.backend.springbootfirebase.entity;

public class Bonus {

    private String name;
    private String id;
    private String description;
    private double percentage;

    public Bonus(String id, String name, String description, double percentage) {
        this.id = id;
        this.name= name;
        this.description = description;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

}
