package com.marioaliaga.controller;

import com.marioaliaga.DemoLoggerAopApplication;
import com.marioaliaga.domain.PNRCheckIn;
import com.marioaliaga.enums.Holding;
import com.marioaliaga.exceptions.CheckInServiceException;
import com.marioaliaga.exceptions.CheckInServicePNRNotFoundException;
import com.marioaliaga.service.IPNRCheckInService;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoLoggerAopApplication.class)
@WebAppConfiguration
public class DemoLoggerAopApplicationTests {

    @Autowired
    @Setter
    IPNRCheckInService checkInService;

	@Test
    public void deberiaObtenerRespuestaNOT_FOUND() throws CheckInServiceException {

        String recordLocator = "XXX404";
        String lasName = "Aliaga";

        PNRCheckIn pnrCheckIn = null;
        try {
            pnrCheckIn = checkInService.getByRecordAndLastName(recordLocator, lasName);

        } catch (CheckInServicePNRNotFoundException e){
            assertEquals(e.getMessage(),"getByRecordAndLastName :: CheckInServicePNRNotFoundException");
            assertNull(pnrCheckIn);
        }

    }

    @Test
    public void deberiaObtenerRespuesta501() throws CheckInServiceException {

        String recordLocator = "XXX501";
        String lasName = "Aliaga";

        PNRCheckIn pnrCheckIn = null;
        try {
            pnrCheckIn = checkInService.getByRecordAndLastName(recordLocator, lasName);

        } catch (CheckInServiceException e){
            assertEquals(e.getMessage(),"getByRecordAndLastName :: CheckInServiceException");
            assertNull(pnrCheckIn);
        }

    }

    @Test
    public void deberiaObtenerRespuestaOK() throws CheckInServiceException {

        String recordLocator = "XXXXXX";
        String lasName = "Aliaga";

        PNRCheckIn pnrCheckIn = checkInService.getByRecordAndLastName(recordLocator, lasName);

        assertNotNull(pnrCheckIn);
        assertEquals(pnrCheckIn.getHolding(), Holding.LAN.name());

    }

}
