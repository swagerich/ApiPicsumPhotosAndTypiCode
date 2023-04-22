package com.api.erich.service;

import com.api.erich.client.TypiCodeClient;
import com.api.erich.dto.CommentsDto;
import com.api.erich.dto.PostDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypiCodeService {

    private final TypiCodeClient typiCodeClient;

    public TypiCodeService(TypiCodeClient typiCodeClient) {
        this.typiCodeClient = typiCodeClient;
    }

    public List<PostDto> getAllPostDto() {
        List<PostDto> listita = typiCodeClient.getAllPost();
        return listita.stream().filter(x -> x.id() <= 10).collect(Collectors.toList());
        /*int contador = 0;
        List<Post> listaFiltrada  = new ArrayList<>();
        for (Post l : listita){
        if(contador >= 10){
            break;
        }
        if(l.getId() > 10){
            listaFiltrada.add(l);
            contador++;
        }
    }
        System.out.println(listaFiltrada);
    return listaFiltrada;*/
    }

    public PostDto findById(Long id) {
        return typiCodeClient.getPostId(id);
    }

    public List<CommentsDto> getCommentsByPostId(Long id) {
        return typiCodeClient.getCommentsByPostId(id);
    }

    @PostConstruct
    public List<CommentsDto> getComments(){
        List<CommentsDto> comments = typiCodeClient.getCommentsByPostById(1L);
        System.out.println(comments.size());
        return comments;
    }

    public PostDto createPost(PostDto postDto) {
        return typiCodeClient.createPost(postDto);
    }

    public PostDto updatePost(PostDto postDto, Long id) {
        return typiCodeClient.updatePostById(postDto, id);
    }

    public void deletPost(Long id){
        typiCodeClient.deletePostById(id);
        System.out.println("Eliminado con exito!");
    }
}
