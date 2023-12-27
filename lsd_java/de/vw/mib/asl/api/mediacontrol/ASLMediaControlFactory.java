/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol;

import de.vw.mib.asl.api.mediacontrol.ASLMediaControlAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLMediaControlFactory
extends ASLFactoryBase {
    private static ASLMediaControlAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$mediacontrol$ASLMediaControlFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$mediacontrol$ASLMediaControlAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLMediaControlAPI getMediaControlApi() {
        Class clazz = class$de$vw$mib$asl$api$mediacontrol$ASLMediaControlFactory == null ? (class$de$vw$mib$asl$api$mediacontrol$ASLMediaControlFactory = ASLMediaControlFactory.class$("de.vw.mib.asl.api.mediacontrol.ASLMediaControlFactory")) : class$de$vw$mib$asl$api$mediacontrol$ASLMediaControlFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLMediaControlAPI)ASLMediaControlFactory.createServiceInstance(class$de$vw$mib$asl$api$mediacontrol$ASLMediaControlAPI == null ? (class$de$vw$mib$asl$api$mediacontrol$ASLMediaControlAPI = ASLMediaControlFactory.class$("de.vw.mib.asl.api.mediacontrol.ASLMediaControlAPI")) : class$de$vw$mib$asl$api$mediacontrol$ASLMediaControlAPI, "de.vw.mib.asl.internal.mediacontrol.api.impl.ASLMediaControlAPIImpl");
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

