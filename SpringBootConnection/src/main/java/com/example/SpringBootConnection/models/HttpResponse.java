package com.example.SpringBootConnection.models;

public class HttpResponse {
    private String data, message;
    private boolean success;

    public HttpResponse(String data, String message, boolean success) {

        setData(data);

        setMessage(message);

        setSuccess(success);

    }

    public String getData() {

        return data;

    }

    public void setData(String data) {

        this.data = data;

    }

    public String getMessage() {

        return message;

    }

    public void setMessage(String message) {

        this.message = message;

    }

    public boolean isSuccess() {

        return success;

    }

    public void setSuccess(boolean success) {

        this.success = success;

    }

}
