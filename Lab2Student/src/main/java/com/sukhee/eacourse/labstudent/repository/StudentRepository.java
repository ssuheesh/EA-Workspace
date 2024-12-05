package com.sukhee.eacourse.labstudent.repository;

import com.sukhee.eacourse.labstudent.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class StudentRepository{
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public StudentRepository(EmfSingleton emfSingleton) {
        emf = emfSingleton.getEmf();
        em = emfSingleton.getEm();
    }

    private void startTransaction() {
//        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    private void endTransaction() {
        tx.commit();
//        em.close();
    }

    public void createIfNotExists(Student student) {
        startTransaction();
        System.out.println("Trying to persist: " + student);
        try {
            em.persist(student);
        } catch (Exception e) {
            System.err.println("Error persisting student: " + e.getMessage());
        }

        endTransaction();
    }

    public void create(Student student) {
        startTransaction();
        em.persist(student);
        endTransaction();
    }

    public Student read(int id) {
        startTransaction();
        Student student= em.find(Student.class, id);
        endTransaction();
        return student;
    }

    public Student update(Student student) {
        startTransaction();
        Student databaseStudent= em.merge(student);
        endTransaction();
        return databaseStudent;
    }

    public Student anotherUpdate(Student student) {
        startTransaction();
        Student databaseStudet= em.find(Student.class, student.getId());
        databaseStudet.setName(student.getName());
        databaseStudet.setGpa(student.getGpa());
        endTransaction();
        return databaseStudet;
    }

    public void delete(Student student) {
        startTransaction();
        em.remove(student);
        endTransaction();
    }

}
