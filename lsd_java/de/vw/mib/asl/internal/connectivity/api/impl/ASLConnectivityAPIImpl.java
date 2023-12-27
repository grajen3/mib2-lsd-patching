/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.api.impl;

import de.vw.mib.asl.api.connectivity.ASLConnectivityAPI;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.connectivity.ASLWLANData;

public class ASLConnectivityAPIImpl
implements ASLConnectivityAPI {
    @Override
    public boolean isWLANActivated() {
        return ASLWLANData.isWLANActivated();
    }

    @Override
    public void setSimOrSurfstickInserted(boolean bl) {
        ASLWLANData.setSimOrSurfstickInserted(bl);
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 7801, -1047453440, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7801, -1013899008, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7801, -963567360, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7801, -896458496, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7801, -997121792, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7801, -980344576, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7801, -1030676224, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7801, -913235712, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7800, -946790144, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7800, -930012928, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7800, -879681280, true);
    }
}

