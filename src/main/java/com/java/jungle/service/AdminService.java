package com.java.jungle.service;

import com.java.jungle.model.Cart;
import com.java.jungle.model.Taxes;
import com.java.jungle.repository.Parts.TaxesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    TaxesRepository taxesRepo;

    @ModelAttribute("taxes")
    public List<Taxes> findAll() {
        return taxesRepo.findAll();
    }

    public void updateQty(int id, float qty) {
        Taxes bracket = taxesRepo.findById(id).get();
        bracket.setTaxRate(qty);
        taxesRepo.save(bracket);
    }
}
