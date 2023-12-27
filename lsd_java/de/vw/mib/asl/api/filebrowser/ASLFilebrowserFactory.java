/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.filebrowser;

import de.vw.mib.asl.api.filebrowser.ASLFilebrowserAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLFilebrowserFactory
extends ASLFactoryBase {
    private static ASLFilebrowserAPI filebrowserApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$filebrowser$ASLFilebrowserAPI;

    public static ASLFilebrowserAPI getFilebrowserApi() {
        if (filebrowserApiInstance == null) {
            filebrowserApiInstance = (ASLFilebrowserAPI)ASLFilebrowserFactory.createServiceInstance(class$de$vw$mib$asl$api$filebrowser$ASLFilebrowserAPI == null ? (class$de$vw$mib$asl$api$filebrowser$ASLFilebrowserAPI = ASLFilebrowserFactory.class$("de.vw.mib.asl.api.filebrowser.ASLFilebrowserAPI")) : class$de$vw$mib$asl$api$filebrowser$ASLFilebrowserAPI, "de.vw.mib.asl.internal.filebrowser.api.impl.ASLFilebrowserAPIImpl");
        }
        return filebrowserApiInstance;
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

