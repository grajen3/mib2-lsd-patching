/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.ASLNavigationSldeAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationSldeFactory
extends ASLFactoryBase {
    private static ASLNavigationSldeAPI navSldeApi = null;
    private static final String ASL_NAVIGATION_SLDE_API_CLASS_NAME;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI;

    public static ASLNavigationSldeAPI getNavigationSldeApi() {
        if (navSldeApi == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationSldeFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI == null ? (class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI = ASLNavigationSldeFactory.class$("de.vw.mib.asl.api.navigation.ASLNavigationSldeAPI")) : class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI, "de.vw.mib.asl.internal.navigation.api.impl.nar.ASLNavigationSldeAPIImpl");
                navSldeApi = (ASLNavigationSldeAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI == null ? (class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI = ASLNavigationSldeFactory.class$("de.vw.mib.asl.api.navigation.ASLNavigationSldeAPI")) : class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI, object);
            } else {
                navSldeApi = (ASLNavigationSldeAPI)ASLNavigationSldeFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI == null ? (class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI = ASLNavigationSldeFactory.class$("de.vw.mib.asl.api.navigation.ASLNavigationSldeAPI")) : class$de$vw$mib$asl$api$navigation$ASLNavigationSldeAPI, "de.vw.mib.asl.internal.navigation.api.impl.nar.ASLNavigationSldeAPIImpl");
            }
        }
        return navSldeApi;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

