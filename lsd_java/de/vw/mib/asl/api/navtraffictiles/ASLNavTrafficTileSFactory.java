/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navtraffictiles;

import de.vw.mib.asl.api.navtraffictiles.ASLNavTrafficTileSAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLNavTrafficTileSFactory
extends ASLFactoryBase {
    private static ASLNavTrafficTileSAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navtraffictiles$ASLNavTrafficTileSFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navtraffictiles$ASLNavTrafficTileSAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLNavTrafficTileSAPI getNavTrafficTileSApi() {
        Class clazz = class$de$vw$mib$asl$api$navtraffictiles$ASLNavTrafficTileSFactory == null ? (class$de$vw$mib$asl$api$navtraffictiles$ASLNavTrafficTileSFactory = ASLNavTrafficTileSFactory.class$("de.vw.mib.asl.api.navtraffictiles.ASLNavTrafficTileSFactory")) : class$de$vw$mib$asl$api$navtraffictiles$ASLNavTrafficTileSFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLNavTrafficTileSAPI)ASLNavTrafficTileSFactory.createServiceInstance(class$de$vw$mib$asl$api$navtraffictiles$ASLNavTrafficTileSAPI == null ? (class$de$vw$mib$asl$api$navtraffictiles$ASLNavTrafficTileSAPI = ASLNavTrafficTileSFactory.class$("de.vw.mib.asl.api.navtraffictiles.ASLNavTrafficTileSAPI")) : class$de$vw$mib$asl$api$navtraffictiles$ASLNavTrafficTileSAPI, "de.vw.mib.asl.internal.navtraffictiles.api.impl.ASLNavTrafficTileSAPIImpl");
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

