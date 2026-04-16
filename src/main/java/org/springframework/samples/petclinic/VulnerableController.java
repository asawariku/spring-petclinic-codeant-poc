package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableController {

    // 🔴 SQL Injection (Critical)
    public void getUser(String userInput) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:h2:mem:testdb");
        Statement stmt = con.createStatement();

        String query = "SELECT * FROM users WHERE name = '" + userInput + "'";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }

    // 🔴 Command Injection (Critical)
    public void runCommand(String input) throws Exception {
        Runtime.getRuntime().exec(input);
    }
}
//CHECK CODEaNT sCAN fAILS
//CHECKS 2 
