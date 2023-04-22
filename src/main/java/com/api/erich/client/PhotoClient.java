package com.api.erich.client;

import com.api.erich.dto.PhotoDto;
import org.springframework.http.MediaType;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;


import java.util.List;

@HttpExchange(url = "https://picsum.photos/v2/list",
        accept = MediaType.APPLICATION_JSON_VALUE,
        contentType = MediaType.APPLICATION_JSON_VALUE)
public interface PhotoClient {

    @GetExchange
    List<PhotoDto> getAllPhoto();

}
