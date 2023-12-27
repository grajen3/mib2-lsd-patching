/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.startupanimation;

import de.vw.mib.asl.api.startupanimation.ASLStartupAnimationAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLStartupAnimationFactory
extends ASLFactoryBase {
    private static ASLStartupAnimationAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$startupanimation$ASLStartupAnimationFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLStartupAnimationAPI getStartupAnimationApi() {
        Class clazz = class$de$vw$mib$asl$api$startupanimation$ASLStartupAnimationFactory == null ? (class$de$vw$mib$asl$api$startupanimation$ASLStartupAnimationFactory = ASLStartupAnimationFactory.class$("de.vw.mib.asl.api.startupanimation.ASLStartupAnimationFactory")) : class$de$vw$mib$asl$api$startupanimation$ASLStartupAnimationFactory;
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

