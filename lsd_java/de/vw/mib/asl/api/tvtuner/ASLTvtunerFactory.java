/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.tvtuner;

import de.vw.mib.asl.api.tvtuner.ASLTvtunerAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLTvtunerFactory
extends ASLFactoryBase {
    private static ASLTvtunerAPI tvtunerApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$tvtuner$ASLTvtunerAPI;

    public static ASLTvtunerAPI getTvtunerApi() {
        if (tvtunerApiInstance == null) {
            tvtunerApiInstance = (ASLTvtunerAPI)ASLTvtunerFactory.createServiceInstance(class$de$vw$mib$asl$api$tvtuner$ASLTvtunerAPI == null ? (class$de$vw$mib$asl$api$tvtuner$ASLTvtunerAPI = ASLTvtunerFactory.class$("de.vw.mib.asl.api.tvtuner.ASLTvtunerAPI")) : class$de$vw$mib$asl$api$tvtuner$ASLTvtunerAPI, "de.vw.mib.asl.internal.tvtuner.api.impl.ASLTvtunerAPIImpl");
        }
        return tvtunerApiInstance;
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

