/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.internal.system.valetparking.TimeoutListener;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingNotificationTimer;

class ValetParkingNotificationTimer$1
implements Runnable {
    private final /* synthetic */ TimeoutListener val$listener;
    private final /* synthetic */ ValetParkingNotificationTimer this$0;

    ValetParkingNotificationTimer$1(ValetParkingNotificationTimer valetParkingNotificationTimer, TimeoutListener timeoutListener) {
        this.this$0 = valetParkingNotificationTimer;
        this.val$listener = timeoutListener;
    }

    @Override
    public void run() {
        this.val$listener.notifyTimeout();
    }
}

