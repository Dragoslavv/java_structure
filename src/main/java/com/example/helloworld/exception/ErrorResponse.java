package com.example.helloworld.exception;

import com.example.helloworld.HelloWorld;
import com.example.helloworld.service.ErrorHandlerInterface;
import org.json.simple.JSONObject;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse implements ErrorHandlerInterface {

    public String server_code;

    public String client_code;

    public String message;

    private final Logger logger = Logger.getLogger(HelloWorld.class);

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponse(String server_code, String client_code, String message) {
        this.server_code = server_code;
        this.client_code = client_code;
        this.message = message;
        BasicConfigurator.configure();
    }

    public JSONObject getJSONResponse() {
        this.logger.info("Sending response with server_code " + this.server_code +", client_code " + this.client_code + ", message " + this.message +" ");

        Map<String,String> jsonMap = new HashMap<>();
        jsonMap.put("code", this.client_code);
        jsonMap.put("message", this.message);

        try {
            return  (JSONObject) new JSONParser().parse(jsonMap.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String sendResponse(boolean die  , boolean errorMessage ) {
        this.logger.info("Sending response with server_code " + this.server_code + ", client_code " + this.client_code + ", message " + this.message +" ");

        String data = "HTTP/1.1 " + this.client_code + " " + this.message + " (" + this.server_code + ")";

        if(errorMessage){
            return this.message;
        }
        if (die) {
            System.exit(0);
        }
        return data;
    }

    public void responseInfo() {
        this.logger.info("Sending response with server_code " + this.server_code + ", client_code " + this.client_code + ", message  " + this.message + " ");
    }


}
