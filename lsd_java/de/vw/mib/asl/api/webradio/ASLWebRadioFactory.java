/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.webradio;

import de.vw.mib.asl.api.webradio.ASLWebRadioAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLWebRadioFactory
extends ASLFactoryBase {
    private static ASLWebRadioAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$webradio$ASLWebRadioFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLWebRadioAPI getWebRadioApi() {
        Class clazz = class$de$vw$mib$asl$api$webradio$ASLWebRadioFactory == null ? (class$de$vw$mib$asl$api$webradio$ASLWebRadioFactory = ASLWebRadioFactory.class$("de.vw.mib.asl.api.webradio.ASLWebRadioFactory")) : class$de$vw$mib$asl$api$webradio$ASLWebRadioFactory;
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

