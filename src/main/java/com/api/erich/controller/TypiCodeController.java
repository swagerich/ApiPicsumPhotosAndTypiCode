package com.api.erich.controller;

import com.api.erich.dto.CommentsDto;
import com.api.erich.dto.PostDto;
import com.api.erich.service.TypiCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypiCodeController {

    private final TypiCodeService codeService;

    public TypiCodeController(TypiCodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/allPost")
    public List<PostDto> findAllPost() {
        return codeService.getAllPostDto();
    }

    @GetMapping("/post/{id}")
    public PostDto findById(@PathVariable Long id) {
        return codeService.findById(id);
    }

    @GetMapping("/post/{id}/commen")
    public List<CommentsDto> commentsDtos(@PathVariable Long id) {
        return codeService.getCommentsByPostId(id);
    }

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto) {
        return codeService.createPost(postDto);
    }

    @PutMapping("{id}")
    public PostDto updatePost(@RequestBody PostDto postDto, @PathVariable Long id) {
        return codeService.updatePost(postDto, id);
    }

    @DeleteMapping("{id}")
    public String deletePost(@PathVariable Long id) {
        codeService.deletPost(id);
        return "Eliminado con exito";
    }

}
