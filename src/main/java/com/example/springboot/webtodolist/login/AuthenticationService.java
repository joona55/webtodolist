package com.example.springboot.webtodolist.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authentication(String userName, String password) {

        boolean isValidUserName = userName.equalsIgnoreCase("joona");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");

        return isValidPassword && isValidUserName;
    }
}
