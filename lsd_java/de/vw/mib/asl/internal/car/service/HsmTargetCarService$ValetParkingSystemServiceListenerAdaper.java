/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.car.service.HsmTargetCarService;

public class HsmTargetCarService$ValetParkingSystemServiceListenerAdaper
extends ValetParkingListenerAdapter {
    private final /* synthetic */ HsmTargetCarService this$0;

    public HsmTargetCarService$ValetParkingSystemServiceListenerAdaper(HsmTargetCarService hsmTargetCarService) {
        this.this$0 = hsmTargetCarService;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        AbstractASLTarget.writeBooleanToDatapool(10668, bl);
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }
}

