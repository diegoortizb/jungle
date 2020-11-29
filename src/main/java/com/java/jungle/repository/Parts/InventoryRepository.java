package com.java.jungle.repository.Parts;

import com.java.jungle.model.dto.CustomerView;
import com.java.jungle.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
