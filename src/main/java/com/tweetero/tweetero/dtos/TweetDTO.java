package com.tweetero.tweetero.dtos;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(@NotBlank String text) {

}
