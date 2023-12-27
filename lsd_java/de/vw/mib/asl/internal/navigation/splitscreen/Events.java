/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    private static final int[] ASL_OBSERVERS;
    private static final int[] ASL_SERVICES;

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(ASL_OBSERVERS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(ASL_OBSERVERS);
    }

    static void registerASLServices(AbstractTarget abstractTarget) {
        abstractTarget.registerServices(ASL_SERVICES, false);
    }

    static {
        if (ServiceManager.configManagerDiag != null) {
            PreRegisteredIds.addServiceOrObserverToArray(0, 1900745728, -1169935104, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, 1900745728, -1186712320, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, 1900745728, -1153157888, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, 1900745728, -1136380672, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -1706355712, -1102826240, true);
        }
        ASL_OBSERVERS = new int[]{956432448, 973209664, 989986880, 1006764096};
        ASL_SERVICES = new int[]{828650752, -1186712320, -1169935104, -1153157888, -1136380672, -1119603456, -1102826240, -1086049024, -1069271808, -1052494592, -1035717376};
    }
}

