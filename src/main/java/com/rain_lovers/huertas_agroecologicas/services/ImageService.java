package com.rain_lovers.huertas_agroecologicas.services;

import java.io.File;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rain_lovers.huertas_agroecologicas.models.Image;
import com.rain_lovers.huertas_agroecologicas.repositories.ImageRepository;

import jakarta.transaction.Transactional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    public Image getOne(String id) {
        Optional<Image> image = imageRepository.findById(id);
        if (image.isPresent()) {
            return image.get();
        }
        return null;
    }

    @Transactional
    public Image save(MultipartFile file) {
        Image image = new Image();
        if (file != null && !file.getContentType().equals("application/octet-stream")) {
            try {
                image.setMime(file.getContentType());
                image.setName(file.getOriginalFilename());
                image.setContent(file.getBytes());
                imageRepository.save(image);
                return image;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    @Transactional
    public Image saveDefaultProfile(MultipartFile file) {
        Image image = new Image();
        try {
            Resource resource = resourceLoader.getResource("classpath:/static/img/defaultProfile.svg");
            File imagePredeterminada = resource.getFile();
            byte[] bytes = Files.readAllBytes(imagePredeterminada.toPath());
            image.setMime("image/svg+xml");
            image.setName("defaultProfile");
            image.setContent(bytes);
            imageRepository.save(image);
            return image;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Transactional
    public Image saveProfile(MultipartFile file) {
        Image image = this.save(file);
        if (image == null) {
            image = this.saveDefaultProfile(file);
        }
        return image;
    }

    @Transactional
    public Image update(String idImage, MultipartFile file) {
        Optional<Image> optional_image = imageRepository.findById(idImage);
        if (optional_image.isPresent()) {
            Image image = optional_image.get();
            if (file != null && !file.getContentType().equals("application/octet-stream")) {
                try {
                    image.setMime(file.getContentType());
                    image.setName(file.getOriginalFilename());
                    image.setContent(file.getBytes());
                    imageRepository.save(image);
                    return image;
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            return image;
        }
        return null;
    }
}
