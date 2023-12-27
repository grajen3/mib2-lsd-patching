/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media;

import de.vw.mib.asl.api.media.ASLMediaAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLMediaFactory
extends ASLFactoryBase {
    private static ASLMediaAPI mediaApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$ASLMediaAPI;

    public static ASLMediaAPI getMediaApi() {
        if (mediaApiInstance == null) {
            mediaApiInstance = (ASLMediaAPI)ASLMediaFactory.createServiceInstance(class$de$vw$mib$asl$api$media$ASLMediaAPI == null ? (class$de$vw$mib$asl$api$media$ASLMediaAPI = ASLMediaFactory.class$("de.vw.mib.asl.api.media.ASLMediaAPI")) : class$de$vw$mib$asl$api$media$ASLMediaAPI, "de.vw.mib.asl.internal.media.api.impl.ASLMediaAPIImpl");
        }
        return mediaApiInstance;
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

