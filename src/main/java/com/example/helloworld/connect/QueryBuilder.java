package com.example.helloworld.connect;

public class QueryBuilder {

    public static DatabaseConnection StartConnection() {

        DatabaseConfiguration config = new DatabaseConfiguration("jdbc:mysql://localhost:3306/", "quantox_test", "com.mysql.cj.jdbc.Driver", "admin", "Admin4321");

        DatabaseConnection connection = DatabaseConnection.getInstance(config);

        return connection;
    }
}
