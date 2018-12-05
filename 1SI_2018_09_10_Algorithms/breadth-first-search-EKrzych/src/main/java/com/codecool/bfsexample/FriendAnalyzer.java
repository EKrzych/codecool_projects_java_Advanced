package com.codecool.bfsexample;

import com.codecool.bfsexample.model.UserNode;
import com.codecool.bfsexample.userDAO.UserDAO;
import com.codecool.bfsexample.userDAO.UserDAOInterface;

import javax.persistence.EntityManagerFactory;
import java.util.*;

public class FriendAnalyzer {
    List<UserNode> users;



    public FriendAnalyzer(EntityManagerFactory emf) {
        UserDAOInterface userDAO = new UserDAO(emf);
        this.users = userDAO.getAllUsers();
    }

    public int findShortestDistance(long u1, long u2) {
        Set<UserNode> checkedUsers = new HashSet<>();
        List<UserNode> usersToCheck = new LinkedList<>();

        usersToCheck = getFriendsOfUser(u1);
        return checkIfOnFriendList((LinkedList<UserNode>) usersToCheck, u2, checkedUsers);

    }

    public LinkedList<UserNode> listFriendOfFriends(long u1, int distance) {
        List<UserNode> usersToCheck;
        usersToCheck = getFriendsOfUser(u1);
        return gatherFriendsAtDistance(usersToCheck, distance - 1);
    }

    private LinkedList<UserNode> gatherFriendsAtDistance(List<UserNode> usersToCheck, int distance) {
        if(distance == 0) {
            return (LinkedList)usersToCheck;
        }
        Set<UserNode> usersFriends = new HashSet<>();

        if(distance > 0) {
            for(UserNode user: usersToCheck) {
                usersFriends.addAll(user.getFriends());
            }
        }
        List<UserNode> friends = new LinkedList<>(usersFriends);
        return gatherFriendsAtDistance(friends, distance-1);
    }

    private LinkedList<UserNode> getFriendsOfUser(long u1) {
        LinkedList<UserNode> usersToCheck = new LinkedList<>();

        for (UserNode user : users) {
            if (user.getId() == u1) {
                usersToCheck.addAll(new LinkedList<UserNode>(user.getFriends()));
                break;
            }
        }
        return usersToCheck;
    }

    private int checkIfOnFriendList(LinkedList<UserNode> usersToCheck, long u2, Set<UserNode> checkedUsers) {
        LinkedList<UserNode> newUsersToCheck = new LinkedList<>();

        for (UserNode user : usersToCheck) {
            if (user.getId() == u2) {
                return 1;
            } else if (!checkedUsers.contains(user) ){
                LinkedList<UserNode> userFriends = new LinkedList<>(user.getFriends());
                for(UserNode u : userFriends) {
                    if (!checkedUsers.contains(u) && !newUsersToCheck.contains(u)) {
                        newUsersToCheck.add(u);
                    }
                }
                checkedUsers.add(user);
            }
        }

        if(newUsersToCheck.size() == 0) {
            return Integer.MIN_VALUE;
        }
        usersToCheck = newUsersToCheck;
        return 1 + checkIfOnFriendList(usersToCheck, u2, checkedUsers);
    }
}
