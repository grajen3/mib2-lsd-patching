/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.ASLNavigationAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationFactory
extends ASLFactoryBase {
    private static ASLNavigationAPI navigationApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$ASLNavigationAPI;

    public static ASLNavigationAPI getNavigationApi() {
        if (navigationApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$ASLNavigationAPI == null ? (class$de$vw$mib$asl$api$navigation$ASLNavigationAPI = ASLNavigationFactory.class$("de.vw.mib.asl.api.navigation.ASLNavigationAPI")) : class$de$vw$mib$asl$api$navigation$ASLNavigationAPI, "de.vw.mib.asl.internal.navigation.api.impl.ASLNavigationAPIImpl");
                navigationApiInstance = (ASLNavigationAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$ASLNavigationAPI == null ? (class$de$vw$mib$asl$api$navigation$ASLNavigationAPI = ASLNavigationFactory.class$("de.vw.mib.asl.api.navigation.ASLNavigationAPI")) : class$de$vw$mib$asl$api$navigation$ASLNavigationAPI, object);
            } else {
                navigationApiInstance = (ASLNavigationAPI)ASLNavigationFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$ASLNavigationAPI == null ? (class$de$vw$mib$asl$api$navigation$ASLNavigationAPI = ASLNavigationFactory.class$("de.vw.mib.asl.api.navigation.ASLNavigationAPI")) : class$de$vw$mib$asl$api$navigation$ASLNavigationAPI, "de.vw.mib.asl.internal.navigation.api.impl.ASLNavigationAPIImpl");
            }
        }
        return navigationApiInstance;
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

