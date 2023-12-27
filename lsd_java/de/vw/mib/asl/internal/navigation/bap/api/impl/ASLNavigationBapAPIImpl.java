/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.api.impl;

import de.vw.mib.asl.api.navigation.bap.ASLNavigationBapAPI;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.startup.NaviResettableAslTargetDelegator;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.bap.HsmTargetBap;
import de.vw.mib.asl.internal.navigation.setup.HsmTargetSetup;
import de.vw.mib.asl.internal.navigation.setup.TargetHandleLsc;
import de.vw.mib.genericevents.GenericEvents;

public class ASLNavigationBapAPIImpl
implements ASLNavigationBapAPI,
ASLNavigationContainer {
    public ASLNavigationBapAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(0, new TargetHandleLsc(genericEvents, 2034963456, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new HsmTargetBap(genericEvents, 1732973568, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(1, new HsmTargetSetup(genericEvents, 1934300160, string));
    }
}

