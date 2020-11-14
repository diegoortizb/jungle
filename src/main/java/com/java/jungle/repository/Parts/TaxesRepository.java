package com.java.jungle.repository.Parts;

import com.java.jungle.model.Taxes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxesRepository extends JpaRepository<Taxes, Integer> {
}
