/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.waveplayer;

public interface DSIWavePlayerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updatePlayTone(int n, int n2) {
    }

    default public void updateAudioRequest(int n, int n2) {
    }

    default public void setPlayTone(int n) {
    }

    default public void audioTriggerResponse(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

