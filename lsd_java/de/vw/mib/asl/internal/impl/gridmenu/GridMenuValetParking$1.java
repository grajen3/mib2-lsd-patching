/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.gridmenu;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.internal.impl.gridmenu.GridMenuValetParking;

class GridMenuValetParking$1
implements ValetParkingListener {
    private final /* synthetic */ GridMenuValetParking this$0;

    GridMenuValetParking$1(GridMenuValetParking gridMenuValetParking) {
        this.this$0 = gridMenuValetParking;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        this.this$0.updateDataPool(bl);
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }
}

