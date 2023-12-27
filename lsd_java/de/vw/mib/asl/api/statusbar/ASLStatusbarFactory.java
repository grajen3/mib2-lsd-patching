/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.statusbar;

import de.vw.mib.asl.api.statusbar.ASLStatusbarAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLStatusbarFactory
extends ASLFactoryBase {
    private static ASLStatusbarAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$statusbar$ASLStatusbarFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLStatusbarAPI getStatusbarApi() {
        Class clazz = class$de$vw$mib$asl$api$statusbar$ASLStatusbarFactory == null ? (class$de$vw$mib$asl$api$statusbar$ASLStatusbarFactory = ASLStatusbarFactory.class$("de.vw.mib.asl.api.statusbar.ASLStatusbarFactory")) : class$de$vw$mib$asl$api$statusbar$ASLStatusbarFactory;
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

