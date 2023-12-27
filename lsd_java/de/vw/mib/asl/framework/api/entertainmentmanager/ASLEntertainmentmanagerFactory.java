/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLEntertainmentmanagerFactory
extends ASLFactoryBase {
    private static ASLEntertainmentmanagerAPI entertainmentmanagerApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$ASLEntertainmentmanagerAPI;

    public static ASLEntertainmentmanagerAPI getEntertainmentmanagerApi() {
        if (entertainmentmanagerApiInstance == null) {
            entertainmentmanagerApiInstance = (ASLEntertainmentmanagerAPI)ASLEntertainmentmanagerFactory.createServiceInstance(class$de$vw$mib$asl$framework$api$entertainmentmanager$ASLEntertainmentmanagerAPI == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$ASLEntertainmentmanagerAPI = ASLEntertainmentmanagerFactory.class$("de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerAPI")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$ASLEntertainmentmanagerAPI, "de.vw.mib.asl.framework.internal.entertainmentmanager.api.impl.ASLEntertainmentmanagerAPIImpl");
        }
        return entertainmentmanagerApiInstance;
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

