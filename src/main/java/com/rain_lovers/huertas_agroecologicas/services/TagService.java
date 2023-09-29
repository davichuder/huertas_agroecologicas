package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.enums.TagEnum;
import com.rain_lovers.huertas_agroecologicas.models.Tag;
import com.rain_lovers.huertas_agroecologicas.repositories.TagRepository;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public void loadTags() {
        List<Tag> newTags = Arrays.stream(TagEnum.values())
                .filter(tagName -> !tagRepository.findByName(tagName).isPresent())
                .map(Tag::new)
                .collect(Collectors.toList());
        tagRepository.saveAll(newTags);
    }
}
