/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler;

public interface TtsHandler {
    default public short getSourceId() {
    }

    default public void responseSpeakPrompt(short s, int n) {
    }

    default public void responseAudioTrigger(short s, int n) {
    }

    default public void responsePlayTone(short s, int n) {
    }

    default public void updateAudioRequest(int n, int n2) {
    }
}

