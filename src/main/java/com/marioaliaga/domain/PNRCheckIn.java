package com.marioaliaga.domain;

import lombok.Data;

/**
 * Created by maliaga on 3/21/16.
 */
@Data
public class PNRCheckIn {

    private String holding;

    public PNRCheckIn(String holding){
        this.holding = holding;
    }
}
