/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.audio;

public interface DSIAudioManagementReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void errorConnection(int n, int n2, int n3) {
    }

    default public void fadedIn(int n, int n2) {
    }

    default public void pauseConnection(int n, int n2) {
    }

    default public void updateActiveConnection(int n, int n2, int n3) {
    }

    default public void updateActiveEntertainmentConnection(int n, int n2, int n3) {
    }

    default public void startConnection(int n, int n2) {
    }

    default public void stopConnection(int n, int n2) {
    }

    default public void updateAMAvailable(int n, int n2, int n3) {
    }

    default public void responseVolumelock(int n, int n2, boolean bl) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

