/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.internal.system.keypanel.lock.components.ValetParkingComponent;

class ValetParkingComponent$1
implements ValetParkingListener {
    private final /* synthetic */ ValetParkingComponent this$0;

    ValetParkingComponent$1(ValetParkingComponent valetParkingComponent) {
        this.this$0 = valetParkingComponent;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        this.this$0.setLocked(bl);
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }
}

