/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.asiainput;

import de.vw.mib.asl.api.asiainput.ASLAsiainputAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLAsiainputFactory
extends ASLFactoryBase {
    private static ASLAsiainputAPI asiainputApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$asiainput$ASLAsiainputAPI;

    public static ASLAsiainputAPI getAsiainputApi() {
        if (asiainputApiInstance == null) {
            asiainputApiInstance = (ASLAsiainputAPI)ASLAsiainputFactory.createServiceInstance(class$de$vw$mib$asl$api$asiainput$ASLAsiainputAPI == null ? (class$de$vw$mib$asl$api$asiainput$ASLAsiainputAPI = ASLAsiainputFactory.class$("de.vw.mib.asl.api.asiainput.ASLAsiainputAPI")) : class$de$vw$mib$asl$api$asiainput$ASLAsiainputAPI, "de.vw.mib.asl.internal.asiainput.api.impl.ASLAsiainputAPIImpl");
        }
        return asiainputApiInstance;
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

