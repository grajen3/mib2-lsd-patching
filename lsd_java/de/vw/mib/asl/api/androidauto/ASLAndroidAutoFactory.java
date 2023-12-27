/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.androidauto;

import de.vw.mib.asl.api.androidauto.ASLAndroidAutoAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLAndroidAutoFactory
extends ASLFactoryBase {
    private static ASLAndroidAutoAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$androidauto$ASLAndroidAutoAPI;

    public static ASLAndroidAutoAPI getAndroidAutoApi() {
        if (apiInstance == null) {
            apiInstance = (ASLAndroidAutoAPI)ASLAndroidAutoFactory.createServiceInstance(class$de$vw$mib$asl$api$androidauto$ASLAndroidAutoAPI == null ? (class$de$vw$mib$asl$api$androidauto$ASLAndroidAutoAPI = ASLAndroidAutoFactory.class$("de.vw.mib.asl.api.androidauto.ASLAndroidAutoAPI")) : class$de$vw$mib$asl$api$androidauto$ASLAndroidAutoAPI, "de.vw.mib.asl.internal.androidauto.api.impl.ASLAndroidAutoAPIImpl");
        }
        return apiInstance;
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

