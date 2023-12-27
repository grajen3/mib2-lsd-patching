/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import org.dsi.ifc.global.CarBCSpeed;

public interface DSIOnlineTrafficLightInfoReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateTrafficLightInfo(int n, int n2, int[] nArray, int n3, int n4, int n5) {
    }

    default public void updateTrafficLightSpeed(CarBCSpeed carBCSpeed, int n) {
    }

    default public void updateTrafficLightTime(int n, int n2, int n3) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

