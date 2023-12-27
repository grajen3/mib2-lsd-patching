/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationTruffelFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_TRUFFEL_API_IMPL_NAR_CLASS_NAME;
    private static ASLNavigationTruffelAPI navTruffelApi;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI;

    public static ASLNavigationTruffelAPI getNavigationTruffelApi() {
        if (navTruffelApi == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationTruffelFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI == null ? (class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI = ASLNavigationTruffelFactory.class$("de.vw.mib.asl.api.navigation.ASLNavigationTruffelAPI")) : class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI, "de.vw.mib.asl.internal.navigation.api.impl.nar.ASLNavigationTruffelAPIImpl");
                navTruffelApi = (ASLNavigationTruffelAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI == null ? (class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI = ASLNavigationTruffelFactory.class$("de.vw.mib.asl.api.navigation.ASLNavigationTruffelAPI")) : class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI, object);
            } else {
                navTruffelApi = (ASLNavigationTruffelAPI)ASLNavigationTruffelFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI == null ? (class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI = ASLNavigationTruffelFactory.class$("de.vw.mib.asl.api.navigation.ASLNavigationTruffelAPI")) : class$de$vw$mib$asl$api$navigation$ASLNavigationTruffelAPI, "de.vw.mib.asl.internal.navigation.api.impl.nar.ASLNavigationTruffelAPIImpl");
            }
        }
        return navTruffelApi;
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
        navTruffelApi = null;
    }
}

