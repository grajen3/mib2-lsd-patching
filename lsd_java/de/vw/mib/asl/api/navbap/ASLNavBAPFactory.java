/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navbap;

import de.vw.mib.asl.api.navbap.ASLNavBAPAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLNavBAPFactory
extends ASLFactoryBase {
    private static ASLNavBAPAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navbap$ASLNavBAPAPI;

    public static ASLNavBAPAPI getNavBAPApi() {
        if (apiInstance == null) {
            apiInstance = (ASLNavBAPAPI)ASLNavBAPFactory.createServiceInstance(class$de$vw$mib$asl$api$navbap$ASLNavBAPAPI == null ? (class$de$vw$mib$asl$api$navbap$ASLNavBAPAPI = ASLNavBAPFactory.class$("de.vw.mib.asl.api.navbap.ASLNavBAPAPI")) : class$de$vw$mib$asl$api$navbap$ASLNavBAPAPI, "de.vw.mib.asl.internal.navbap.api.impl.ASLNavBAPAPIImpl");
        }
        return apiInstance;
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

