/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navmaptile;

import de.vw.mib.asl.api.navmaptile.ASLNavMapTileAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLNavMapTileFactory
extends ASLFactoryBase {
    private static ASLNavMapTileAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navmaptile$ASLNavMapTileFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navmaptile$ASLNavMapTileAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLNavMapTileAPI getNavMapTileApi() {
        Class clazz = class$de$vw$mib$asl$api$navmaptile$ASLNavMapTileFactory == null ? (class$de$vw$mib$asl$api$navmaptile$ASLNavMapTileFactory = ASLNavMapTileFactory.class$("de.vw.mib.asl.api.navmaptile.ASLNavMapTileFactory")) : class$de$vw$mib$asl$api$navmaptile$ASLNavMapTileFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLNavMapTileAPI)ASLNavMapTileFactory.createServiceInstance(class$de$vw$mib$asl$api$navmaptile$ASLNavMapTileAPI == null ? (class$de$vw$mib$asl$api$navmaptile$ASLNavMapTileAPI = ASLNavMapTileFactory.class$("de.vw.mib.asl.api.navmaptile.ASLNavMapTileAPI")) : class$de$vw$mib$asl$api$navmaptile$ASLNavMapTileAPI, "de.vw.mib.asl.internal.navmaptile.api.impl.ASLNavMapTileAPIImpl");
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

