package com.java.jungle.service;

import com.java.jungle.model.Parts;
import com.java.jungle.repository.Parts.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Service
public class PartsService {

    @Autowired
    private PartsRepository partsRepository;

    @ModelAttribute("parts")
    public List<Parts> findAll() {
        return this.partsRepository.findAll();
    }
}
