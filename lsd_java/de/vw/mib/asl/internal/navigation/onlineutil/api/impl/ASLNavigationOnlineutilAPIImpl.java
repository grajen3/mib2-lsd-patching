/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.onlineutil.api.impl;

import de.vw.mib.asl.api.navigation.onlineutil.ASLNavigationOnlineutilAPI;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.onlineservice.MobileConnectionHandler;
import de.vw.mib.asl.internal.navigation.onlineservice.internetbrowser.InternetBrowserHandler;
import de.vw.mib.asl.internal.navigation.onlineservice.registration.OCSRegistrationTarget;
import de.vw.mib.genericevents.GenericEvents;

public class ASLNavigationOnlineutilAPIImpl
implements ASLNavigationOnlineutilAPI,
ASLNavigationContainer {
    public ASLNavigationOnlineutilAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(0, new OCSRegistrationTarget(genericEvents, -1001712640, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new InternetBrowserHandler(genericEvents, -1102375936, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new MobileConnectionHandler(genericEvents, -1035267072, string));
    }
}

