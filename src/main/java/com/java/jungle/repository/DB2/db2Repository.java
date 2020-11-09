package com.java.jungle.repository.DB2;

//import com.java.jungle.model.Parts;
import com.java.jungle.model.db2Entity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.java.jungle.repository.db2Repository",
//        entityManagerFactoryRef = "db2EntityManagerFactory",
//        transactionManagerRef = "db2TransactionManager")

@Repository
public interface db2Repository extends JpaRepository<db2Entity, Integer> {
}
