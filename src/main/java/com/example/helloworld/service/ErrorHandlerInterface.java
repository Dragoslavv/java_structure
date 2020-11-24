package com.example.helloworld.service;

import org.json.simple.JSONObject;

public interface ErrorHandlerInterface {
    public JSONObject getJSONResponse();

    public String sendResponse(boolean die, boolean errorMessage);

    public void responseInfo();
}

