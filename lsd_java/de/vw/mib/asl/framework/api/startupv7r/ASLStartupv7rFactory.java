/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.startupv7r;

import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;

public class ASLStartupv7rFactory
extends ASLFactoryBase {
    private static ASLStartupv7rAPI startupv7rApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$startupv7r$ASLStartupv7rAPI;

    public static ASLStartupv7rAPI getStartupv7rApi() {
        if (startupv7rApiInstance == null) {
            startupv7rApiInstance = (ASLStartupv7rAPI)ASLStartupv7rFactory.createServiceInstance(class$de$vw$mib$asl$framework$api$startupv7r$ASLStartupv7rAPI == null ? (class$de$vw$mib$asl$framework$api$startupv7r$ASLStartupv7rAPI = ASLStartupv7rFactory.class$("de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI")) : class$de$vw$mib$asl$framework$api$startupv7r$ASLStartupv7rAPI, "de.vw.mib.asl.framework.internal.startupv7r.api.impl.ASLStartupv7rAPIImpl");
        }
        return startupv7rApiInstance;
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

