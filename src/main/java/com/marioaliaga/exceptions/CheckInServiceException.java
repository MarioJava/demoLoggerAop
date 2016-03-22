package com.marioaliaga.exceptions;

/**
 * Created by maliaga on 3/14/16.
 */
public class CheckInServiceException extends Exception{

    public CheckInServiceException() {
    }

    public CheckInServiceException(String message) {
        super(message);
    }

    public CheckInServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckInServiceException(Throwable cause) {
        super(cause);
    }

    public CheckInServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
