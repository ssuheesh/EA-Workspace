package com.sukhee.eacourse.lab2student;

import com.sukhee.eacourse.lab2student.entity.*;
import com.sukhee.eacourse.lab2student.repository.CourseRepository;
import com.sukhee.eacourse.lab2student.repository.EmfSingleton;
import com.sukhee.eacourse.lab2student.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("App Start");
        try (EmfSingleton emf= EmfSingleton.getInstance()) {
            StudentRepository studentRepository = new StudentRepository(emf);
            CourseRepository courseRepository = new CourseRepository(emf);

            Student jack = new Student(30, "Jack");
            studentRepository.create(jack);
            jack.setGpa(35);
            studentRepository.update(jack);
            Student databaseJack = studentRepository.read(jack.getId());
            System.out.println(databaseJack);
//            studentRepository.delete(databaseJack);
            Student joe = new Student(40, "Joe");
            Course course = new Course("Enterprise Architecture", 20, "218", "CS544");
            course.setStudents(new ArrayList<Student>(List.of(new Student[]{jack, joe})));
            courseRepository.create(course);
            System.out.println(course);
            Student newStudent = new Student(39, "newStudent");
            studentRepository.create(newStudent);
            course.addStudent(newStudent); //why ?
            courseRepository.update(course);
            System.out.println(course);

            //Following I cannot do because it is oneToMany ( Checked )
            /*
            Course course2 = new Course("Algorithms", 20, "200", "CS435");
            course2.addStudent(newStudent);
            courseRepository.create(course2);
            */

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
