/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.nar;

import de.vw.mib.asl.api.navigation.ASLNavigationSldeAPI;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.slde.SldeProxyTarget;
import de.vw.mib.asl.internal.navigation.slde.SldeSpellerHandler;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.NavLocation;

public class ASLNavigationSldeAPIImpl
implements ASLNavigationSldeAPI,
ASLNavigationContainer {
    public ASLNavigationSldeAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void createTargets() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().setAPIDebugFlag(1626345472, true);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new SldeProxyTarget(ServiceManager.eventMain, -884272128, "hsmtask"));
    }

    @Override
    public SpellerData getSldeSpellerData() {
        return SldeSpellerHandler.getInstance().getSpellerData();
    }

    @Override
    public void sldeSpellerHandlerInitXt9(NavLocation navLocation) {
        SldeSpellerHandler.getInstance().initXt9(navLocation);
    }
}

