package org.example.service;

import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<String> getUsers() {
        return userRepository.getUsers();
    }

    public void addUser(String user) {

        if(user == null) {
            throw new IllegalArgumentException("Usuário não pode estar nulo");
        }

        userRepository.addUser(user);
    }

    public void formatAndSaveUser(String user) {
        String firstLetter = user.substring(0, 1);

        //starts with z
        if(user.toLowerCase().startsWith("z")) {
            return;
        }

        //starts with a
        if(user.toLowerCase().startsWith("a")) {
            formatAndSaveUserWithA(user);
            return;
        }

        //lower to upper
        formatOtherUsers(user);
    }

    public void formatAndSaveUserWithA(String user) {
        userRepository.addUser(user.toLowerCase());
        userRepository.addUser(user.toUpperCase());
    }

    public void formatOtherUsers(String user) {
        String firstLetter = user.substring(0, 1);

        //lower to upper
        if (user.startsWith(firstLetter.toLowerCase())) {
            userRepository.addUser(user.toUpperCase());
            return;

        }

        if (user.startsWith(firstLetter.toUpperCase())) {
            userRepository.addUser(user.toLowerCase());
            return;
        }
    }

    public void deleteAllUsers() {
        userRepository.deleteAllUsers();
    }

}
