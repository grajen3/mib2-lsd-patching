/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.displaymanagement;

import de.vw.mib.asl.framework.api.displaymanagement.ASLDisplaymanagementAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLDisplaymanagementFactory
extends ASLFactoryBase {
    private static ASLDisplaymanagementAPI displaymanagementApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$displaymanagement$ASLDisplaymanagementAPI;

    public static ASLDisplaymanagementAPI getDisplaymanagementApi() {
        if (displaymanagementApiInstance == null) {
            displaymanagementApiInstance = (ASLDisplaymanagementAPI)ASLDisplaymanagementFactory.createServiceInstance(class$de$vw$mib$asl$framework$api$displaymanagement$ASLDisplaymanagementAPI == null ? (class$de$vw$mib$asl$framework$api$displaymanagement$ASLDisplaymanagementAPI = ASLDisplaymanagementFactory.class$("de.vw.mib.asl.framework.api.displaymanagement.ASLDisplaymanagementAPI")) : class$de$vw$mib$asl$framework$api$displaymanagement$ASLDisplaymanagementAPI, "de.vw.mib.asl.framework.internal.displaymanagement.api.impl.ASLDisplaymanagementAPIImpl");
        }
        return displaymanagementApiInstance;
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

