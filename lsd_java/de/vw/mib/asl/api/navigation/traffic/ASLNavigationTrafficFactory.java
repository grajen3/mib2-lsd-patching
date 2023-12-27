/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.traffic;

import de.vw.mib.asl.api.navigation.traffic.ASLNavigationTrafficAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationTrafficFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_TRAFFIC_API_CLASS_NAME;
    private static ASLNavigationTrafficAPI navigationTrafficApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI;

    public static ASLNavigationTrafficAPI getNavigationTrafficApi() {
        if (navigationTrafficApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationTrafficFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI == null ? (class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI = ASLNavigationTrafficFactory.class$("de.vw.mib.asl.api.navigation.traffic.ASLNavigationTrafficAPI")) : class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI, "de.vw.mib.asl.internal.navigation.traffic.api.impl.ASLNavigationTrafficAPIImpl");
                navigationTrafficApiInstance = (ASLNavigationTrafficAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI == null ? (class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI = ASLNavigationTrafficFactory.class$("de.vw.mib.asl.api.navigation.traffic.ASLNavigationTrafficAPI")) : class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI, object);
            } else {
                navigationTrafficApiInstance = (ASLNavigationTrafficAPI)ASLNavigationTrafficFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI == null ? (class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI = ASLNavigationTrafficFactory.class$("de.vw.mib.asl.api.navigation.traffic.ASLNavigationTrafficAPI")) : class$de$vw$mib$asl$api$navigation$traffic$ASLNavigationTrafficAPI, "de.vw.mib.asl.internal.navigation.traffic.api.impl.ASLNavigationTrafficAPIImpl");
            }
        }
        return navigationTrafficApiInstance;
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
        navigationTrafficApiInstance = null;
    }
}

