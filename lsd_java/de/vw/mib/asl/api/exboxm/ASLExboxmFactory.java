/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exboxm;

import de.vw.mib.asl.api.exboxm.ASLExboxmAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLExboxmFactory
extends ASLFactoryBase {
    private static ASLExboxmAPI exboxmApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$exboxm$ASLExboxmAPI;

    public static ASLExboxmAPI getExboxmApi() {
        if (exboxmApiInstance == null) {
            exboxmApiInstance = (ASLExboxmAPI)ASLExboxmFactory.createServiceInstance(class$de$vw$mib$asl$api$exboxm$ASLExboxmAPI == null ? (class$de$vw$mib$asl$api$exboxm$ASLExboxmAPI = ASLExboxmFactory.class$("de.vw.mib.asl.api.exboxm.ASLExboxmAPI")) : class$de$vw$mib$asl$api$exboxm$ASLExboxmAPI, "de.vw.mib.asl.internal.exboxm.api.impl.ASLExboxmAPIImpl");
        }
        return exboxmApiInstance;
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

