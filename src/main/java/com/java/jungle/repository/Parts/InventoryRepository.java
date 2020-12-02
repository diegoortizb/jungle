package com.java.jungle.repository.Parts;

import com.java.jungle.model.dto.CustomerView;
import com.java.jungle.model.Inventory;
import com.java.jungle.model.dto.inventoryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query("select new com.java.jungle.model.dto.inventoryObject(i.id,i.partID,i.qty) from Inventory i where i.partID = :#{#partId}")
    List<inventoryObject> searchByPartId(int partId);

    @Modifying
    @Query("update Inventory i SET i.qty = :qty WHERE i.id = :id")
    void updateQty(int qty, int id);


}
