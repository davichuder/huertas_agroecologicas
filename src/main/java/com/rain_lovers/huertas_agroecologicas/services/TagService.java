package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.enums.TagEnum;
import com.rain_lovers.huertas_agroecologicas.models.Tag;
import com.rain_lovers.huertas_agroecologicas.repositories.TagRepository;

import jakarta.transaction.Transactional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    public void loadTags() {
        List<Tag> newTags = Arrays.stream(TagEnum.values())
                .filter(tagName -> !tagRepository.findByName(tagName).isPresent())
                .map(Tag::new)
                .collect(Collectors.toList());
        tagRepository.saveAll(newTags);
    }

    public Tag getTagByEnum(TagEnum tagName) {
        Optional<Tag> tag = tagRepository.findByName(tagName);
        if (tag.isPresent()) {
            return tag.get();
        }
        return null;
    }
}
