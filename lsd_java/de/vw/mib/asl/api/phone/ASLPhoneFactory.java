/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone;

import de.vw.mib.asl.api.phone.ASLPhoneAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLPhoneFactory
extends ASLFactoryBase {
    private static ASLPhoneAPI phoneApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$ASLPhoneAPI;

    public static ASLPhoneAPI getPhoneApi() {
        if (phoneApiInstance == null) {
            phoneApiInstance = (ASLPhoneAPI)ASLPhoneFactory.createServiceInstance(class$de$vw$mib$asl$api$phone$ASLPhoneAPI == null ? (class$de$vw$mib$asl$api$phone$ASLPhoneAPI = ASLPhoneFactory.class$("de.vw.mib.asl.api.phone.ASLPhoneAPI")) : class$de$vw$mib$asl$api$phone$ASLPhoneAPI, "de.vw.mib.asl.internal.phone.api.impl.ASLPhoneAPIImpl");
        }
        return phoneApiInstance;
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

