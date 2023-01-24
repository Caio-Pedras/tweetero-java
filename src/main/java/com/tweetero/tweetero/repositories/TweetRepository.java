package com.tweetero.tweetero.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.tweetero.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Page<Tweet> findAllByOrderByIdDesc(Pageable pageable);

    List<Tweet> findByUsernameOrderByIdDesc(String username);

}
