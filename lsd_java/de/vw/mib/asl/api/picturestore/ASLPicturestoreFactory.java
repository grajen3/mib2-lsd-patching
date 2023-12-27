/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.picturestore;

import de.vw.mib.asl.api.picturestore.ASLPicturestoreAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLPicturestoreFactory
extends ASLFactoryBase {
    private static ASLPicturestoreAPI picturestoreApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$picturestore$ASLPicturestoreAPI;

    public static ASLPicturestoreAPI getPicturestoreApi() {
        if (picturestoreApiInstance == null) {
            picturestoreApiInstance = (ASLPicturestoreAPI)ASLPicturestoreFactory.createServiceInstance(class$de$vw$mib$asl$api$picturestore$ASLPicturestoreAPI == null ? (class$de$vw$mib$asl$api$picturestore$ASLPicturestoreAPI = ASLPicturestoreFactory.class$("de.vw.mib.asl.api.picturestore.ASLPicturestoreAPI")) : class$de$vw$mib$asl$api$picturestore$ASLPicturestoreAPI, "de.vw.mib.asl.internal.picturestore.api.impl.ASLPicturestoreAPIImpl");
        }
        return picturestoreApiInstance;
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

