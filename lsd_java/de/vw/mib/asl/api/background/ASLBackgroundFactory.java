/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.background;

import de.vw.mib.asl.api.background.ASLBackgroundAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLBackgroundFactory
extends ASLFactoryBase {
    private static ASLBackgroundAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$background$ASLBackgroundFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$background$ASLBackgroundAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLBackgroundAPI getBackgroundApi() {
        Class clazz = class$de$vw$mib$asl$api$background$ASLBackgroundFactory == null ? (class$de$vw$mib$asl$api$background$ASLBackgroundFactory = ASLBackgroundFactory.class$("de.vw.mib.asl.api.background.ASLBackgroundFactory")) : class$de$vw$mib$asl$api$background$ASLBackgroundFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLBackgroundAPI)ASLBackgroundFactory.createServiceInstance(class$de$vw$mib$asl$api$background$ASLBackgroundAPI == null ? (class$de$vw$mib$asl$api$background$ASLBackgroundAPI = ASLBackgroundFactory.class$("de.vw.mib.asl.api.background.ASLBackgroundAPI")) : class$de$vw$mib$asl$api$background$ASLBackgroundAPI, "de.vw.mib.asl.internal.background.api.impl.ASLBackgroundAPIImpl");
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

