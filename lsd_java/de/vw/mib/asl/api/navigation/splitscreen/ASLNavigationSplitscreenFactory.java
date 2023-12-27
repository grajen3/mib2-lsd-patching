/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.splitscreen.ASLNavigationSplitscreenAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationSplitscreenFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_SPLITSCREEN_API_CLASS_NAME;
    private static ASLNavigationSplitscreenAPI navigationSplitscreenApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI;

    public static ASLNavigationSplitscreenAPI getNavigationSplitscreenApi() {
        if (navigationSplitscreenApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationSplitscreenFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI == null ? (class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI = ASLNavigationSplitscreenFactory.class$("de.vw.mib.asl.api.navigation.splitscreen.ASLNavigationSplitscreenAPI")) : class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI, "de.vw.mib.asl.internal.navigation.splitscreen.api.impl.ASLNavigationSplitscreenAPIImpl");
                navigationSplitscreenApiInstance = (ASLNavigationSplitscreenAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI == null ? (class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI = ASLNavigationSplitscreenFactory.class$("de.vw.mib.asl.api.navigation.splitscreen.ASLNavigationSplitscreenAPI")) : class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI, object);
            } else {
                navigationSplitscreenApiInstance = (ASLNavigationSplitscreenAPI)ASLNavigationSplitscreenFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI == null ? (class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI = ASLNavigationSplitscreenFactory.class$("de.vw.mib.asl.api.navigation.splitscreen.ASLNavigationSplitscreenAPI")) : class$de$vw$mib$asl$api$navigation$splitscreen$ASLNavigationSplitscreenAPI, "de.vw.mib.asl.internal.navigation.splitscreen.api.impl.ASLNavigationSplitscreenAPIImpl");
            }
        }
        return navigationSplitscreenApiInstance;
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
        navigationSplitscreenApiInstance = null;
    }
}

