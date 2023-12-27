/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.manager;

public final class AudioConnectionManager {
    private static int lastRequestedWaveband = 1;

    public static void setLastRequestedWaveband(int n) {
        lastRequestedWaveband = n;
    }

    public static int getLastRequestedWaveband() {
        return lastRequestedWaveband;
    }
}

