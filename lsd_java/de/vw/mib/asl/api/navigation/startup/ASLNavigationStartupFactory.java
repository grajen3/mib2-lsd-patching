/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.startup;

import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationStartupFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_STARTUP_API_CLASS_NAME;
    private static ASLNavigationStartupAPI navigationStartupApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI;

    public static ASLNavigationStartupAPI getNavigationStartupApi() {
        if (navigationStartupApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationStartupFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI == null ? (class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI = ASLNavigationStartupFactory.class$("de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupAPI")) : class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI, "de.vw.mib.asl.internal.navigation.startup.api.impl.ASLNavigationStartupAPIImpl");
                navigationStartupApiInstance = (ASLNavigationStartupAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI == null ? (class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI = ASLNavigationStartupFactory.class$("de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupAPI")) : class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI, object);
            } else {
                navigationStartupApiInstance = (ASLNavigationStartupAPI)ASLNavigationStartupFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI == null ? (class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI = ASLNavigationStartupFactory.class$("de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupAPI")) : class$de$vw$mib$asl$api$navigation$startup$ASLNavigationStartupAPI, "de.vw.mib.asl.internal.navigation.startup.api.impl.ASLNavigationStartupAPIImpl");
            }
        }
        return navigationStartupApiInstance;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        navigationStartupApiInstance = null;
    }
}

