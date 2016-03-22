package com.marioaliaga.service;

import com.marioaliaga.domain.PNRCheckIn;
import com.marioaliaga.exceptions.CheckInServiceException;

/**
 * Created by maliaga on 3/14/16.
 */
public interface IPNRCheckInService {
    PNRCheckIn getByRecordAndLastName(String recordLocator, String lastName) throws CheckInServiceException;
    PNRCheckIn getByRecordAndLastName() throws CheckInServiceException;
}
