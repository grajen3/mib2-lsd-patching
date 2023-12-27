/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.internal.system.valetparking.ValetParkingServiceImpl;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingTransitionDoneListener;

class ValetParkingServiceImpl$1
implements ValetParkingTransitionDoneListener {
    private final /* synthetic */ ValetParkingServiceImpl this$0;

    ValetParkingServiceImpl$1(ValetParkingServiceImpl valetParkingServiceImpl) {
        this.this$0 = valetParkingServiceImpl;
    }

    @Override
    public void notifyTransitionDone() {
        this.this$0.notifyTransitionDone();
    }
}

