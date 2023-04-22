package com.api.erich.client;

import com.api.erich.dto.CommentsDto;
import com.api.erich.dto.PostDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange(url = "https://jsonplaceholder.typicode.com",
                accept = MediaType.APPLICATION_JSON_VALUE,
                contentType = MediaType.APPLICATION_JSON_VALUE)
public interface TypiCodeClient {

    @GetExchange("/posts")
    List<PostDto> getAllPost();

    @GetExchange("/posts/{id}")
    PostDto getPostId(@PathVariable Long id);

    @GetExchange("/post/{id}/comments")
    List<CommentsDto> getCommentsByPostId(@PathVariable Long id);

    @GetExchange("/comments")
    List<CommentsDto> getCommentsByPostById(@RequestParam Long postId);

    @PostExchange("/posts")
    PostDto createPost(@RequestBody PostDto postDto);

    @PutExchange("/posts/{id}")
    PostDto updatePostById(@RequestBody PostDto postDto,@PathVariable Long id);

    @DeleteExchange("/posts/{id}")
    void deletePostById(@PathVariable Long id);
}
