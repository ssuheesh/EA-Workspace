package com.sukhee.eacourse.lab2student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int gpa;

    protected Student() {
    }

    public Student(int gpa, String name) {
        this.gpa = gpa;
        this.name = name;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
