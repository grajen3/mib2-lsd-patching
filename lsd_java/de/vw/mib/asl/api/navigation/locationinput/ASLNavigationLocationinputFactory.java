/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.locationinput;

import de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;

public class ASLNavigationLocationinputFactory
extends ASLFactoryBase {
    private static final String NAVIGATION_LOCATIONINPUT_API_CLASS_NAME;
    private static ASLNavigationLocationinputAPI navigationLocationinputApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI;

    public static ASLNavigationLocationinputAPI getNavigationLocationinputApi() {
        if (navigationLocationinputApiInstance == null) {
            if (LoggingProxy.useLoggingProxy()) {
                Object object = ASLNavigationLocationinputFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI == null ? (class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI = ASLNavigationLocationinputFactory.class$("de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputAPI")) : class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI, "de.vw.mib.asl.internal.navigation.locationinput.api.impl.ASLNavigationLocationinputAPIImpl");
                navigationLocationinputApiInstance = (ASLNavigationLocationinputAPI)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI == null ? (class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI = ASLNavigationLocationinputFactory.class$("de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputAPI")) : class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI, object);
            } else {
                navigationLocationinputApiInstance = (ASLNavigationLocationinputAPI)ASLNavigationLocationinputFactory.createServiceInstance(class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI == null ? (class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI = ASLNavigationLocationinputFactory.class$("de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputAPI")) : class$de$vw$mib$asl$api$navigation$locationinput$ASLNavigationLocationinputAPI, "de.vw.mib.asl.internal.navigation.locationinput.api.impl.ASLNavigationLocationinputAPIImpl");
            }
        }
        return navigationLocationinputApiInstance;
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
        navigationLocationinputApiInstance = null;
    }
}

