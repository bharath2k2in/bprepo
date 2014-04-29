package com.home.work.home_expenses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Bharath on 30-03-2014.
 */
public class DBConnectionTest {

    public static void main(String args[]) {
        String userName = "sa";
        String password = "*******";

        String url = "jdbc:sqlserver://BHARATH-PC\\SQLEXPRESS;databaseName=Home";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url, userName, password);

            System.out.println("success");

            Statement statement = conn.createStatement();
            String queryString = "select * from income_and_expense";
            ResultSet rs = statement.executeQuery(queryString);
            while (rs.next()) {
                System.out.println(rs.getString("amount"));
                System.out.println(rs.getString("description"));
            }
        } catch (Exception e) {
            System.out.println("exception " + e.getMessage());
        }
    }
}
