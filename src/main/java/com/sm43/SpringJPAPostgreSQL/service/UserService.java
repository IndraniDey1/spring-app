package com.sm43.SpringJPAPostgreSQL.service;

import com.sm43.SpringJPAPostgreSQL.model.User;
import com.sm43.SpringJPAPostgreSQL.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(String name, String city) {
        User u = new User(name, city);
        userRepository.save(u);
    }

    public void addUsers() {
        User u1 = new User("Abc", "Mumbai");
        userRepository.save(u1);

        User u2 = new User("Def", "Bangalore");
        userRepository.save(u2);

        User u3 = new User("Xyz", "Pune");
        userRepository.save(u3);
    }

    public String getUsers() {
        String result = "<h2> User List - <h2><br>";
        for (User user : userRepository.findAll()) {
            result += "<h3>" + user.toString() +"</h3>" + "<br>";
        }
        return result;
    }

    public Long count() {
        return userRepository.count();
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

}
