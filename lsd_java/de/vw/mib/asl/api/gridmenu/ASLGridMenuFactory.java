/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.gridmenu;

import de.vw.mib.asl.api.gridmenu.ASLGridMenuAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLGridMenuFactory
extends ASLFactoryBase {
    private static ASLGridMenuAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$gridmenu$ASLGridMenuFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLGridMenuAPI getGridMenuApi() {
        Class clazz = class$de$vw$mib$asl$api$gridmenu$ASLGridMenuFactory == null ? (class$de$vw$mib$asl$api$gridmenu$ASLGridMenuFactory = ASLGridMenuFactory.class$("de.vw.mib.asl.api.gridmenu.ASLGridMenuFactory")) : class$de$vw$mib$asl$api$gridmenu$ASLGridMenuFactory;
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

