/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLDeviceHandlingFactory
extends ASLFactoryBase {
    private static ASLDeviceHandlingAPI deviceHandlingApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$devicehandling$ASLDeviceHandlingAPI;

    public static ASLDeviceHandlingAPI getDeviceHandlingApi() {
        if (deviceHandlingApiInstance == null) {
            deviceHandlingApiInstance = (ASLDeviceHandlingAPI)ASLDeviceHandlingFactory.createServiceInstance(class$de$vw$mib$asl$api$devicehandling$ASLDeviceHandlingAPI == null ? (class$de$vw$mib$asl$api$devicehandling$ASLDeviceHandlingAPI = ASLDeviceHandlingFactory.class$("de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingAPI")) : class$de$vw$mib$asl$api$devicehandling$ASLDeviceHandlingAPI, "de.vw.mib.asl.internal.devicehandling.api.impl.ASLDeviceHandlingAPIImpl");
        }
        return deviceHandlingApiInstance;
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

