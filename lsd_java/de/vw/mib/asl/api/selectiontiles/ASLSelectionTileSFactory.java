/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.selectiontiles;

import de.vw.mib.asl.api.selectiontiles.ASLSelectionTileSAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLSelectionTileSFactory
extends ASLFactoryBase {
    private static ASLSelectionTileSAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$selectiontiles$ASLSelectionTileSFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLSelectionTileSAPI getSelectionTileSApi() {
        Class clazz = class$de$vw$mib$asl$api$selectiontiles$ASLSelectionTileSFactory == null ? (class$de$vw$mib$asl$api$selectiontiles$ASLSelectionTileSFactory = ASLSelectionTileSFactory.class$("de.vw.mib.asl.api.selectiontiles.ASLSelectionTileSFactory")) : class$de$vw$mib$asl$api$selectiontiles$ASLSelectionTileSFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                // empty if block
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

