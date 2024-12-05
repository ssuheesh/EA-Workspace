package com.sukhee.eacourse.labstudent.entity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("onCampus")
public class OnCampusCourse extends Course {

    private String room;
    private int capacity;

    // Constructors, Getters, and Setters
    public OnCampusCourse() {}

    public OnCampusCourse(String title, LocalDate startDate, String professorName, String room, int capacity) {
        super(title, startDate, professorName);
        this.room = room;
        this.capacity = capacity;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return "OnCampusCourse{" +
                "room='" + room + '\'' +
                ", capacity=" + capacity +
                ", course = " + superStr +
                '}';
    }
}
