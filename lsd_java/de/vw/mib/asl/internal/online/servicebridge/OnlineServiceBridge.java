/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.servicebridge;

import de.vw.mib.asl.internal.online.servicebridge.DSIHASImpl;
import de.vw.mib.asl.internal.online.servicebridge.OnlineServiceBridgeController;

public final class OnlineServiceBridge {
    private static DSIHASImpl hasImpl;
    private static OnlineServiceBridgeController controller;

    public static void setDSIHASImpl(DSIHASImpl dSIHASImpl) {
        hasImpl = dSIHASImpl;
    }

    public static DSIHASImpl getDSIHASImpl() {
        return hasImpl;
    }

    public static OnlineServiceBridgeController getOnlineServiceBridgeController() {
        if (controller == null) {
            controller = new OnlineServiceBridgeController();
        }
        return controller;
    }
}

