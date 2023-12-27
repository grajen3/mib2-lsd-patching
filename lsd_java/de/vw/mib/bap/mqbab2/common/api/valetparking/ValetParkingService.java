/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.valetparking;

import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingServiceListener;

public interface ValetParkingService {
    default public void addValetParkingServiceListener(ValetParkingServiceListener valetParkingServiceListener, int[] nArray) {
    }

    default public void removeValetParkingServiceListener(ValetParkingServiceListener valetParkingServiceListener, int[] nArray) {
    }

    default public boolean isValetParkingActive() {
    }
}

