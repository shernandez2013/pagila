package com.example.pagila.images;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("v1")
public class ImageController {

    ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @GetMapping(path = "/images")
    List<ImageEntity> getImages() {
        return imageService.getImages();
    }

    @ApiOperation(value = "store images in data base")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @PostMapping(path = "/images")
    public void uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.saveImage(file);
    }
}
