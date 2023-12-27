/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.valetparking;

import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;

public interface ValetParkingService {
    default public void addListener(ValetParkingListener valetParkingListener) {
    }

    default public boolean getCurrentValetParkingState() {
    }

    default public void removeListener(ValetParkingListener valetParkingListener) {
    }
}

