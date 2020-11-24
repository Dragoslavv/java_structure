package com.example.helloworld.service;

import java.sql.SQLData;

interface QueryBuilderInterface {

    public boolean prepare(SQLData $sql);

    public boolean query(SQLData $sql);

    public boolean execute( );
}
