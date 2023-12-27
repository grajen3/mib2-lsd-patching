/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationGuidanceFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_GUIDANCE_API_CLASS_NAME;
    private static ASLNavigationGuidanceAPI navigationGuidanceApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI;

    public static ASLNavigationGuidanceAPI getNavigationGuidanceApi() {
        if (navigationGuidanceApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationGuidanceFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI == null ? (class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI = ASLNavigationGuidanceFactory.class$("de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceAPI")) : class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI, "de.vw.mib.asl.internal.navigation.guidance.api.impl.ASLNavigationGuidanceAPIImpl");
                navigationGuidanceApiInstance = (ASLNavigationGuidanceAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI == null ? (class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI = ASLNavigationGuidanceFactory.class$("de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceAPI")) : class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI, object);
            } else {
                navigationGuidanceApiInstance = (ASLNavigationGuidanceAPI)ASLNavigationGuidanceFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI == null ? (class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI = ASLNavigationGuidanceFactory.class$("de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceAPI")) : class$de$vw$mib$asl$api$navigation$guidance$ASLNavigationGuidanceAPI, "de.vw.mib.asl.internal.navigation.guidance.api.impl.ASLNavigationGuidanceAPIImpl");
            }
        }
        return navigationGuidanceApiInstance;
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
        navigationGuidanceApiInstance = null;
    }
}

