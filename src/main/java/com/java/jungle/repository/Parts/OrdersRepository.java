package com.java.jungle.repository.Parts;

import com.java.jungle.model.Orders;
import com.java.jungle.model.Taxes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT DISTINCT ordertuple.email FROM Orders ordertuple")
    public List <String> findAllByEmail();
}
