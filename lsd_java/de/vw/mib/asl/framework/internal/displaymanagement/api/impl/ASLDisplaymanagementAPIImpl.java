/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.api.impl;

import de.vw.mib.asl.framework.api.displaymanagement.ASLDisplaymanagementAPI;
import de.vw.mib.asl.framework.api.displaymanagement.WritableHelper;
import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableService;
import de.vw.mib.asl.framework.internal.displaymanagement.ASLDisplayManagementTarget;
import de.vw.mib.asl.framework.internal.displaymanagement.WritableHelperHighEso;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.DisplayManagementServicesProvider;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;

public class ASLDisplaymanagementAPIImpl
implements ASLDisplaymanagementAPI {
    public static ASLDisplayManagementTarget displayManagementTarget;

    @Override
    public boolean isInitialSwitchContextPending() {
        return displayManagementTarget == null || displayManagementTarget.isInitialSwitchContextPending();
    }

    @Override
    public WritableHelper createWritableHelperInstance() {
        return new WritableHelperHighEso();
    }

    public static void registerIds(GenericEvents genericEvents) {
        ServiceRegister serviceRegister = genericEvents.getServiceRegister();
        serviceRegister.registerService(668340992, 0, 0x171100, 0, false, true);
        serviceRegister.registerService(685118208, 0, 0x171100, 0, false, true);
        serviceRegister.registerService(701895424, 0, 0x171100, 0, false, true);
        serviceRegister.registerService(718672640, 0, 0x171100, 0, false, true);
    }

    @Override
    public DisplayableService getDisplayableService() {
        return DisplayManagementServicesProvider.getServices().getDisplayableService();
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 0x171100, 651563776);
        PreRegisteredIds.addServiceOrObserverToArray(0, 0x171100, 618009344);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, -241417984);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 513622272);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 1006960704);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 2063597632);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 2080374848);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, -2147483584);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, -2130706368);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 1845493824);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 1862271040);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 0x70000040);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 1895825472);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 1761607744);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 1778384960);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 1795162176);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 1811939392);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 618009344);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 668340992);
        PreRegisteredIds.addServiceOrObserverToArray(2, 0x171100, 685118208);
    }
}

