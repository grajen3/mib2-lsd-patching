/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import org.dsi.ifc.media.AudioRoute;

public interface DSIMediaRouterReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseConfiguration(int n, int n2) {
    }

    default public void responseClientStatus(int n, int n2) {
    }

    default public void updateStreamingStatus(int n, int n2, int n3) {
    }

    default public void updateActiveAudioRoutes(AudioRoute[] audioRouteArray, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

