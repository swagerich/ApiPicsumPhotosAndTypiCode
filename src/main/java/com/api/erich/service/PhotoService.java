package com.api.erich.service;

import com.api.erich.client.PhotoClient;
import com.api.erich.dto.PhotoDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    private final PhotoClient photoClient;

    public PhotoService(PhotoClient photoClient) {
        this.photoClient = photoClient;
    }

    public List<PhotoDto> getPhotito(){
        List<PhotoDto> allPhoto = photoClient.getAllPhoto();
        System.out.println(allPhoto);
        return allPhoto;
    }

}
