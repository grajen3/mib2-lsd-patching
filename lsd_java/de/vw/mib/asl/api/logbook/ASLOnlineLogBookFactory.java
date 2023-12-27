/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.logbook;

import de.vw.mib.asl.api.logbook.ASLOnlineLogBookAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLOnlineLogBookFactory
extends ASLFactoryBase {
    private static ASLOnlineLogBookAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$logbook$ASLOnlineLogBookFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLOnlineLogBookAPI getLogBookApi() {
        Class clazz = class$de$vw$mib$asl$api$logbook$ASLOnlineLogBookFactory == null ? (class$de$vw$mib$asl$api$logbook$ASLOnlineLogBookFactory = ASLOnlineLogBookFactory.class$("de.vw.mib.asl.api.logbook.ASLOnlineLogBookFactory")) : class$de$vw$mib$asl$api$logbook$ASLOnlineLogBookFactory;
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

