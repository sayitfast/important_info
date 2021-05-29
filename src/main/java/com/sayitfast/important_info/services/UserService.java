package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.App_User;
import com.sayitfast.important_info.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public void save(App_User appUser) {

        appUser.setPassword(encoder.encode(appUser.getPassword()));

        userRepository.save(appUser);
    }

}
