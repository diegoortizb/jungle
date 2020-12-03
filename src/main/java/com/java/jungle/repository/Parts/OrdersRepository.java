package com.java.jungle.repository.Parts;

import com.java.jungle.model.Orders;
import com.java.jungle.model.dto.OrdersView;
import com.java.jungle.model.Taxes;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT DISTINCT ordertuple.email FROM Orders ordertuple WHERE ordertuple.status = 1")
    List <String> findAllByEmail();

//    @Query("SELECT ordertuple FROM Orders ordertuple WHERE ordertuple.email = :#{#customer} AND ordertuple.status = 1")
//    List <Orders> findOrdersOf(@Param("customer") String customer);
//STATUS OF 1 MEANS THAT THE ORDER NEEDS TO BE SHIPPED

    @Query ("SELECT new com.java.jungle.model.dto.OrdersView(p.desc, o.email, o.name, o.mailingAddress, o.item_id, o.qty, o.status, o.id, o.price) " +
            "FROM Orders o JOIN Parts p ON p.id=o.item_id" +
            " WHERE o.status = 1 AND o.email= :#{#customer}")
    List<OrdersView> findOrdersOf(@Param("customer") String customer);
}
