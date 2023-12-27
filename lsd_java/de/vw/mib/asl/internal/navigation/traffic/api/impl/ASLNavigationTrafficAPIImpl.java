/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic.api.impl;

import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.startup.NaviResettableAslHsmTargetDelegator;
import de.vw.mib.asl.api.navigation.traffic.ASLNavigationTrafficAPI;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;
import de.vw.mib.genericevents.GenericEvents;

public class ASLNavigationTrafficAPIImpl
implements ASLNavigationTrafficAPI,
ASLNavigationContainer {
    public ASLNavigationTrafficAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().setAPIDebugFlag(-1812983808, true);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslHsmTargetDelegator(new TrafficTargetHSM(genericEvents, 1883968512, string), string));
    }
}

