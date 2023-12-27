/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.impl;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalUpdateListener;

public class CoreServiceExternalUpdateListenerImpl
implements CoreServiceExternalUpdateListener {
    @Override
    public void updateDeviceStatusAvailability(int n, int n2) {
        CoreServiceImplFactory.getCoreServiceController().updateDeviceStatusAvailability(n, n2);
    }

    @Override
    public void updateRegisteredDeviceType(int n, int n2) {
        CoreServiceImplFactory.getCoreServiceController().updateRegisteredDeviceType(n, n2);
    }

    @Override
    public void updateSPinRequired(String string) {
        CoreServiceImplFactory.getAuthentication().updateSPinRequired(string);
    }
}

