package com.api.erich.controller;

import com.api.erich.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPhoto(){
        return new ResponseEntity<>(photoService.getPhotito(), HttpStatus.OK);
    }
}
