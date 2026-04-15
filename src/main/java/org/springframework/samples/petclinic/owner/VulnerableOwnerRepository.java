package org.springframework.samples.petclinic.owner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableOwnerRepository {

    private Connection connection;

    public VulnerableOwnerRepository(Connection connection) {
        this.connection = connection;
    }

    public ResultSet findOwnerByLastName(String lastName) throws Exception {

        // ❌ SQL Injection Vulnerability
        String query = "SELECT * FROM owners WHERE last_name = '" + lastName + "'";

        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }
}