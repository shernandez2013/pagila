package com.example.pagila.images;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    List<ImageEntity> getImages();

    void saveImage(MultipartFile file) throws IOException;
}
