package com.sukhee.eacourse.labstudent.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("distanceEducation")
@Cacheable(false)
public class DistanceEducationCourse extends Course {

    private String examProfessor;

    @ElementCollection
    @CollectionTable(name = "webinar_session_dates", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "session_date")
    private List<LocalDate> webinarSessionDates;

    // Constructors, Getters, and Setters
    public DistanceEducationCourse() {
    }

    public DistanceEducationCourse(String title, LocalDate startDate, String professorName, String examProfessor, List<LocalDate> webinarSessionDates) {
        super(title, startDate, professorName);
        this.examProfessor = examProfessor;
        this.webinarSessionDates = webinarSessionDates;
    }

    public String getExamProfessor() {
        return examProfessor;
    }

    public void setExamProfessor(String examProfessor) {
        this.examProfessor = examProfessor;
    }

    public List<LocalDate> getWebinarSessionDates() {
        return webinarSessionDates;
    }

    public void setWebinarSessionDates(List<LocalDate> webinarSessionDates) {
        this.webinarSessionDates = webinarSessionDates;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return "DistanceEducationCourse{" +
                "examProfessor='" + examProfessor + '\'' +
                ", webinarSessionDates=" + webinarSessionDates +
                ", course = " + superStr +
                '}';
    }
}
