// Copyright (c) 2019, 2020, Oracle Corporation and/or its affiliates.
// Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.

package com.oracle.weblogic.imagetool.installer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.oracle.weblogic.imagetool.util.Utils;

/**
 * Supported Fusion Middleware installer sets.
 * Each installer set contains a list of ARU Products for resolving the product name and ARU ID,
 * as well as a list of installers needed to create the Oracle Home for that product.
 */
public enum FmwInstallerType {
    // data from https://updates.oracle.com/Orion/Services/metadata?table=aru_products

    // Oracle WebLogic Server
    WLSSLIM(Arrays.asList(AruProduct.WLS, AruProduct.COH),
        InstallerType.WLSSLIM),
    WLSDEV(Arrays.asList(AruProduct.WLS, AruProduct.COH),
        InstallerType.WLSDEV),
    WLS(Arrays.asList(AruProduct.WLS, AruProduct.COH),
        InstallerType.WLS),
    // Oracle WebLogic Server Infrastructure (JRF)
    FMW(Arrays.asList(AruProduct.WLS, AruProduct.COH),
        InstallerType.FMW),
    // Oracle Service Bus
    OSB(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.OSB),
        InstallerType.FMW, InstallerType.OSB),
    // Oracle SOA Suite
    SOA(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.SOA),
        InstallerType.FMW, InstallerType.SOA),
    // Oracle SOA Suite (with Service Bus)
    SOA_OSB(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.SOA, AruProduct.OSB),
        InstallerType.FMW, InstallerType.SOA, InstallerType.OSB),
    // Oracle Identity Manager
    IDM(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.IDM),
        InstallerType.FMW, InstallerType.IDM),
    // Oracle Identity Manager
    IDM_WLS(Collections.singletonList(AruProduct.IDM),
        InstallerType.IDM),
    // Oracle Access Manager
    OAM(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.OAM),
        InstallerType.FMW, InstallerType.OAM),
    // Oracle Identity Governance
    OIG(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.SOA, AruProduct.OSB, AruProduct.IDM),
        InstallerType.FMW, InstallerType.SOA, InstallerType.OSB, InstallerType.IDM),
    // Oracle Unified Directory
    OUD(Collections.singletonList(AruProduct.OUD),
        InstallerType.OUD),
    // Oracle Unified Directory
    OUD_WLS(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.OUD),
        InstallerType.FMW, InstallerType.OUD),
    // Oracle WebCenter Content
    WCC(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.WCC),
        InstallerType.FMW, InstallerType.WCC),
    // Oracle WebCenter Portal
    WCP(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.WCP),
        InstallerType.FMW, InstallerType.WCP),
    // Oracle WebCenter Sites
    WCS(Arrays.asList(AruProduct.WLS, AruProduct.COH, AruProduct.WCS),
        InstallerType.FMW, InstallerType.WCS)
    ;

    private InstallerType[] installers;
    private List<AruProduct> products;
    FmwInstallerType(List<AruProduct> products, InstallerType... installers) {
        this.installers = installers;
        this.products = products;
    }

    public List<InstallerType> installerList() {
        return Arrays.asList(installers);
    }

    public String installerListString() {
        return Arrays.stream(installers).map(Object::toString).collect(Collectors.joining(", "));
    }

    public List<AruProduct> products() {
        return products;
    }

    /**
     * Create the FMW installer type Enum from the String value.
     * @param value the installer type string, ignoring case.
     * @return the enum installer type.
     */
    public static FmwInstallerType fromValue(String value) {
        for (FmwInstallerType type : values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException(Utils.getMessage("IMG-0080", value));
    }
}
