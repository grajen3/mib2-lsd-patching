/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

public final class AudioConnectionState {
    private final int value;
    public static final AudioConnectionState IDLE = new AudioConnectionState(0);
    public static final AudioConnectionState REQUESTED = new AudioConnectionState(1);
    public static final AudioConnectionState ACTIVE = new AudioConnectionState(2);
    public static final AudioConnectionState RELEASING = new AudioConnectionState(3);
    public static final AudioConnectionState RELEASED = new AudioConnectionState(4);
    public static final AudioConnectionState DENIED = new AudioConnectionState(5);
    public static final AudioConnectionState LOST = new AudioConnectionState(6);

    private AudioConnectionState(int n) {
        this.value = n;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("AudioConnectionState.");
        if (this.value == IDLE.getValue()) {
            stringBuffer.append("IDLE");
        } else if (this.value == REQUESTED.getValue()) {
            stringBuffer.append("REQUESTED");
        } else if (this.value == ACTIVE.getValue()) {
            stringBuffer.append("ACTIVE");
        } else if (this.value == RELEASING.getValue()) {
            stringBuffer.append("RELEASING");
        } else if (this.value == RELEASED.getValue()) {
            stringBuffer.append("RELEASED");
        } else if (this.value == DENIED.getValue()) {
            stringBuffer.append("DENIED");
        } else if (this.value == LOST.getValue()) {
            stringBuffer.append("LOST");
        } else {
            stringBuffer.append("UNKNOWN: ");
            stringBuffer.append(this.value);
        }
        return stringBuffer.toString();
    }

    public boolean isEqualTo(AudioConnectionState audioConnectionState) {
        if (audioConnectionState != null) {
            return this.getValue() == audioConnectionState.getValue();
        }
        return false;
    }
}

