package com.tigmaminds.jithu.demo.service;

import com.tigmaminds.jithu.demo.model.Images;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service
public class ImagesService {
    private Map<String, Images> db = new HashMap<>(){{
        put("1",new Images("1","hello.jpa"));
    }};

    public Collection<Images> get() {
        return db.values();
    }

    public Images get(String id) {
        return db.get(id);
    }

    public Images remove(String id) {
        return db.remove(id);
    }

    public Images save(String fileName, String contentType, byte[] data) {
        Images images = new Images();
        images.setId(UUID.randomUUID().toString());
        images.setFileName(fileName);
        images.setData(data);
        images.setContentType(contentType);
        db.put(images.getId(),images);
        return images;
    }
}
