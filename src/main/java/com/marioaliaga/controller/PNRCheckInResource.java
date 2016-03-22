package com.marioaliaga.controller;

import com.lan.core.ws.rest.JSONResponse;
import com.lan.core.ws.rest.JsonResponseBuilder;
import com.lan.core.ws.rest.ServiceStatus;
import com.marioaliaga.domain.PNRCheckIn;
import com.marioaliaga.exceptions.CheckInServiceException;
import com.marioaliaga.exceptions.CheckInServicePNRNotFoundException;
import com.marioaliaga.service.IPNRCheckInService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maliaga on 3/15/16.
 */
@RestController
public class PNRCheckInResource {

    private static final String THE_BOOKING_REQUESTED_WAS_NOT_FOUND = "The booking requested was not found";
    private static final int BOOKING_NOT_FOUND_CODE = 404;
    private static final String BOOKING_NOT_FOUND_MESSAGE = "Booking not found";
    private static final String GET = "get";
    private static final int ERROR_CODE = 500;
    private static final String ERROR_MESSAGE = "Could not get the booking";


    @Autowired
    @Setter
    private IPNRCheckInService checkInService;

    @RequestMapping(value = "/checkin/pnrs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONResponse<PNRCheckIn> get() {
        PNRCheckIn pnrCheckIn;
        try {
            pnrCheckIn = checkInService.getByRecordAndLastName();
        } catch (CheckInServicePNRNotFoundException e) {
            return new JsonResponseBuilder<PNRCheckIn>().addStatus(new ServiceStatus(BOOKING_NOT_FOUND_CODE, BOOKING_NOT_FOUND_MESSAGE)).buildJsonResponse();
        } catch (CheckInServiceException e) {
            return new JsonResponseBuilder<PNRCheckIn>().addStatus(new ServiceStatus(ERROR_CODE, ERROR_MESSAGE)).buildJsonResponse();
        }
        return new JsonResponseBuilder<PNRCheckIn>().addData(pnrCheckIn).buildJsonResponse();
    }

    @RequestMapping(value = "/checkin/pnrs/{recordLocator}::{lastName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONResponse<PNRCheckIn> get(@PathVariable("recordLocator") String recordLocator,
                                        @PathVariable("lastName") String lastName) {
        PNRCheckIn pnrCheckIn;
        try {
            pnrCheckIn = checkInService.getByRecordAndLastName(recordLocator, lastName);
        } catch (CheckInServicePNRNotFoundException e) {
            return new JsonResponseBuilder<PNRCheckIn>().addStatus(new ServiceStatus(BOOKING_NOT_FOUND_CODE, BOOKING_NOT_FOUND_MESSAGE)).buildJsonResponse();
        } catch (CheckInServiceException e) {
            return new JsonResponseBuilder<PNRCheckIn>().addStatus(new ServiceStatus(ERROR_CODE, ERROR_MESSAGE)).buildJsonResponse();
        }
        return new JsonResponseBuilder<PNRCheckIn>().addData(pnrCheckIn).buildJsonResponse();
    }
}
