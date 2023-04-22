package com.api.erich.dto;

public record CommentsDto(Long postId, Long id, String name, String email, String body) { }
