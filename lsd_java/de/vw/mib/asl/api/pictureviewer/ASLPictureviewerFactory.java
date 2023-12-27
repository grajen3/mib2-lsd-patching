/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.pictureviewer;

import de.vw.mib.asl.api.pictureviewer.ASLPictureviewerAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLPictureviewerFactory
extends ASLFactoryBase {
    private static ASLPictureviewerAPI pictureviewerApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$pictureviewer$ASLPictureviewerAPI;

    public static ASLPictureviewerAPI getPictureviewerApi() {
        if (pictureviewerApiInstance == null) {
            pictureviewerApiInstance = (ASLPictureviewerAPI)ASLPictureviewerFactory.createServiceInstance(class$de$vw$mib$asl$api$pictureviewer$ASLPictureviewerAPI == null ? (class$de$vw$mib$asl$api$pictureviewer$ASLPictureviewerAPI = ASLPictureviewerFactory.class$("de.vw.mib.asl.api.pictureviewer.ASLPictureviewerAPI")) : class$de$vw$mib$asl$api$pictureviewer$ASLPictureviewerAPI, "de.vw.mib.asl.internal.pictureviewer.api.impl.ASLPictureviewerAPIImpl");
        }
        return pictureviewerApiInstance;
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

