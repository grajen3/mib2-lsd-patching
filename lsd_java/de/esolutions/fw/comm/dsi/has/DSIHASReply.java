/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has;

import org.dsi.ifc.has.HASDataContainer;

public interface DSIHASReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void actionRequest(int n, int n2, HASDataContainer[] hASDataContainerArray) {
    }

    default public void subscribeRequest(int n, int n2) {
    }

    default public void unsubscribeRequest(int n) {
    }

    default public void unsubscribeAllRequest() {
    }

    default public void getPropertyRequest(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

