/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mirrorlink;

import de.vw.mib.asl.api.mirrorlink.ASLMirrorlinkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLMirrorlinkFactory
extends ASLFactoryBase {
    private static ASLMirrorlinkAPI mirrorlinkApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$mirrorlink$ASLMirrorlinkAPI;

    public static ASLMirrorlinkAPI getMirrorlinkApi() {
        if (mirrorlinkApiInstance == null) {
            mirrorlinkApiInstance = (ASLMirrorlinkAPI)ASLMirrorlinkFactory.createServiceInstance(class$de$vw$mib$asl$api$mirrorlink$ASLMirrorlinkAPI == null ? (class$de$vw$mib$asl$api$mirrorlink$ASLMirrorlinkAPI = ASLMirrorlinkFactory.class$("de.vw.mib.asl.api.mirrorlink.ASLMirrorlinkAPI")) : class$de$vw$mib$asl$api$mirrorlink$ASLMirrorlinkAPI, "de.vw.mib.asl.internal.mirrorlink.api.impl.ASLMirrorlinkAPIImpl");
        }
        return mirrorlinkApiInstance;
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

