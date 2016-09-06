package com.simpleCrud.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jpierce on 9/3/16.
 * Create the User table for the SQLite database on app startup
 */
@Component
public class DbUtils {

    @Autowired
    private DataSource dataSource;

    // Create the User table when the application starts up
    @PostConstruct
    public void initialize() {

        try {

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            statement.execute("DROP TABLE IF EXISTS USER");
            statement.executeUpdate(
                    "CREATE TABLE USER(" +
                    "ID INTEGER PRIMARY KEY, " +
                    "FIRSTNAME VARCHAR(25) NOT NULL, " +
                    "LASTNAME VARCHAR(25) NOT NULL, " +
                    "AGE INTEGER(3) NOT NULL)"
            );

        } catch (SQLException ex) {
            // TODO: log the exception with an actual logger
        }
    }
}
