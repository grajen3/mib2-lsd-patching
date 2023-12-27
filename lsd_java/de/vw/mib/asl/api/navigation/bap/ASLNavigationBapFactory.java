/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.bap;

import de.vw.mib.asl.api.navigation.bap.ASLNavigationBapAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationBapFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_BAP_API_CLASS_NAME;
    private static ASLNavigationBapAPI navigationBapApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI;

    public static ASLNavigationBapAPI getNavigationBapApi() {
        if (navigationBapApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationBapFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI == null ? (class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI = ASLNavigationBapFactory.class$("de.vw.mib.asl.api.navigation.bap.ASLNavigationBapAPI")) : class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI, "de.vw.mib.asl.internal.navigation.bap.api.impl.ASLNavigationBapAPIImpl");
                navigationBapApiInstance = (ASLNavigationBapAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI == null ? (class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI = ASLNavigationBapFactory.class$("de.vw.mib.asl.api.navigation.bap.ASLNavigationBapAPI")) : class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI, object);
            } else {
                navigationBapApiInstance = (ASLNavigationBapAPI)ASLNavigationBapFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI == null ? (class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI = ASLNavigationBapFactory.class$("de.vw.mib.asl.api.navigation.bap.ASLNavigationBapAPI")) : class$de$vw$mib$asl$api$navigation$bap$ASLNavigationBapAPI, "de.vw.mib.asl.internal.navigation.bap.api.impl.ASLNavigationBapAPIImpl");
            }
        }
        return navigationBapApiInstance;
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
        navigationBapApiInstance = null;
    }
}

