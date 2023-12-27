/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.lsc;

import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.framework.api.lsc.ASLLscAPI;

public class ASLLscFactory
extends ASLFactoryBase {
    private static ASLLscAPI lscApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$lsc$ASLLscAPI;

    public static ASLLscAPI getLscApi() {
        if (lscApiInstance == null) {
            lscApiInstance = (ASLLscAPI)ASLLscFactory.createServiceInstance(class$de$vw$mib$asl$framework$api$lsc$ASLLscAPI == null ? (class$de$vw$mib$asl$framework$api$lsc$ASLLscAPI = ASLLscFactory.class$("de.vw.mib.asl.framework.api.lsc.ASLLscAPI")) : class$de$vw$mib$asl$framework$api$lsc$ASLLscAPI, "de.vw.mib.asl.framework.internal.lsc.api.impl.ASLLscAPIImpl");
        }
        return lscApiInstance;
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

