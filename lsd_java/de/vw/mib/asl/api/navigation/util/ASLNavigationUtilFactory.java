/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import de.vw.mib.asl.api.navigation.data.ASLNavigationDataMap;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationUtilFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_UTIL_API_CLASS_NAME;
    private static ASLNavigationUtilAPI navigationUtilApiInstance;
    private static final String NAVIGATION_DATA_MAP_CLASS_NAME;
    private static ASLNavigationDataMap navDataMapRoot;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$data$ASLNavigationDataMap;

    public static ASLNavigationUtilAPI getNavigationUtilApi() {
        if (navigationUtilApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationUtilFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI == null ? (class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI = ASLNavigationUtilFactory.class$("de.vw.mib.asl.api.navigation.util.ASLNavigationUtilAPI")) : class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI, "de.vw.mib.asl.internal.navigation.util.api.impl.ASLNavigationUtilAPIImpl");
                navigationUtilApiInstance = (ASLNavigationUtilAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI == null ? (class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI = ASLNavigationUtilFactory.class$("de.vw.mib.asl.api.navigation.util.ASLNavigationUtilAPI")) : class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI, object);
            } else {
                navigationUtilApiInstance = (ASLNavigationUtilAPI)ASLNavigationUtilFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI == null ? (class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI = ASLNavigationUtilFactory.class$("de.vw.mib.asl.api.navigation.util.ASLNavigationUtilAPI")) : class$de$vw$mib$asl$api$navigation$util$ASLNavigationUtilAPI, "de.vw.mib.asl.internal.navigation.util.api.impl.ASLNavigationUtilAPIImpl");
            }
        }
        return navigationUtilApiInstance;
    }

    public static ASLNavigationDataMap getNavigationDataRoot() {
        if (navDataMapRoot == null) {
            navDataMapRoot = (ASLNavigationDataMap)ASLNavigationUtilFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$data$ASLNavigationDataMap == null ? (class$de$vw$mib$asl$api$navigation$data$ASLNavigationDataMap = ASLNavigationUtilFactory.class$("de.vw.mib.asl.api.navigation.data.ASLNavigationDataMap")) : class$de$vw$mib$asl$api$navigation$data$ASLNavigationDataMap, "de.vw.mib.asl.internal.navigation.api.impl.data.ASLNavigationDataMapImpl");
        }
        return navDataMapRoot;
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
        navigationUtilApiInstance = null;
        navDataMapRoot = null;
    }
}

