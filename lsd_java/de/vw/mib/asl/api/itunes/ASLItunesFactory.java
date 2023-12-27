/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.itunes;

import de.vw.mib.asl.api.itunes.ASLItunesAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLItunesFactory
extends ASLFactoryBase {
    private static ASLItunesAPI itunesApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$itunes$ASLItunesAPI;

    public static ASLItunesAPI getItunesApi() {
        if (itunesApiInstance == null) {
            itunesApiInstance = (ASLItunesAPI)ASLItunesFactory.createServiceInstance(class$de$vw$mib$asl$api$itunes$ASLItunesAPI == null ? (class$de$vw$mib$asl$api$itunes$ASLItunesAPI = ASLItunesFactory.class$("de.vw.mib.asl.api.itunes.ASLItunesAPI")) : class$de$vw$mib$asl$api$itunes$ASLItunesAPI, "de.vw.mib.asl.internal.itunes.api.impl.ASLItunesAPIImpl");
        }
        return itunesApiInstance;
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

