/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.poi;

import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationPoiFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_POI_API_CLASS_NAME;
    private static ASLNavigationPoiAPI navigationPoiApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI;

    public static ASLNavigationPoiAPI getNavigationPoiApi() {
        if (navigationPoiApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationPoiFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI == null ? (class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI = ASLNavigationPoiFactory.class$("de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiAPI")) : class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI, "de.vw.mib.asl.internal.navigation.poi.api.impl.ASLNavigationPoiAPIImpl");
                navigationPoiApiInstance = (ASLNavigationPoiAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI == null ? (class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI = ASLNavigationPoiFactory.class$("de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiAPI")) : class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI, object);
            } else {
                navigationPoiApiInstance = (ASLNavigationPoiAPI)ASLNavigationPoiFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI == null ? (class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI = ASLNavigationPoiFactory.class$("de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiAPI")) : class$de$vw$mib$asl$api$navigation$poi$ASLNavigationPoiAPI, "de.vw.mib.asl.internal.navigation.poi.api.impl.ASLNavigationPoiAPIImpl");
            }
        }
        return navigationPoiApiInstance;
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
        navigationPoiApiInstance = null;
    }
}

