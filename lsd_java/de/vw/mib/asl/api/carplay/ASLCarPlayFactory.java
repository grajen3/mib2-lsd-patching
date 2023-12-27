/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.carplay;

import de.vw.mib.asl.api.carplay.ASLCarPlayAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLCarPlayFactory
extends ASLFactoryBase {
    private static ASLCarPlayAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$carplay$ASLCarPlayAPI;

    public static ASLCarPlayAPI getCarPlayApi() {
        if (apiInstance == null) {
            apiInstance = (ASLCarPlayAPI)ASLCarPlayFactory.createServiceInstance(class$de$vw$mib$asl$api$carplay$ASLCarPlayAPI == null ? (class$de$vw$mib$asl$api$carplay$ASLCarPlayAPI = ASLCarPlayFactory.class$("de.vw.mib.asl.api.carplay.ASLCarPlayAPI")) : class$de$vw$mib$asl$api$carplay$ASLCarPlayAPI, "de.vw.mib.asl.internal.carplay.api.impl.ASLCarPlayAPIImpl");
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

