/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.api.testmode.valetparking.ValetParkingTestmodeListenerAdapter;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingServiceImpl;

public class ValetParkingTestmodeListener
extends ValetParkingTestmodeListenerAdapter {
    private final ValetParkingServiceImpl valetParkingService;

    ValetParkingTestmodeListener(ValetParkingServiceImpl valetParkingServiceImpl) {
        Preconditions.checkArgumentNotNull(valetParkingServiceImpl);
        this.valetParkingService = valetParkingServiceImpl;
    }

    @Override
    public void notifyValetParkingTestmodeStateChanged(boolean bl) {
        this.valetParkingService.notifyServiceOnValetParkingStateChanged(bl);
    }
}

