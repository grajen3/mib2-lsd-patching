/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.console;

import de.vw.mib.asl.framework.api.console.ASLConsoleAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLConsoleFactory
extends ASLFactoryBase {
    private static ASLConsoleAPI consoleApiInstance;
    private static boolean getConsoleApiEntered;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$console$ASLConsoleAPI;

    public static void putServiceInstantiation(ASLConsoleAPI aSLConsoleAPI) {
        ASLConsoleFactory.registerAPIService(class$de$vw$mib$asl$framework$api$console$ASLConsoleAPI == null ? (class$de$vw$mib$asl$framework$api$console$ASLConsoleAPI = ASLConsoleFactory.class$("de.vw.mib.asl.framework.api.console.ASLConsoleAPI")) : class$de$vw$mib$asl$framework$api$console$ASLConsoleAPI, aSLConsoleAPI);
        consoleApiInstance = aSLConsoleAPI;
    }

    public static ASLConsoleAPI getConsoleApi() {
        getConsoleApiEntered = true;
        if (consoleApiInstance == null) {
            consoleApiInstance = (ASLConsoleAPI)ASLConsoleFactory.createServiceInstance(class$de$vw$mib$asl$framework$api$console$ASLConsoleAPI == null ? (class$de$vw$mib$asl$framework$api$console$ASLConsoleAPI = ASLConsoleFactory.class$("de.vw.mib.asl.framework.api.console.ASLConsoleAPI")) : class$de$vw$mib$asl$framework$api$console$ASLConsoleAPI, "de.vw.mib.asl.framework.internal.console.api.impl.ASLConsoleAPIImpl");
        }
        getConsoleApiEntered = false;
        return consoleApiInstance;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        ASLConsoleFactory.getConsoleApi();
        consoleApiInstance = null;
        getConsoleApiEntered = false;
    }
}

