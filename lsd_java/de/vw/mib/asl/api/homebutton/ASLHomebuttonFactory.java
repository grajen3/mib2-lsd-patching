/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.homebutton;

import de.vw.mib.asl.api.homebutton.ASLHomebuttonAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLHomebuttonFactory
extends ASLFactoryBase {
    private static ASLHomebuttonAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$homebutton$ASLHomebuttonFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLHomebuttonAPI getHomebuttonApi() {
        Class clazz = class$de$vw$mib$asl$api$homebutton$ASLHomebuttonFactory == null ? (class$de$vw$mib$asl$api$homebutton$ASLHomebuttonFactory = ASLHomebuttonFactory.class$("de.vw.mib.asl.api.homebutton.ASLHomebuttonFactory")) : class$de$vw$mib$asl$api$homebutton$ASLHomebuttonFactory;
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

