/* Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved. */

package com.oracle.weblogicx.imagebuilder.api.model;

/**
 * Supported domain type. wls, jrf or restricted jrf.
 */
public enum DomainType {
    WLS("wls"),
    JRF("jrf"),
    RestrictedJRF("rjrf");

    private String value;

    DomainType(String value) {
        this.value = value;
    }

/*
    @Override
    public String toString() {
        return value;
    }
*/

    public static DomainType fromValue(String value) {
        for (DomainType eachType : DomainType.values()) {
            if (eachType.value.equalsIgnoreCase(value)) {
                return eachType;
            }
        }
        throw new IllegalArgumentException("argument " + value + " does not match any DomainType");
    }
}

