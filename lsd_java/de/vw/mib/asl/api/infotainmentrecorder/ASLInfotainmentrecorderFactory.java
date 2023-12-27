/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.infotainmentrecorder;

import de.vw.mib.asl.api.infotainmentrecorder.ASLInfotainmentrecorderAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLInfotainmentrecorderFactory
extends ASLFactoryBase {
    private static ASLInfotainmentrecorderAPI infotainmentrecorderApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$infotainmentrecorder$ASLInfotainmentrecorderAPI;

    public static ASLInfotainmentrecorderAPI getInfotainmentrecorderApi() {
        if (infotainmentrecorderApiInstance == null) {
            infotainmentrecorderApiInstance = (ASLInfotainmentrecorderAPI)ASLInfotainmentrecorderFactory.createServiceInstance(class$de$vw$mib$asl$api$infotainmentrecorder$ASLInfotainmentrecorderAPI == null ? (class$de$vw$mib$asl$api$infotainmentrecorder$ASLInfotainmentrecorderAPI = ASLInfotainmentrecorderFactory.class$("de.vw.mib.asl.api.infotainmentrecorder.ASLInfotainmentrecorderAPI")) : class$de$vw$mib$asl$api$infotainmentrecorder$ASLInfotainmentrecorderAPI, "de.vw.mib.asl.internal.infotainmentrecorder.api.impl.ASLInfotainmentrecorderAPIImpl");
        }
        return infotainmentrecorderApiInstance;
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

