package com.java.jungle.repository;

import com.java.jungle.model.Parts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartsRepository extends JpaRepository<Parts, Integer> {
}
