/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    public static final int EV_ASL_INT_STOP;
    private static final int[] ASL_OBSERVER;
    private static final int[] ASL_SERVICES;

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(ASL_OBSERVER);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(ASL_OBSERVER);
    }

    static void registerASLServices(AbstractTarget abstractTarget) {
        abstractTarget.registerServices(ASL_SERVICES, false);
    }

    static {
        if (ServiceManager.configManagerDiag != null) {
            PreRegisteredIds.addServiceOrObserverToArray(0, 1397429248, 979121408, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, 1397429248, 962344192, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, 1397429248, 995898624, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, 1397429248, 945566976, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, 1397429248, 1012675840, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, 1397429248, 1029453056, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, 1397429248, 1046230272, true);
        }
        ASL_OBSERVER = new int[]{1594556480, 1510670400, 1527447616, 1053364288, 1544224832, 1644888128, 1661665344, 1628110912, 1611333696, 2013986880, 2030764096, 2047541312, 2064318528, 2097872960, 2081095744, -1911881664, 1795883072, 1812660288, 1997209664, 2131427392, 1493893184, 895235328, -459521792, 446513408, 345850112};
        ASL_SERVICES = new int[]{861680896, 878458112, 895235328, 912012544, 979121408, 962344192, 1012675840, 1029453056, 1046230272};
    }
}

