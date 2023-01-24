package com.tweetero.tweetero.models;

import com.tweetero.tweetero.dtos.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Tweet {
    public Tweet(TweetDTO data, String username, String avatar) {
        this.username = username;
        this.avatar = avatar;
        this.text = data.text();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 50, nullable = false)
    String username;

    @Column(length = 50, nullable = false)
    String avatar;

    @Column(length = 140, nullable = false)
    String text;
}
