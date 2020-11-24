package com.example.helloworld.model;

import com.example.helloworld.connect.DatabaseConnection;
import com.example.helloworld.connect.QueryBuilder;

import java.sql.SQLException;

public class Student extends AbstractModel {

    protected String table_name = "quantox_student";

    private DatabaseConnection db;

    protected String[] $fillStudetTable = new String[]{
            "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT",
            "first_name VARCHAR(80) NOT NULL",
            "last_name VARCHAR(80) NOT NULL",
            "email VARCHAR(100) NOT NULL",
            "create_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            "UNIQUE KEY unique_email (email)"
    };

    protected String[] $fillStudent = new String[]{
            "first_name", "last_name", "email"
    };

    public Student () {
        try {
            this.db = QueryBuilder.StartConnection();
        }
        catch(Exception $e) {
            System.out.println($e.getMessage());
        }
    }

    public boolean insert_table(Object Data) {
        try {
            String sql = "INSERT INTO" + this.table_name + " (" + String.join(",",this.$fillStudent) + ") VALUES (?,?,?,?)";
            return this.db.resultSet(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean find_table(){
        try {
            String sql = "SELECT 1 FROM "+ this.table_name +"";
            return this.db.getTable(sql);
        } catch (SQLException $e) {
            System.out.println($e.getMessage());
        }
        return false;
    }


    public boolean create_table() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS "+ this.table_name +"(";
            sql += ""+ String.join(",", this.$fillStudetTable) +"";
            sql += ")ENGINE = InnoDB AUTO_INCREMENT = 10000;";

            return this.db.resultSet(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean delete_table(){

        try {
            String sql = "DROP TABLE" + this.table_name + "";

            return this.db.resultSet(sql);

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

}
