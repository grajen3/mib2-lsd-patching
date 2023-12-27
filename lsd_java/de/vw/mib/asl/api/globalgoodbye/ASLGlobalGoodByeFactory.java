/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.globalgoodbye;

import de.vw.mib.asl.api.globalgoodbye.ASLGlobalGoodByeAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLGlobalGoodByeFactory
extends ASLFactoryBase {
    private static ASLGlobalGoodByeAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$globalgoodbye$ASLGlobalGoodByeFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$globalgoodbye$ASLGlobalGoodByeAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLGlobalGoodByeAPI getGlobalGoodByeApi() {
        Class clazz = class$de$vw$mib$asl$api$globalgoodbye$ASLGlobalGoodByeFactory == null ? (class$de$vw$mib$asl$api$globalgoodbye$ASLGlobalGoodByeFactory = ASLGlobalGoodByeFactory.class$("de.vw.mib.asl.api.globalgoodbye.ASLGlobalGoodByeFactory")) : class$de$vw$mib$asl$api$globalgoodbye$ASLGlobalGoodByeFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLGlobalGoodByeAPI)ASLGlobalGoodByeFactory.createServiceInstance(class$de$vw$mib$asl$api$globalgoodbye$ASLGlobalGoodByeAPI == null ? (class$de$vw$mib$asl$api$globalgoodbye$ASLGlobalGoodByeAPI = ASLGlobalGoodByeFactory.class$("de.vw.mib.asl.api.globalgoodbye.ASLGlobalGoodByeAPI")) : class$de$vw$mib$asl$api$globalgoodbye$ASLGlobalGoodByeAPI, "de.vw.mib.asl.internal.globalgoodbye.api.impl.ASLGlobalGoodByeAPIImpl");
            }
            return apiInstance;
        }
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

