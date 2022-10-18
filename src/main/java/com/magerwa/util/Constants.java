package com.magerwa.util;

import com.magerwa.exceptions.CustomRequestException;

import java.io.Serializable;

public class Constants implements Serializable {

    public static final long serialVersionUID = 2069937152339670231L;
    public static final String MESSAGE = "message";
    public static final String VEHICLE_CONFIGURATION_NOT_FOUND = "Did not find the vehicle make/model";
    public static final String VEHICLE_NOT_FOUND = "Did not find the vehicle";

    private Constants() {
        throw new CustomRequestException();
    }

}
