/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIProxyException;

public final class Cfg$U {
    private static String[][] servicesSyncMsNs;
    private static String[][][] listenersSyncMsNs;
    private static boolean init;

    private static String[][] getServicesSyncMsNs() {
        if (!init) {
            Cfg$U.init();
        }
        return servicesSyncMsNs;
    }

    private static String[][][] getListenersSyncMsNs() {
        if (!init) {
            Cfg$U.init();
        }
        return listenersSyncMsNs;
    }

    public static String getServiceSyncMethodName(int n, int n2) {
        return Cfg$U.getServicesSyncMsNs()[n][n2];
    }

    public static String getListenerSyncMethodName(int n, int n2, int n3) {
        return Cfg$U.getListenersSyncMsNs()[n][n2][n3];
    }

    static void init() {
        try {
            Class clazz = Class.forName("de.vw.mib.asl.framework.internal.dsiproxy.lr.UCC");
            Object[] objectArray = (Object[])clazz.getField("CFG").get(null);
            servicesSyncMsNs = (String[][])objectArray[0];
            listenersSyncMsNs = (String[][][])objectArray[1];
            init = true;
        }
        catch (Throwable throwable) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not retrieve dsi-proxy util configuration. ").append(throwable.getMessage()).log();
            }
            throw new DSIProxyException(throwable);
        }
    }

    private Cfg$U() {
    }

    static {
        init = false;
    }
}

