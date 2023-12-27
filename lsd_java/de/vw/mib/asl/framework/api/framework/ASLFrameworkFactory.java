/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.framework;

import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;

public class ASLFrameworkFactory
extends ASLFactoryBase {
    private static ASLFrameworkAPI frameworkApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI;

    public static ASLFrameworkAPI getASLFrameworkAPI() {
        if (frameworkApiInstance == null) {
            frameworkApiInstance = (ASLFrameworkAPI)ASLFrameworkFactory.createServiceInstance(class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI == null ? (class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI = ASLFrameworkFactory.class$("de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI")) : class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI, "de.vw.mib.asl.framework.internal.framework.api.impl.ASLFrameworkAPIImpl");
        }
        return frameworkApiInstance;
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

