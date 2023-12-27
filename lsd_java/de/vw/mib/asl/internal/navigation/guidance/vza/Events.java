/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    static final int[] OBSERVERS;

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(OBSERVERS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVERS);
    }

    static {
        if (ServiceManager.configManagerDiag != null) {
            PreRegisteredIds.addServiceOrObserverToArray(2, 1766528000, 638263296, false);
            PreRegisteredIds.addServiceOrObserverToArray(2, 1766528000, 705372160, false);
            PreRegisteredIds.addServiceOrObserverToArray(2, 1766528000, -459521792, false);
        }
        OBSERVERS = new int[]{638263296, -459521792, 705372160};
    }
}

