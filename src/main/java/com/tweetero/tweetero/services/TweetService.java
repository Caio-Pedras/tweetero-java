package com.tweetero.tweetero.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweetero.tweetero.dtos.TweetDTO;
import com.tweetero.tweetero.models.Tweet;
import com.tweetero.tweetero.models.TweeteroUser;
import com.tweetero.tweetero.repositories.TweetRepository;
import com.tweetero.tweetero.repositories.UserRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public void save(String username, TweetDTO dto) {
        Optional<TweeteroUser> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            repository.save(new Tweet(dto, username, user.get().getAvatar()));
        }
    }

    public Page<Tweet> getTweets(Pageable page) {
        return repository.findAllByOrderByIdDesc(page);
    }

    public List<Tweet> getTweetsByUser(String username) {
        Optional<TweeteroUser> user = userRepository.findByUsername(username);

        if (!user.isPresent())
            return List.of();
        return repository.findByUsernameOrderByIdDesc(username);
    }
}
