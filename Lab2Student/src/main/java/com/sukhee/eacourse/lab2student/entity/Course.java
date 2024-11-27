package com.sukhee.eacourse.lab2student.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
@SecondaryTable(name="room", pkJoinColumns = {@PrimaryKeyJoinColumn(name="course_id")})
public class Course {
    @Id@GeneratedValue private int id;
    private String title;
    private int capacity;
    @Column(table="room")
    private String room;
    @Column(unique = true, nullable = false, name = "CODE")
    private String number;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;

    public Course() {}
    public Course(String title, int capacity, String room, String number) {
        this.title = title;
        this.capacity = capacity;
        this.room = room;
        this.number = number;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        if (null == this.students) {
            this.students = new ArrayList<Student>();
        }
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", capacity=" + capacity +
                ", room='" + room + '\'' +
                ", number='" + number + '\'' +
                ", students=" + students +
                '}';
    }
}
