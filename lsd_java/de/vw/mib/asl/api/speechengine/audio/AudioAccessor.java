/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.audio;

public interface AudioAccessor {
    public static final int USE_CASE_PHONE;
    public static final int USE_CASE_MEDIA;
    public static final int USE_CASE_TUNER;
    public static final int USE_CASE_NAVI;

    default public void hangOn(int n, int n2) {
    }

    default public void letGo(int n) {
    }

    default public void requestSpeechOutputConnection() {
    }

    default public void releaseSpeechOutputConnection() {
    }
}

