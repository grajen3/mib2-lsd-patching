/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput;

public final class StartEntryMode {
    private static int entryMode = -1;

    public static int getMode() {
        return entryMode;
    }

    public static void setMode(int n) {
        entryMode = n;
    }
}

