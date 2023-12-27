/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.selectiontilel;

import de.vw.mib.asl.api.selectiontilel.ASLSelectionTileLAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLSelectionTileLFactory
extends ASLFactoryBase {
    private static ASLSelectionTileLAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$selectiontilel$ASLSelectionTileLFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLSelectionTileLAPI getSelectionTileLApi() {
        Class clazz = class$de$vw$mib$asl$api$selectiontilel$ASLSelectionTileLFactory == null ? (class$de$vw$mib$asl$api$selectiontilel$ASLSelectionTileLFactory = ASLSelectionTileLFactory.class$("de.vw.mib.asl.api.selectiontilel.ASLSelectionTileLFactory")) : class$de$vw$mib$asl$api$selectiontilel$ASLSelectionTileLFactory;
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

