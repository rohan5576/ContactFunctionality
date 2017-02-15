package com.example.admin.contactfunctionality.model;

/**
 * Created by Admin on 15-02-2017.
 */

public class AllContact {
    String number;
    String name;

    public AllContact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
