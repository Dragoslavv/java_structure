package com.example.helloworld.connect;

import java.sql.SQLData;
import java.sql.SQLException;

interface QueryBuilderInterface {

    void query(String $query) throws SQLException;

    boolean execute( ) throws SQLException;
}
