package com.sukhee.eacourse.lab2student.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@NamedQueries(
        {
                @NamedQuery(name = "Student.findStudents",
                        query = "SELECT s FROM Student s WHERE s.gpa = :gpa"),
                @NamedQuery(name = "Student.findGraduateCandidates",
                        query = "SELECT s FROM Student s WHERE s.gpa >= 30 AND s.courseAttending is null AND size(s.coursesAttended) >= :totalCoursesAttended")
        }
)
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int gpa;

    @ManyToOne
    @JoinColumn(name = "course_attending_id", unique = false)
    private Course courseAttending;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "student_courses_attended")
    private List<Course> coursesAttended;

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

    public Course getCourseAttending() {
        return courseAttending;
    }

    public void setCourseAttending(Course courseAttending) {
        this.courseAttending = courseAttending;
    }

    public List<Course> getCoursesAttended() {
        return coursesAttended;
    }

    public void setCoursesAttended(List<Course> coursesAttended) {
        this.coursesAttended = coursesAttended;
    }

    public void addCourseAttended(Course courseAttended) {
        if (this.coursesAttended == null) {
            this.coursesAttended = new ArrayList<Course>();
        }
        this.coursesAttended.add(courseAttended);
    }


    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", id=" + id +
                ", name='" + name + '\'' +
//                ", courseAttending=" + courseAttending +
//                ", total coursesAttended =" + coursesAttended.size() +
                '}';
    }
}
