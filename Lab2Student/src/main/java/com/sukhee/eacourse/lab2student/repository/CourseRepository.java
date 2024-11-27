package com.sukhee.eacourse.lab2student.repository;

import com.sukhee.eacourse.lab2student.entity.Course;
import com.sukhee.eacourse.lab2student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CourseRepository{
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public CourseRepository(EmfSingleton emfSingleton) {
        emf = emfSingleton.getEmf();
        em = emfSingleton.getEm();
    }

    private void startTransaction() {
        tx = em.getTransaction();
        tx.begin();
    }

    private void endTransaction() {
        tx.commit();
    }

    public void create(Course course) {
        startTransaction();
        em.persist(course);
        endTransaction();
    }

    public Course read(int id) {
        startTransaction();
        Course course= em.find(Course.class, id);
        endTransaction();
        return course;
    }

    public Course update(Course course) {
        startTransaction();
        Course databaseCourse= em.merge(course);
        endTransaction();
        return databaseCourse;
    }

    public Course addStudent(Course course, Student student) {
        startTransaction();
        Course courseDb= em.find(Course.class, course.getId());
        courseDb.addStudent(student);
        endTransaction();
        return courseDb;
    }

    public void delete(Course course) {
        startTransaction();
        em.remove(course);
        endTransaction();
    }

}
