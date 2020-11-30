package com.java.jungle.repository.Parts;

import com.java.jungle.model.Orders;
import com.java.jungle.model.Taxes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT DISTINCT ordertuple.email FROM Orders ordertuple")
    List <String> findAllByEmail();

    @Query("SELECT ordertuple FROM Orders ordertuple WHERE ordertuple.email = :#{#customer} AND ordertuple.status = 1")
    List <Orders> findOrdersOf(@Param("customer") String customer);
}
