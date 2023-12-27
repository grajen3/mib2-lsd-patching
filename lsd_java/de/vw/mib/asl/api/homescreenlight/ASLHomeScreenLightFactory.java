/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.homescreenlight;

import de.vw.mib.asl.api.homescreenlight.ASLHomeScreenLightAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLHomeScreenLightFactory
extends ASLFactoryBase {
    private static ASLHomeScreenLightAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$homescreenlight$ASLHomeScreenLightFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLHomeScreenLightAPI getHomeScreenLightApi() {
        Class clazz = class$de$vw$mib$asl$api$homescreenlight$ASLHomeScreenLightFactory == null ? (class$de$vw$mib$asl$api$homescreenlight$ASLHomeScreenLightFactory = ASLHomeScreenLightFactory.class$("de.vw.mib.asl.api.homescreenlight.ASLHomeScreenLightFactory")) : class$de$vw$mib$asl$api$homescreenlight$ASLHomeScreenLightFactory;
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

