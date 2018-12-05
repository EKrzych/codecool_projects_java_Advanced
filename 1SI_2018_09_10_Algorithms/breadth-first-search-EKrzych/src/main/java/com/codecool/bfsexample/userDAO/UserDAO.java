package com.codecool.bfsexample.userDAO;

import com.codecool.bfsexample.model.UserNode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDAO implements UserDAOInterface {
    private EntityManager entityManager;

    public UserDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserNode> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM UserNode u")
                .getResultList();
    }
}
