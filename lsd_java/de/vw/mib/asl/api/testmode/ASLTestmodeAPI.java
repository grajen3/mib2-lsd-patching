/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.testmode;

import de.vw.mib.asl.api.testmode.valetparking.ValetParkingTestmodeService;

public interface ASLTestmodeAPI {
    public static final int DEBUG_PROBE_FROM_SD;
    public static final int DEBUG_PROBE_OFF;
    public static final int DEBUG_PROBE_HMIMONITOR;

    default public ValetParkingTestmodeService getTestmodeValetParkingService() {
    }
}

