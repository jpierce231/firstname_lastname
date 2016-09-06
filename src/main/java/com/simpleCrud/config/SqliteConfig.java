package com.simpleCrud.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by jpierce on 9/3/16.
 * Spring Boot doesn't have auto support for SQLite so create the DataSource here
 * AutoConfiguration will pick this up
 */
@Configuration
public class SqliteConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url("jdbc:sqlite::memory:simplecrud.db");
        return dataSourceBuilder.build();
    }
}
