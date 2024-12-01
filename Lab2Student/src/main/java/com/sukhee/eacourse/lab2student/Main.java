package com.sukhee.eacourse.lab2student;

import com.sukhee.eacourse.lab2student.entity.*;
import com.sukhee.eacourse.lab2student.repository.CourseRepository;
import com.sukhee.eacourse.lab2student.repository.EmfSingleton;
import com.sukhee.eacourse.lab2student.repository.StudentRepository;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("App Start");
        try (EmfSingleton emf = EmfSingleton.getInstance()) {
//            buildData(emf);
            // JPQL:
            String jpql = "SELECT s FROM Student s " +
                    "JOIN s.courseAttending c " +
                    "WHERE s.gpa > :gpa " +
                    "AND TYPE(c) = OnCampusCourse " +
                    "AND c.capacity > :capacity";
//            String jpql = "SELECT s FROM Student s ";
            System.out.println("Query JPQL: ");
            TypedQuery<Student> query = emf.getEm().createQuery(jpql, Student.class);
            query.setParameter("gpa", 30);
            query.setParameter("capacity", 30);
            List<Student> result = query.getResultList();
            Stream.of(result).forEach(System.out::println);

            //Named Query:
            System.out.println("Query NamedQuery Test: ");
            TypedQuery<Student> query2 =
                    emf.getEm().createNamedQuery("Student.findStudents", Student.class);
            query2.setParameter("gpa", 30);
            Stream.of(query2.getResultList()).forEach(System.out::println);

            System.out.println("Query NamedQuery Graduate Candidates: ");
            TypedQuery<Student> query2b = emf.getEm().createNamedQuery("Student.findGraduateCandidates", Student.class);
            System.out.println("Result1: ");
            query2b.setParameter("totalCoursesAttended", 9);
            query2b.getResultStream().forEach(System.out::println);
            System.out.println("Result2: ");
            query2b.setParameter("totalCoursesAttended", 1);
            query2b.getResultStream().forEach(System.out::println);

            // CriQuery:
            // CriteriaBuilder, select root, join with AttendingCourse, check if DE and Professor name is Najeeb
            // predicates are build with criteria builder
            // add predicates to criteria query
            System.out.println("Query CriQuery Attending Najeeb course: ");
            CriteriaBuilder cb = emf.getEm().getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
            Root<Student> root = cq.from(Student.class);
            cq.select(root);
            Predicate gpaPredicate = cb.lessThan(root.get("gpa"), 30);
            Join<Student, Course> joinCourseAttending = root.join("courseAttending", JoinType.INNER);
            Predicate typePredicate = cb.equal(joinCourseAttending.type(), DistanceEducationCourse.class);
            Predicate professorPredicate = cb.like(joinCourseAttending.get("professorName"), "%Najeeb%");
            Predicate finalPredicate = cb.and(gpaPredicate, typePredicate, professorPredicate);
            cq.where(finalPredicate);
            TypedQuery<Student> query3 = emf.getEm().createQuery(cq);
            query3.getResultStream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buildData(EmfSingleton emf) {
        OnCampusCourse onCampusCourse = new OnCampusCourse(
                "Algorithm CS435",
                LocalDate.of(2024, 1, 15),
                "Prem Nair",
                "A101",
                32
        );

        // Create DistanceEducationCourse
        DistanceEducationCourse distanceEducationCourse = new DistanceEducationCourse(
                "Physics 202",
                LocalDate.of(2024, 2, 1),
                "Najeeb Najeeb",
                "Najeeb Najeeb",
                Arrays.asList(
                        LocalDate.of(2024, 2, 10),
                        LocalDate.of(2024, 3, 15)
                )
        );

        CourseRepository cp = new CourseRepository(emf);
        cp.create(onCampusCourse);
        cp.create(distanceEducationCourse);
//            Stream.of(cp.findAll()).forEach(System.out::println);

        Student student1 = new Student(30, "Alice");
        Student student2 = new Student(40, "Bob");
        Student student3 = new Student(20, "Charlie");
        Student student4 = new Student(30, "Diana");
        Student student5 = new Student(30, "Ethan");


//            Set the current course attending for students
        student1.setCourseAttending(onCampusCourse);
        student2.setCourseAttending(onCampusCourse);
        student3.setCourseAttending(distanceEducationCourse);
//        student4.setCourseAttending(distanceEducationCourse);
        student5.setCourseAttending(distanceEducationCourse);

        // Add attended courses for students
        student1.addCourseAttended(onCampusCourse);
        student2.addCourseAttended(onCampusCourse);
        student3.addCourseAttended(distanceEducationCourse);
        student4.addCourseAttended(distanceEducationCourse);
        student5.addCourseAttended(distanceEducationCourse);
        StudentRepository sr = new StudentRepository(emf);
        sr.createIfNotExists(student1);
        sr.createIfNotExists(student2);
        sr.createIfNotExists(student3);
        sr.createIfNotExists(student4);
        sr.createIfNotExists(student5);

        // Assign Students to Courses
        onCampusCourse.addStudent(student1);
        onCampusCourse.addStudent(student2);
        distanceEducationCourse.addStudent(student3);
        distanceEducationCourse.addStudent(student4);
        distanceEducationCourse.addStudent(student5);
        cp.update(onCampusCourse);
        cp.update(distanceEducationCourse);
    }
}
