package com.backend.springbootfirebase.entity;

public class Employee {

    String name;
    int id;
    String description;
//    List<empBonus> empBonus;
//    List<empBonus> empClash;

    public Employee(String name, int empId, String empDescription) {
        this.name = name;
        this.id = empId;
        this.description = empDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
