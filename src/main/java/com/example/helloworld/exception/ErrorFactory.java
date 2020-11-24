package com.example.helloworld.exception;

import com.example.helloworld.service.Singleton;

public class ErrorFactory extends Singleton {
    private final Object[] error_codes = new Object[50];

    public ErrorFactory(){

        this.error_codes[0] = new ErrorResponse("0", "500", "Generic error message.");
        this.error_codes[1] = new ErrorResponse("1", "400", "Parameters missing.");
        this.error_codes[2] = new ErrorResponse("2", "400", "Invalid e-mail.");
        this.error_codes[3] = new ErrorResponse("3", "400", "Invalid registration (index_number).");
        this.error_codes[4] = new ErrorResponse("4", "400", "Model with e-mail doesn't exist.");
        this.error_codes[5] = new ErrorResponse("5", "500", "The table in the database does not exist!");
        this.error_codes[6] = new ErrorResponse("6", "500", "System error!");
        this.error_codes[7] = new ErrorResponse("7", "400", "Sorry, the student already exists!");
        this.error_codes[8] = new ErrorResponse("8", "400", "Invalid index number!");

        //Standard response for successful HTTP requests
        this.error_codes[9] = new ErrorResponse("9", "200", "Successful!");

        //The requested resource could not be found but may be available in the future.
        this.error_codes[10] = new ErrorResponse("10", "404", "This page can’t be found");

    }

    public Object getError(int code) {
        Object $res = this.error_codes[code];

        if ($res.equals(this.error_codes[code])) {
            return $res;
        } else {
            return this.error_codes[0];
        }
    }

}
