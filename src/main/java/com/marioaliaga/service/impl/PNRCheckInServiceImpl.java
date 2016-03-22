package com.marioaliaga.service.impl;

import com.marioaliaga.domain.PNRCheckIn;
import com.marioaliaga.exceptions.CheckInServiceException;
import com.marioaliaga.exceptions.CheckInServicePNRNotFoundException;
import com.marioaliaga.service.IPNRCheckInService;
import org.springframework.stereotype.Component;

/**
 * Created by maliaga on 3/14/16.
 */
@Component
public class PNRCheckInServiceImpl implements IPNRCheckInService {

    @Override
    public PNRCheckIn getByRecordAndLastName(String recordLocator, String lastName) throws CheckInServiceException {

        switch (recordLocator) {
            case "XXX501":
                throw new CheckInServiceException("getByRecordAndLastName :: CheckInServiceException");
            case "XXX404":
                throw new CheckInServicePNRNotFoundException("getByRecordAndLastName :: CheckInServicePNRNotFoundException");
        }
        return new PNRCheckIn("LAN");
    }

    @Override
    public PNRCheckIn getByRecordAndLastName() throws CheckInServiceException {
        System.out.println("getByRecordAndLastName sin parametros ");
        return new PNRCheckIn("LATAM");
    }
}
