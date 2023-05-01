package com.example.pagila.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public List<ImageEntity> getImages() {
        return imageRepository.findAll();
    }

    @Override
    public void saveImage(MultipartFile file) throws IOException {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setId(0L);
        imageEntity.setName(file.getOriginalFilename());
        imageEntity.setImage(ImageUtil.compressImage(file.getBytes()));
        imageEntity.setDescription("Description of image");
        imageRepository.save(imageEntity);
    }
}
