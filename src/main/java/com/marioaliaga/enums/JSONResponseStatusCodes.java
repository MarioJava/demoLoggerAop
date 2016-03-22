package com.marioaliaga.enums;

public enum JSONResponseStatusCodes {
    OK(200),
    NOT_FOUND(404),
    SERVER_500(500),
    OTHER_ERROR_CODE(501);

    private final int value;

    JSONResponseStatusCodes(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public String stringResponseCode() {
        return Integer.toString(value);
    }

}
