/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.internetbrowser;

import de.vw.mib.asl.api.internetbrowser.ASLInternetbrowserAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLInternetbrowserFactory
extends ASLFactoryBase {
    private static ASLInternetbrowserAPI internetbrowserApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$internetbrowser$ASLInternetbrowserAPI;

    public static ASLInternetbrowserAPI getInternetbrowserApi() {
        if (internetbrowserApiInstance == null) {
            internetbrowserApiInstance = (ASLInternetbrowserAPI)ASLInternetbrowserFactory.createServiceInstance(class$de$vw$mib$asl$api$internetbrowser$ASLInternetbrowserAPI == null ? (class$de$vw$mib$asl$api$internetbrowser$ASLInternetbrowserAPI = ASLInternetbrowserFactory.class$("de.vw.mib.asl.api.internetbrowser.ASLInternetbrowserAPI")) : class$de$vw$mib$asl$api$internetbrowser$ASLInternetbrowserAPI, "de.vw.mib.asl.internal.internetbrowser.api.impl.ASLInternetbrowserAPIImpl");
        }
        return internetbrowserApiInstance;
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

