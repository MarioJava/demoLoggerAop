package com.marioaliaga.exceptions;

/**
 * Created by maliaga on 3/21/16.
 */
public class CheckInServicePNRNotFoundException extends CheckInServiceException {
    public CheckInServicePNRNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckInServicePNRNotFoundException(String message) {
        super(message);
    }
}
