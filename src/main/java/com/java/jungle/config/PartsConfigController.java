 package com.java.jungle.config;

import com.java.jungle.model.Parts;
import com.java.jungle.model.db2Entity;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import java.sql.DriverManager;

/*@Configuration
public class ConfigController {
    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource firstDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("spring.datasource.db-1.driver-class-name"));
        dataSource.setUrl(env.getProperty(env.getProperty("spring.datasource.db-1.url")));
        dataSource.setUsername(env.getProperty("spring.datasource.db-1.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.db-1.password"));
        return dataSource;
    }

    @Bean
    public DataSource secondDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("spring.datasource.db-2.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.db-2.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.db-2.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.db-2.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplateOne(@Qualifier("firstDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }

    @Bean
    public JdbcTemplate JdbcTemplateTwo(@Qualifier("secondDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }
}
*/

 @Configuration
 @EnableTransactionManagement
 @EnableJpaRepositories(basePackages = "com.java.jungle.repository.Parts",
         entityManagerFactoryRef = "partsEntityManagerFactory",
         transactionManagerRef = "partsTransactionManager")

public class PartsConfigController {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSourceProperties partsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.db1.configuration")
    public DataSource partsDataSource() {
        return partsDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "partsEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean partsEntityManagerFactory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(partsDataSource()).packages(Parts.class).build();
    }

    @Primary
    @Bean(name = "partsTransactionManager")
    public PlatformTransactionManager partsTransactionManager( final @Qualifier ("partsEntityManagerFactory") LocalContainerEntityManagerFactoryBean partsEntityManagerFactory){
        return new JpaTransactionManager(partsEntityManagerFactory.getObject());
    }
}