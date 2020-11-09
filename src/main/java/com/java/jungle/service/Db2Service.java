package com.java.jungle.service;

import com.java.jungle.model.db2Entity;
import com.java.jungle.repository.DB2.db2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class Db2Service {
    @Autowired
    private db2Repository repository2;

    @ModelAttribute("parts")
    public List<db2Entity> findAll(){return repository2.findAll();}
}
