package com.java.jungle.repository.Parts;

import com.java.jungle.model.dto.CustomerView;
import com.java.jungle.model.Inventory;
import com.java.jungle.model.dto.inventoryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query("select i from Inventory i where i.partID = :#{#partId}")
    List<Inventory> searchByPartId(int partId);


    @Modifying
    @Query("update Inventory i SET i.qty = :qty WHERE i.partID = :partId")
    void updateQty(int qty, int partId);


}
