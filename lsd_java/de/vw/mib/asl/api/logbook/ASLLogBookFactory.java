/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.logbook;

import de.vw.mib.asl.api.logbook.ASLLogBookAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLLogBookFactory
extends ASLFactoryBase {
    private static ASLLogBookAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$logbook$ASLLogBookFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLLogBookAPI getLogBookApi() {
        Class clazz = class$de$vw$mib$asl$api$logbook$ASLLogBookFactory == null ? (class$de$vw$mib$asl$api$logbook$ASLLogBookFactory = ASLLogBookFactory.class$("de.vw.mib.asl.api.logbook.ASLLogBookFactory")) : class$de$vw$mib$asl$api$logbook$ASLLogBookFactory;
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

