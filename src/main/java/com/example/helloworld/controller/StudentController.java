package com.example.helloworld.controller;

import com.example.helloworld.model.Student;

public class StudentController {

    public static boolean index(){
        Student table = new Student();

        if(table.find_table() != false){
            return true;
        } else {
            return table.create_table();
        }
    }

    public static boolean destroy(){
        Student table = new Student();

        return table.delete_table();
    }
}
