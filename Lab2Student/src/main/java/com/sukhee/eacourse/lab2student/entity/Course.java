package com.sukhee.eacourse.lab2student.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Can use SINGLE_TABLE, JOINED, or TABLE_PER_CLASS
@DiscriminatorColumn(name = "course_type", discriminatorType = DiscriminatorType.STRING)
public class Course {
    @Id@GeneratedValue private int id;
    private String title;
    private LocalDate startDate;
    private String professorName;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name="course_students")
    private List<Student> students;

    public Course() {}
    public Course(String title, LocalDate startDate, String professorName) {
        this.title = title;
        this.startDate = startDate;
        this.professorName = professorName;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public void setTitle(String title) {
        this.title = title;
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
//                ", students=" + students +
                '}';
    }
}
