/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.exlap;

import org.dsi.ifc.exlap.Service;

public interface DSIExlapReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void startResult(int n) {
    }

    default public void stopResult(int n) {
    }

    default public void updateAvailableServices(Service[] serviceArray, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

