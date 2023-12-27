/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.swap;

import de.vw.mib.asl.api.swap.ASLSwapAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLSwapFactory
extends ASLFactoryBase {
    private static ASLSwapAPI swapApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$swap$ASLSwapAPI;

    public static ASLSwapAPI getSwapApi() {
        if (swapApiInstance == null) {
            swapApiInstance = (ASLSwapAPI)ASLSwapFactory.createServiceInstance(class$de$vw$mib$asl$api$swap$ASLSwapAPI == null ? (class$de$vw$mib$asl$api$swap$ASLSwapAPI = ASLSwapFactory.class$("de.vw.mib.asl.api.swap.ASLSwapAPI")) : class$de$vw$mib$asl$api$swap$ASLSwapAPI, "de.vw.mib.asl.internal.swap.api.impl.ASLSwapAPIImpl");
        }
        return swapApiInstance;
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

