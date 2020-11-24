package com.example.helloworld.connect;

import com.example.helloworld.service.Singleton;

import javax.xml.transform.Result;
import java.sql.Connection;

import java.sql.*;
import java.sql.DriverManager;

public class DatabaseConnection extends Singleton implements QueryBuilderInterface {

    private final DatabaseConfiguration configuration;

    private Connection connection;

    public PreparedStatement result;

    public DatabaseConnection(DatabaseConfiguration $config)
    {
        this.configuration = $config;
        this.getDB();
    }

    private void getDB(){
        try {

            Class.forName( this.configuration.getDriver() );
            this.connection = DriverManager.getConnection(this.configuration.getUrl()+this.configuration.getDbname()+"?autoReconnect=true&useSSL=false",this.configuration.getUsername(),this.configuration.getPassword());

            if(this.connection != null ){
                System.out.println("Connected to the database");
            }

        } catch (ClassNotFoundException ex) {

            System.out.println("Could not find database driver class");
            ex.printStackTrace();

        } catch (SQLException ex) {

            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();

        }
    }

    public void query(String $query) throws SQLException {
        this.result = this.connection.prepareStatement($query);
    }

    public boolean execute () throws SQLException {
        return this.result.execute();
    }

    public boolean getTable(String sql) throws SQLException {

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {

            return rs.getBoolean(1);
        }

        return false;
    }

    public String[] find_by_sql (String query) throws SQLException {
        this.result = this.connection.prepareStatement(query);
        ResultSet rs = this.result.executeQuery();

        String[] res = new String[]{};
        if(rs.next()){
            while (rs.next()){
               res[0] = rs.getString('1');
            }
        }
        rs.close();
        this.connection.close();
        return res;
    }

    public boolean resultSet (String $query) throws SQLException {
        this.result = this.connection.prepareStatement($query);
        return this.result.execute();
    }

}
