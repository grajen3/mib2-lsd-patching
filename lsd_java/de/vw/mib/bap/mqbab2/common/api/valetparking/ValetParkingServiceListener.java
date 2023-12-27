/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.valetparking;

import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingService;

public interface ValetParkingServiceListener {
    public static final int VALET_PARKING_SERVICE__VALET_PARKING_ACTIVE;

    default public void updateValetParkingData(ValetParkingService valetParkingService, int n) {
    }
}

