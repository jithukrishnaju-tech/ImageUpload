package com.tigmaminds.jithu.demo.web;

import com.tigmaminds.jithu.demo.model.Images;
import com.tigmaminds.jithu.demo.service.ImagesService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {
    private final ImagesService imagesService;
    public DownloadController(ImagesService imagesService){
        this.imagesService= imagesService;
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){
        Images images = imagesService.get(id);
        if(images ==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        byte[] data= images.getData();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.valueOf(images.getContentType()));
        ContentDisposition build = ContentDisposition.builder("attachment").filename(images.getFileName()).build();
        header.setContentDisposition(build);
        return new ResponseEntity<>(data,header, HttpStatus.OK);
    }
}
