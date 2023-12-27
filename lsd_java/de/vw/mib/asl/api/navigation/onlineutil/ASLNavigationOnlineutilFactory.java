/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.onlineutil;

import de.vw.mib.asl.api.navigation.onlineutil.ASLNavigationOnlineutilAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationOnlineutilFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_ONLINEUTIL_API_CLASS_NAME;
    private static ASLNavigationOnlineutilAPI navigationOnlineutilApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI;

    public static ASLNavigationOnlineutilAPI getNavigationOnlineutilApi() {
        if (navigationOnlineutilApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationOnlineutilFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI == null ? (class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI = ASLNavigationOnlineutilFactory.class$("de.vw.mib.asl.api.navigation.onlineutil.ASLNavigationOnlineutilAPI")) : class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI, "de.vw.mib.asl.internal.navigation.onlineutil.api.impl.ASLNavigationOnlineutilAPIImpl");
                navigationOnlineutilApiInstance = (ASLNavigationOnlineutilAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI == null ? (class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI = ASLNavigationOnlineutilFactory.class$("de.vw.mib.asl.api.navigation.onlineutil.ASLNavigationOnlineutilAPI")) : class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI, object);
            } else {
                navigationOnlineutilApiInstance = (ASLNavigationOnlineutilAPI)ASLNavigationOnlineutilFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI == null ? (class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI = ASLNavigationOnlineutilFactory.class$("de.vw.mib.asl.api.navigation.onlineutil.ASLNavigationOnlineutilAPI")) : class$de$vw$mib$asl$api$navigation$onlineutil$ASLNavigationOnlineutilAPI, "de.vw.mib.asl.internal.navigation.onlineutil.api.impl.ASLNavigationOnlineutilAPIImpl");
            }
        }
        return navigationOnlineutilApiInstance;
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
        navigationOnlineutilApiInstance = null;
    }
}

