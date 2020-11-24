package com.example.helloworld;

import com.example.helloworld.connect.QueryBuilder;
import com.example.helloworld.controller.StudentController;
import com.example.helloworld.exception.ErrorFactory;
import com.example.helloworld.exception.ErrorResponse;
import com.example.helloworld.model.Student;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HelloWorld {
    static final Logger logger = Logger.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        //Configure logger
        BasicConfigurator.configure();

        System.out.println(StudentController.destroy());


        logger.debug(ErrorFactory.newInstance().getError(8));

    }
}
