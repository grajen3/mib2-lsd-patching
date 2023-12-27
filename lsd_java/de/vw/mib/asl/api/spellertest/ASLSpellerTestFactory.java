/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.spellertest;

import de.vw.mib.asl.api.spellertest.ASLSpellerTestAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLSpellerTestFactory
extends ASLFactoryBase {
    private static ASLSpellerTestAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$spellertest$ASLSpellerTestFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLSpellerTestAPI getSpellerTestApi() {
        Class clazz = class$de$vw$mib$asl$api$spellertest$ASLSpellerTestFactory == null ? (class$de$vw$mib$asl$api$spellertest$ASLSpellerTestFactory = ASLSpellerTestFactory.class$("de.vw.mib.asl.api.spellertest.ASLSpellerTestFactory")) : class$de$vw$mib$asl$api$spellertest$ASLSpellerTestFactory;
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

