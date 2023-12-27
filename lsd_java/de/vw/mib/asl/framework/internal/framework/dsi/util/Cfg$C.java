/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIProxyException;

public final class Cfg$C {
    private static int[] instancesDepObjStartPositions;
    private static int[] listenerAsyncExcMsIds;
    private static boolean init;

    public static int[] getInstancesDepObjStartPositions() {
        if (!init) {
            Cfg$C.init();
        }
        return instancesDepObjStartPositions;
    }

    private static int[] getListenerAsyncExcMsIds() {
        if (!init) {
            Cfg$C.init();
        }
        return listenerAsyncExcMsIds;
    }

    public static int getListenerAsyncExceptionId(int n) {
        return Cfg$C.getListenerAsyncExcMsIds()[n];
    }

    static void init() {
        try {
            Class clazz = Class.forName("de.vw.mib.asl.framework.internal.dsiproxy.lr.CCC");
            Object[] objectArray = (Object[])clazz.getField("CFG").get(null);
            instancesDepObjStartPositions = (int[])objectArray[0];
            listenerAsyncExcMsIds = (int[])objectArray[1];
            init = true;
        }
        catch (Throwable throwable) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not retrieve dsi-proxy common configuration. ").append(throwable.getMessage()).log();
            }
            throw new DSIProxyException(throwable);
        }
    }

    private Cfg$C() {
    }

    static {
        init = false;
    }
}

