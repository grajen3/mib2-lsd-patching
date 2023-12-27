/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.connectivity;

import de.vw.mib.asl.api.connectivity.ASLConnectivityAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLConnectivityFactory
extends ASLFactoryBase {
    private static ASLConnectivityAPI connectivityApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$connectivity$ASLConnectivityAPI;

    public static ASLConnectivityAPI getConnectivityApi() {
        if (connectivityApiInstance == null) {
            connectivityApiInstance = (ASLConnectivityAPI)ASLConnectivityFactory.createServiceInstance(class$de$vw$mib$asl$api$connectivity$ASLConnectivityAPI == null ? (class$de$vw$mib$asl$api$connectivity$ASLConnectivityAPI = ASLConnectivityFactory.class$("de.vw.mib.asl.api.connectivity.ASLConnectivityAPI")) : class$de$vw$mib$asl$api$connectivity$ASLConnectivityAPI, "de.vw.mib.asl.internal.connectivity.api.impl.ASLConnectivityAPIImpl");
        }
        return connectivityApiInstance;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

