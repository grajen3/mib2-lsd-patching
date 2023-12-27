/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.internal.system.input.UserInteractionLockServiceImpl;

class UserInteractionLockServiceImpl$1
implements ValetParkingListener {
    private final /* synthetic */ UserInteractionLockServiceImpl this$0;

    UserInteractionLockServiceImpl$1(UserInteractionLockServiceImpl userInteractionLockServiceImpl) {
        this.this$0 = userInteractionLockServiceImpl;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        this.this$0.isValetParkingActive = bl;
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }
}

