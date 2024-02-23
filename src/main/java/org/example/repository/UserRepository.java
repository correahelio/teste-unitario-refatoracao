package org.example.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<String> userList = new ArrayList<>();

    public List<String> getUsers() {
        return userList;
    }

    public void addUser(String user) {
        userList.add(user);
    }

    public void deleteAllUsers() {
        userList = new ArrayList<>();
    }
}