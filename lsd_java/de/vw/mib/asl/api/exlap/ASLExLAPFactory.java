/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exlap;

import de.vw.mib.asl.api.exlap.ASLExLAPAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLExLAPFactory
extends ASLFactoryBase {
    private static ASLExLAPAPI exlapApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$exlap$ASLExLAPAPI;

    public static ASLExLAPAPI getExLAPApi() {
        if (exlapApiInstance == null) {
            exlapApiInstance = (ASLExLAPAPI)ASLExLAPFactory.createServiceInstance(class$de$vw$mib$asl$api$exlap$ASLExLAPAPI == null ? (class$de$vw$mib$asl$api$exlap$ASLExLAPAPI = ASLExLAPFactory.class$("de.vw.mib.asl.api.exlap.ASLExLAPAPI")) : class$de$vw$mib$asl$api$exlap$ASLExLAPAPI, "de.vw.mib.asl.internal.exlap.api.impl.ASLExLAPAPIImpl");
        }
        return exlapApiInstance;
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

