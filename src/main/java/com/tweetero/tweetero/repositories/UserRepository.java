package com.tweetero.tweetero.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.tweetero.models.TweeteroUser;

public interface UserRepository extends JpaRepository<TweeteroUser, Long> {
    public Optional<TweeteroUser> findByUsername(String username);
}
