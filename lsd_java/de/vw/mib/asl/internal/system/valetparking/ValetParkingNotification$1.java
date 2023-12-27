/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.internal.system.valetparking.TimeoutListener;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingNotification;

class ValetParkingNotification$1
implements TimeoutListener {
    private final /* synthetic */ ValetParkingNotification this$0;

    ValetParkingNotification$1(ValetParkingNotification valetParkingNotification) {
        this.this$0 = valetParkingNotification;
    }

    @Override
    public void notifyTimeout() {
        this.this$0.notifyTimeout();
    }
}

