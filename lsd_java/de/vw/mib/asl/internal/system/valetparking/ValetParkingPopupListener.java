/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;

class ValetParkingPopupListener
extends ValetParkingListenerAdapter {
    private final SystemEventDispatcher systemEventDispatcher;

    ValetParkingPopupListener(SystemEventDispatcher systemEventDispatcher) {
        Preconditions.checkArgumentNotNull(systemEventDispatcher);
        this.systemEventDispatcher = systemEventDispatcher;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        if (bl) {
            this.systemEventDispatcher.createAndSubmitHMIEvent(1832001536);
        } else {
            this.systemEventDispatcher.createAndSubmitHMIEvent(1848778752);
        }
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }
}

