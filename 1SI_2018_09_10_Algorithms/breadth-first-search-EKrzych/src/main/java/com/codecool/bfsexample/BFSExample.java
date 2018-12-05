package com.codecool.bfsexample;

import com.codecool.bfsexample.model.UserNode;
import com.codecool.bfsexample.userDAO.UserDAO;
import com.codecool.bfsexample.userDAO.UserDAOInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;

public class BFSExample {

    public static void populateDB(EntityManager em) {

        RandomDataGenerator generator = new RandomDataGenerator();
        List<UserNode> users = generator.generate();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        for (UserNode user : users) {
            em.persist(user);
        }
        transaction.commit();

        GraphPlotter.plot(users);
        
        System.out.println("Done!");
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bfsExampleUnit");
        EntityManager em = emf.createEntityManager();

        em.clear();
        populateDB(em);
        FriendAnalyzer friendAnalyzer = new FriendAnalyzer(emf);

        int level = friendAnalyzer.findShortestDistance(120,97);
            System.out.println("Level: "+ level);

        LinkedList<UserNode> friendsOfU1 = friendAnalyzer.listFriendOfFriends(1, 2);
        for(UserNode user: friendsOfU1) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }

        System.out.println("End");
    }
}
