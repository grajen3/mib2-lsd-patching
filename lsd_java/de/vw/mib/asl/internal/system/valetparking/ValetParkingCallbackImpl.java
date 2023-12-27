/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingNotification;
import de.vw.mib.log4mib.Logger;

class ValetParkingCallbackImpl
implements ValetParkingCallback {
    private static final String LOG_PREFIX;
    private boolean alreadyCalled = false;
    private boolean invalid = false;
    private final String listenerName;
    private final Logger logger;
    private final ValetParkingNotification parentNotification;

    ValetParkingCallbackImpl(String string, ValetParkingNotification valetParkingNotification, Logger logger) {
        this.parentNotification = valetParkingNotification;
        this.listenerName = string;
        this.logger = logger;
    }

    @Override
    public void notifyValetParkingTransitionFinished(boolean bl) {
        if (this.alreadyCalled) {
            this.logger.warn(2048, "[ValetParkingCallbackImpl] A doublicated callback occured.");
            return;
        }
        if (this.invalid) {
            this.logger.warn(2048, "[ValetParkingCallbackImpl] A callback occured after internal timeout.");
            return;
        }
        this.parentNotification.notifyCallbackAnswer(this, bl);
        this.alreadyCalled = true;
    }

    String getListenerName() {
        return this.listenerName;
    }

    void setInvalid() {
        this.invalid = true;
    }
}

