/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.swdl2;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.internal.download.swdl2.CancelCustomerDownloadProcess;

class CancelCustomerDownloadProcess$1
extends ValetParkingListenerAdapter {
    private final /* synthetic */ CancelCustomerDownloadProcess this$0;

    CancelCustomerDownloadProcess$1(CancelCustomerDownloadProcess cancelCustomerDownloadProcess) {
        this.this$0 = cancelCustomerDownloadProcess;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        this.this$0.verifyValetParkingState(bl);
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }
}

