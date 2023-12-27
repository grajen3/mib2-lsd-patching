/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radioSpeechHandling;

import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;

public final class RadioSpeechAdaptor {
    private static ASLDeviceRegistry aslDeviceRegistry = null;

    private RadioSpeechAdaptor() {
    }

    public static int getSpeechDatabaseId(int n) {
        int n2 = n << 1;
        return ++n2;
    }
}

