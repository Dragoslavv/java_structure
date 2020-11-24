package com.example.helloworld.service;

import com.example.helloworld.connect.DatabaseConfiguration;
import com.example.helloworld.connect.DatabaseConnection;
import com.example.helloworld.exception.ErrorFactory;

public abstract class Singleton {
    private static DatabaseConnection $_instance = null;
    private static ErrorFactory $new_instance = null;

    public static synchronized DatabaseConnection getInstance(DatabaseConfiguration $config) {
        if($_instance == null) {
            $_instance =  new DatabaseConnection($config);
        }
        return $_instance;
    }

    public static synchronized ErrorFactory newInstance(){
        if($new_instance == null) {
            $new_instance = new ErrorFactory();
        }

        return $new_instance;
    }
}
