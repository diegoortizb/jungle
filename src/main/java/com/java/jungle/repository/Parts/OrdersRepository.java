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

    @Query("SELECT ordertuple From Orders ordertuple WHERE ordertuple.status = :#{#status}")
    List <Orders> searchedByStatus(@Param("status") int status);

    @Query("SELECT ordertuple From Orders ordertuple WHERE ordertuple.price BETWEEN :#{#price1} AND :#{#price2}")
    List <Orders> searchedByPrice(@Param("price1") float price1, @Param("price2") float price2);

    @Query("SELECT ordertuple From Orders ordertuple WHERE ordertuple.subDate BETWEEN :#{#date1} AND :#{#date2}")
    List <Orders> searchedByDate(@Param("date1") java.sql.Date date1, @Param("date2") java.sql.Date date2);

    @Query ("SELECT new com.java.jungle.model.dto.OrdersView(p.desc, o.email, o.name, o.mailingAddress, o.item_id, o.qty, o.status, o.id, o.price) " +
            "FROM Orders o JOIN Parts p ON p.id=o.item_id" +
            " WHERE o.status = 1 AND o.email= :#{#customer}")
    List<OrdersView> findOrdersOf(@Param("customer") String customer);
}
