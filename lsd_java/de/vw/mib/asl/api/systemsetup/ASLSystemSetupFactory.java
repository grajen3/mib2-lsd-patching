/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.systemsetup;

import de.vw.mib.asl.api.systemsetup.ASLSystemSetupAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLSystemSetupFactory
extends ASLFactoryBase {
    private static ASLSystemSetupAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$systemsetup$ASLSystemSetupFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLSystemSetupAPI getSystemSetupApi() {
        Class clazz = class$de$vw$mib$asl$api$systemsetup$ASLSystemSetupFactory == null ? (class$de$vw$mib$asl$api$systemsetup$ASLSystemSetupFactory = ASLSystemSetupFactory.class$("de.vw.mib.asl.api.systemsetup.ASLSystemSetupFactory")) : class$de$vw$mib$asl$api$systemsetup$ASLSystemSetupFactory;
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

