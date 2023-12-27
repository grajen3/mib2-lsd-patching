/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions;

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
            PreRegisteredIds.addServiceOrObserverToArray(0, 1716196352, 1558262528, true);
        }
        OBSERVERS = new int[]{-1023279040, -1107230656, -989724608, -889061312, -939392960, -956170176, -905838528, -972947392, -922615744, -553516992, 705372160, 0x22020040, 1271468096, 1388908608, 856367104, 1556680768, 1573457984};
    }
}

