/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.testmode;

import de.vw.mib.asl.api.testmode.ASLTestmodeAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLTestmodeFactory
extends ASLFactoryBase {
    private static ASLTestmodeAPI testmodeApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$testmode$ASLTestmodeAPI;

    public static ASLTestmodeAPI getTestmodeApi() {
        if (testmodeApiInstance == null) {
            testmodeApiInstance = (ASLTestmodeAPI)ASLTestmodeFactory.createServiceInstance(class$de$vw$mib$asl$api$testmode$ASLTestmodeAPI == null ? (class$de$vw$mib$asl$api$testmode$ASLTestmodeAPI = ASLTestmodeFactory.class$("de.vw.mib.asl.api.testmode.ASLTestmodeAPI")) : class$de$vw$mib$asl$api$testmode$ASLTestmodeAPI, "de.vw.mib.asl.internal.testmode.api.impl.ASLTestmodeAPIImpl");
        }
        return testmodeApiInstance;
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

