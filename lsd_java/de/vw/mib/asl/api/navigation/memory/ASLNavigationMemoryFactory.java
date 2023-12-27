/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import de.vw.mib.asl.api.navigation.memory.ASLNavigationMemoryAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationMemoryFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_MEMORY_API_CLASS_NAME;
    private static ASLNavigationMemoryAPI navigationMemoryApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI;

    public static ASLNavigationMemoryAPI getNavigationMemoryApi() {
        if (navigationMemoryApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationMemoryFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI == null ? (class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI = ASLNavigationMemoryFactory.class$("de.vw.mib.asl.api.navigation.memory.ASLNavigationMemoryAPI")) : class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI, "de.vw.mib.asl.internal.navigation.memory.api.impl.ASLNavigationMemoryAPIImpl");
                navigationMemoryApiInstance = (ASLNavigationMemoryAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI == null ? (class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI = ASLNavigationMemoryFactory.class$("de.vw.mib.asl.api.navigation.memory.ASLNavigationMemoryAPI")) : class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI, object);
            } else {
                navigationMemoryApiInstance = (ASLNavigationMemoryAPI)ASLNavigationMemoryFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI == null ? (class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI = ASLNavigationMemoryFactory.class$("de.vw.mib.asl.api.navigation.memory.ASLNavigationMemoryAPI")) : class$de$vw$mib$asl$api$navigation$memory$ASLNavigationMemoryAPI, "de.vw.mib.asl.internal.navigation.memory.api.impl.ASLNavigationMemoryAPIImpl");
            }
        }
        return navigationMemoryApiInstance;
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
        navigationMemoryApiInstance = null;
    }
}

