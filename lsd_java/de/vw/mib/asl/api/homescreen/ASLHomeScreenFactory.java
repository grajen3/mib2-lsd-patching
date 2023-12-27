/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.homescreen;

import de.vw.mib.asl.api.homescreen.ASLHomeScreenAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLHomeScreenFactory
extends ASLFactoryBase {
    private static ASLHomeScreenAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$homescreen$ASLHomeScreenFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$homescreen$ASLHomeScreenAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLHomeScreenAPI getHomeScreenApi() {
        Class clazz = class$de$vw$mib$asl$api$homescreen$ASLHomeScreenFactory == null ? (class$de$vw$mib$asl$api$homescreen$ASLHomeScreenFactory = ASLHomeScreenFactory.class$("de.vw.mib.asl.api.homescreen.ASLHomeScreenFactory")) : class$de$vw$mib$asl$api$homescreen$ASLHomeScreenFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLHomeScreenAPI)ASLHomeScreenFactory.createServiceInstance(class$de$vw$mib$asl$api$homescreen$ASLHomeScreenAPI == null ? (class$de$vw$mib$asl$api$homescreen$ASLHomeScreenAPI = ASLHomeScreenFactory.class$("de.vw.mib.asl.api.homescreen.ASLHomeScreenAPI")) : class$de$vw$mib$asl$api$homescreen$ASLHomeScreenAPI, "de.vw.mib.asl.internal.homescreen.api.impl.ASLHomeScreenAPIImpl");
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

