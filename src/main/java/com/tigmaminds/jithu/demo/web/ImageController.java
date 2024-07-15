package com.tigmaminds.jithu.demo.web;

import com.tigmaminds.jithu.demo.model.Images;
import com.tigmaminds.jithu.demo.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class ImageController {


   private final ImagesService imagesService;
   ImageController(ImagesService imagesService){
       this.imagesService = imagesService;
   }
//    private List<Images> db= List.of(new Images("1","hello.jpa"));

    @GetMapping("/images")
    public Collection<Images> get(){
        return imagesService.get();
    }
    @GetMapping("/images/{id}")
    public byte[] get(@PathVariable String id){
        Images images = imagesService.get(id);
        if(images == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return images.getData();
    }
    @DeleteMapping("/images/{id}")
    public void delete(@PathVariable String id){
        Images images = imagesService.remove(id);
        if(images == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
//    @PostMapping("/images")
//    public Images create(@RequestBody Images images){
//        db.put(images.getId(),images);
//        return images;
//    }
    @PostMapping("/images")
    public Images create(@RequestPart("data") MultipartFile file) throws IOException {
        Images images = new Images();
//        images.setId(UUID.randomUUID().toString());
//        images.setFileName(file.getOriginalFilename());
//        images.setData(file.getBytes());
        imagesService.save(file.getOriginalFilename(),file.getContentType(),file.getBytes());
        return images;
    } //Here we can upload image from client to backend, but we don't get the data back to client to display in client.
    //so we can use new controller to do that.


//    public Images create(@RequestPart("data") MultipartFile multipartFile){ //Take all the key value in body in postman into Image.
////        images.setId(UUID.randomUUID().toString());
//        Images images = new Images();
//        db.put(images.getId(),images);
//        return images;
//    }
}
