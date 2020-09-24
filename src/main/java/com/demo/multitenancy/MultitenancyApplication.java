package com.demo.multitenancy;

import com.demo.multitenancy.routing.config.TenantAwareRoutingSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MultitenancyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultitenancyApplication.class, args);
    }

    @Bean
    public DataSource dataSource() {

        AbstractRoutingDataSource dataSource = new TenantAwareRoutingSource();

        Map<Object, Object> targetDataSources = new HashMap<>();

        targetDataSources.put("TenantOne", tenantOne());
        targetDataSources.put("TenantTwo", tenantTwo());

        dataSource.setTargetDataSources(targetDataSources);

        dataSource.afterPropertiesSet();

        return dataSource;
    }

    public DataSource tenantOne() {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);
        dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        dataSource.addDataSourceProperty("url", "jdbc:postgresql://127.0.0.1:5432/db1");
        dataSource.addDataSourceProperty("user", "marija");
        dataSource.addDataSourceProperty("password", "password");

        return dataSource;
    }

    public DataSource tenantTwo() {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);
        dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        dataSource.addDataSourceProperty("url", "jdbc:postgresql://127.0.0.1:5432/db2");
        dataSource.addDataSourceProperty("user", "marija");
        dataSource.addDataSourceProperty("password", "password");

        return dataSource;
    }

}
