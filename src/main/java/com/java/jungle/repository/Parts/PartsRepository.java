package com.java.jungle.repository.Parts;

import com.java.jungle.model.Parts;
import com.java.jungle.model.dto.CustomerView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PartsRepository extends JpaRepository<Parts, Integer> {

    @Query(value = "SELECT new com.java.jungle.model.dto.CustomerView(p.id, i.id, p.desc, p.price, p.weight, p.pictureURL, i.qty) " +
            "FROM Parts p, Inventory i " +
            "WHERE i.partID = p.id AND i.qty > 0")
    List<CustomerView> getCustomerView();
}
