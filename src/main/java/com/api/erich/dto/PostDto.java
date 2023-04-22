package com.api.erich.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostDto(@JsonProperty("userId") Long userID, Long id, String title, String body) { }
