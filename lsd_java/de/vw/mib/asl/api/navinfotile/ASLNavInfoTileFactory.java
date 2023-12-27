/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navinfotile;

import de.vw.mib.asl.api.navinfotile.ASLNavInfoTileAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLNavInfoTileFactory
extends ASLFactoryBase {
    private static ASLNavInfoTileAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navinfotile$ASLNavInfoTileFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navinfotile$ASLNavInfoTileAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLNavInfoTileAPI getNavInfoTileApi() {
        Class clazz = class$de$vw$mib$asl$api$navinfotile$ASLNavInfoTileFactory == null ? (class$de$vw$mib$asl$api$navinfotile$ASLNavInfoTileFactory = ASLNavInfoTileFactory.class$("de.vw.mib.asl.api.navinfotile.ASLNavInfoTileFactory")) : class$de$vw$mib$asl$api$navinfotile$ASLNavInfoTileFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLNavInfoTileAPI)ASLNavInfoTileFactory.createServiceInstance(class$de$vw$mib$asl$api$navinfotile$ASLNavInfoTileAPI == null ? (class$de$vw$mib$asl$api$navinfotile$ASLNavInfoTileAPI = ASLNavInfoTileFactory.class$("de.vw.mib.asl.api.navinfotile.ASLNavInfoTileAPI")) : class$de$vw$mib$asl$api$navinfotile$ASLNavInfoTileAPI, "de.vw.mib.asl.internal.navinfotile.api.impl.ASLNavInfoTileAPIImpl");
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

