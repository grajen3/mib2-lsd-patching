/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.testmode.valetparking;

import de.vw.mib.asl.api.testmode.valetparking.ValetParkingTestmodeListener;

public interface ValetParkingTestmodeService {
    public static final boolean VALET_PARKING_STATE_ON;
    public static final boolean VALET_PARKING_STATE_OFF;

    default public boolean isValetParkingActive() {
    }

    default public void addListener(ValetParkingTestmodeListener valetParkingTestmodeListener) {
    }

    default public void removeListener(ValetParkingTestmodeListener valetParkingTestmodeListener) {
    }
}

