/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.valetparking;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;

public class ValetParkingListenerAdapter
implements ValetParkingListener {
    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        valetParkingCallback.notifyValetParkingTransitionFinished(false);
    }
}

