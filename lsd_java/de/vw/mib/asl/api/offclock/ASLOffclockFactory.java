/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.offclock;

import de.vw.mib.asl.api.offclock.ASLOffclockAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLOffclockFactory
extends ASLFactoryBase {
    private static ASLOffclockAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$offclock$ASLOffclockFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLOffclockAPI getOffclockApi() {
        Class clazz = class$de$vw$mib$asl$api$offclock$ASLOffclockFactory == null ? (class$de$vw$mib$asl$api$offclock$ASLOffclockFactory = ASLOffclockFactory.class$("de.vw.mib.asl.api.offclock.ASLOffclockFactory")) : class$de$vw$mib$asl$api$offclock$ASLOffclockFactory;
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

