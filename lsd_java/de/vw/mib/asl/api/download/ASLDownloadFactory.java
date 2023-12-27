/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.download;

import de.vw.mib.asl.api.download.ASLDownloadAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLDownloadFactory
extends ASLFactoryBase {
    private static ASLDownloadAPI downloadApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$download$ASLDownloadAPI;

    public static ASLDownloadAPI getDownloadApi() {
        if (downloadApiInstance == null) {
            downloadApiInstance = (ASLDownloadAPI)ASLDownloadFactory.createServiceInstance(class$de$vw$mib$asl$api$download$ASLDownloadAPI == null ? (class$de$vw$mib$asl$api$download$ASLDownloadAPI = ASLDownloadFactory.class$("de.vw.mib.asl.api.download.ASLDownloadAPI")) : class$de$vw$mib$asl$api$download$ASLDownloadAPI, "de.vw.mib.asl.internal.download.api.impl.ASLDownloadAPIImpl");
        }
        return downloadApiInstance;
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

