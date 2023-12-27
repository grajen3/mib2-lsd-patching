/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationMapFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_MAP_API_CLASS_NAME;
    private static ASLNavigationMapAPI navigationMapApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI;

    public static ASLNavigationMapAPI getNavigationMapApi() {
        if (navigationMapApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationMapFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI == null ? (class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI = ASLNavigationMapFactory.class$("de.vw.mib.asl.api.navigation.map.ASLNavigationMapAPI")) : class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI, "de.vw.mib.asl.internal.navigation.map.api.impl.ASLNavigationMapAPIImpl");
                navigationMapApiInstance = (ASLNavigationMapAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI == null ? (class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI = ASLNavigationMapFactory.class$("de.vw.mib.asl.api.navigation.map.ASLNavigationMapAPI")) : class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI, object);
            } else {
                navigationMapApiInstance = (ASLNavigationMapAPI)ASLNavigationMapFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI == null ? (class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI = ASLNavigationMapFactory.class$("de.vw.mib.asl.api.navigation.map.ASLNavigationMapAPI")) : class$de$vw$mib$asl$api$navigation$map$ASLNavigationMapAPI, "de.vw.mib.asl.internal.navigation.map.api.impl.ASLNavigationMapAPIImpl");
            }
        }
        return navigationMapApiInstance;
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
        navigationMapApiInstance = null;
    }
}

