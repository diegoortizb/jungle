 package com.java.jungle.config;

// import com.java.jungle.model.Parts;
 import com.java.jungle.model.db2Entity;
// import com.zaxxer.hikari.HikariDataSource;
 import org.apache.commons.dbcp2.BasicDataSource;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
 import org.springframework.boot.context.properties.ConfigurationProperties;
 import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 import org.springframework.orm.jpa.JpaTransactionManager;
 import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
 import org.springframework.transaction.PlatformTransactionManager;
 import org.springframework.transaction.annotation.EnableTransactionManagement;

 import javax.sql.DataSource;



 @Configuration
 @EnableTransactionManagement
 @EnableJpaRepositories(basePackages = "com.java.jungle.repository.DB2",
         entityManagerFactoryRef = "db2EntityManagerFactory",
         transactionManagerRef = "db2TransactionManager")

public class Db2ConfigController {


    @Bean(name = "db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(db2()).packages(db2Entity.class).build();
    }


    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager db2TransactionManager(final @Qualifier ("db2EntityManagerFactory") LocalContainerEntityManagerFactoryBean db2EntityManagerFactory){
        return new JpaTransactionManager(db2EntityManagerFactory.getObject());
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2() {
        return db2DataSourceProperties().initializeDataSourceBuilder().type(BasicDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db2.configuration")
    public DataSourceProperties db2DataSourceProperties() {
        return new DataSourceProperties();
    }
}