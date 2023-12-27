/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.servicebridge;

import de.vw.mib.asl.api.online.servicebridge.ASLOnlineServiceBridge;
import de.vw.mib.asl.api.online.servicebridge.ASLOnlineServiceBridgeResult;

public final class ASLOnlineServiceBridgeFactory {
    private static final ASLOnlineServiceBridgeFactory INSTANCE = new ASLOnlineServiceBridgeFactory();
    private static ASLOnlineServiceBridgeResult registeredContext;
    private final ASLOnlineServiceBridge serviceBridge = (ASLOnlineServiceBridge)ASLOnlineServiceBridgeFactory.createAPIInstance(class$de$vw$mib$asl$api$online$servicebridge$ASLOnlineServiceBridge == null ? (class$de$vw$mib$asl$api$online$servicebridge$ASLOnlineServiceBridge = ASLOnlineServiceBridgeFactory.class$("de.vw.mib.asl.api.online.servicebridge.ASLOnlineServiceBridge")) : class$de$vw$mib$asl$api$online$servicebridge$ASLOnlineServiceBridge);
    static /* synthetic */ Class class$de$vw$mib$asl$api$online$servicebridge$ASLOnlineServiceBridge;

    public static ASLOnlineServiceBridgeFactory getInstance() {
        return INSTANCE;
    }

    private ASLOnlineServiceBridgeFactory() {
    }

    public ASLOnlineServiceBridge getServiceBridge() {
        return this.serviceBridge;
    }

    private static Object createAPIInstance(Class clazz) {
        String string = clazz.getName();
        int n = string.lastIndexOf(46);
        string = new StringBuffer().append("de.vw.mib.asl.internal.online.servicebridge").append(string.substring(n)).append("Impl").toString();
        return ASLOnlineServiceBridgeFactory.createInstance(string);
    }

    private static Object createInstance(String string) {
        Object object;
        try {
            Class clazz = Class.forName(string);
            object = clazz.newInstance();
        }
        catch (Exception exception) {
            object = null;
        }
        return object;
    }

    public static void registerContextForResult(ASLOnlineServiceBridgeResult aSLOnlineServiceBridgeResult) {
        registeredContext = aSLOnlineServiceBridgeResult;
    }

    public static ASLOnlineServiceBridgeResult getServiceBridgeResult() {
        return registeredContext;
    }

    public static boolean isContextRegistered() {
        boolean bl = false;
        if (registeredContext != null) {
            bl = true;
        }
        return bl;
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

