package com.sukhee.eacourse.lab3;

import com.sukhee.eacourse.lab3.entity.*;
import com.sukhee.eacourse.lab3.repository.EmfSingleton;
import com.sukhee.eacourse.lab3.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("App Start");
        try (EmfSingleton emf = EmfSingleton.getInstance()) {
            buildData(emf);
            UserRepository userRepository = new UserRepository(emf);

            // Test checkUserCredentials method
            boolean userExists = userRepository.checkUserCredentials("john_doe", "password123");
            System.out.println("User exists: " + userExists);

            // Test getTotalUsers method
            long totalUsers = userRepository.getTotalUsers();
            System.out.println("Total users in the database: " + totalUsers);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("App End");
        }

    }

    private static void buildData(EmfSingleton emf) {
        emf.getEm().getTransaction().begin();

        // Create a Participant
        Participant participant = new Participant();
        participant.setUsername("john_doe");
        participant.setPassword("password123");
        participant.setFirstName("John");
        participant.setLastName("Doe");

        // Create an Organizer
        Organizer organizer = new Organizer();
        organizer.setUsername("acme_org");
        organizer.setPassword("organizer123");
        organizer.setCompanyName("ACME Events");

        // Persist the entities
        emf.getEm().persist(participant);
        emf.getEm().persist(organizer);
        emf.getEm().getTransaction().commit();
    }
}