package com.sukhee.eacourse.lab3.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Organizer")
public class Organizer extends User {
    private String companyName;

    // Getters and setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

