/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio;

import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLRadioFactory
extends ASLFactoryBase {
    private static ASLRadioAPI radioApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$ASLRadioAPI;

    public static ASLRadioAPI getRadioApi() {
        if (radioApiInstance == null) {
            radioApiInstance = (ASLRadioAPI)ASLRadioFactory.createServiceInstance(class$de$vw$mib$asl$api$radio$ASLRadioAPI == null ? (class$de$vw$mib$asl$api$radio$ASLRadioAPI = ASLRadioFactory.class$("de.vw.mib.asl.api.radio.ASLRadioAPI")) : class$de$vw$mib$asl$api$radio$ASLRadioAPI, "de.vw.mib.asl.internal.radio.api.impl.ASLRadioAPIImpl");
        }
        return radioApiInstance;
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

