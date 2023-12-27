/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.hasServiceBridge;

import de.vw.mib.asl.internal.internetbrowser.hasServiceBridge.BrowserServiceBridgeController;
import de.vw.mib.asl.internal.internetbrowser.hasServiceBridge.DSIHASImpl;
import de.vw.mib.log4mib.Logger;

public final class BrowserServiceBridge {
    private static Logger logger;
    private static DSIHASImpl hasImpl;
    private static BrowserServiceBridgeController controller;

    public static void setLogger(Logger logger) {
        BrowserServiceBridge.logger = logger;
    }

    public static void setDSIHASImpl(DSIHASImpl dSIHASImpl) {
        hasImpl = dSIHASImpl;
    }

    public static DSIHASImpl getDSIHASImpl() {
        return hasImpl;
    }

    public static BrowserServiceBridgeController getBrowserServiceBridgeController() {
        if (controller == null) {
            controller = new BrowserServiceBridgeController(logger);
        }
        return controller;
    }
}

