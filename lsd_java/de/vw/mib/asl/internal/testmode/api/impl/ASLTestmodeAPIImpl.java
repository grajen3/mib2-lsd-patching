/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.api.impl;

import de.vw.mib.asl.api.testmode.ASLTestmodeAPI;
import de.vw.mib.asl.api.testmode.valetparking.ValetParkingTestmodeService;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.testmode.ValetParkingTestmodeServiceImpl;

public class ASLTestmodeAPIImpl
implements ASLTestmodeAPI {
    private ValetParkingTestmodeService tesmodeValetParkingService;

    @Override
    public ValetParkingTestmodeService getTestmodeValetParkingService() {
        if (this.tesmodeValetParkingService == null) {
            this.tesmodeValetParkingService = new ValetParkingTestmodeServiceImpl();
        }
        return this.tesmodeValetParkingService;
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, -221178624, -39714816, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -221178624, -1398603776, true);
    }
}

