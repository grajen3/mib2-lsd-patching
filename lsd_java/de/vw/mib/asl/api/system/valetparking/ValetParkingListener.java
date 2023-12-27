/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.valetparking;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;

public interface ValetParkingListener {
    default public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
    }
}

