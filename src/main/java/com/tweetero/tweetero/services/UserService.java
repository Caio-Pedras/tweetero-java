package com.tweetero.tweetero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetero.tweetero.dtos.UserDTO;
import com.tweetero.tweetero.models.TweeteroUser;
import com.tweetero.tweetero.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void createUser(UserDTO dto) {
        repository.save(new TweeteroUser(dto));
    }
}
