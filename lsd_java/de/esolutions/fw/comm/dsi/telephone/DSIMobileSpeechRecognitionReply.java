/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

public interface DSIMobileSpeechRecognitionReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateSpeechRecognitionAvailable(int n, int n2) {
    }

    default public void updateSpeechRecognitionActive(int n, int n2) {
    }

    default public void updateSpeechRecognitionType(int n, int n2) {
    }

    default public void responseStartSpeechRecognition(int n) {
    }

    default public void responseStopSpeechRecognition(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

